package org.rbh.tfcadditions.Blocks.CarpentersBlocks;

import com.bioxx.tfc.Items.Tools.ItemChisel;
import com.bioxx.tfc.Items.Tools.ItemHammer;
import com.carpentersblocks.block.BlockCoverable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Direction;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import com.carpentersblocks.api.ICarpentersChisel;
import com.carpentersblocks.api.ICarpentersHammer;
import com.carpentersblocks.tileentity.TEBase;
import com.carpentersblocks.util.BlockProperties;
import com.carpentersblocks.util.EntityLivingUtil;
import com.carpentersblocks.util.handler.EventHandler;
import com.carpentersblocks.util.protection.PlayerPermissions;
import com.carpentersblocks.util.registry.FeatureRegistry;

public class TFCBlockCoverable extends BlockCoverable {


    /**
     * Stores actions taken on a block in order to properly play sounds,
     * decrement player inventory, and to determine if a block was altered.
     */
    protected class ActionResult {

        public ItemStack itemStack;
        public boolean playSound = true;
        public boolean altered = false;
        public boolean decInv = false;

        public ActionResult setSoundSource(ItemStack itemStack) {
            this.itemStack = itemStack;
            return this;
        }

        public ActionResult setNoSound() {
            playSound = false;
            return this;
        }

        public ActionResult setAltered() {
            altered = true;
            return this;
        }

        public ActionResult decInventory() {
            decInv = true;
            return this;
        }

    }

    /**
     * Class constructor.
     *
     * @param material
     */
    public TFCBlockCoverable(Material material)
    {
        super(material);
    }

    @Override
    /**
     * Called when the block is clicked by a player. Args: x, y, z, entityPlayer
     */
    public void onBlockClicked(World world, int x, int y, int z, EntityPlayer entityPlayer)
    {
        if (world.isRemote) {
            return;
        }

        TEBase TE = getTileEntity(world, x, y, z);

        if (TE == null) {
            return;
        } else if (!PlayerPermissions.canPlayerEdit(TE, TE.xCoord, TE.yCoord, TE.zCoord, entityPlayer)) {
            return;
        }

        ItemStack itemStack = entityPlayer.getCurrentEquippedItem();

        if (itemStack == null) {
            return;
        }

        int effectiveSide = TE.hasAttribute(TE.ATTR_COVER[EventHandler.eventFace]) ? EventHandler.eventFace : 6;
        Item item = itemStack.getItem();

        if (item instanceof ItemHammer) {

            ActionResult actionResult = new ActionResult();
            //preOnBlockClicked(TE, world, x, y, z, entityPlayer, actionResult);

            if (!actionResult.altered) {
                if (entityPlayer.isSneaking()) {
                    popAttribute(TE, effectiveSide);
                } else {
                    onHammerLeftClick(TE, entityPlayer);
                }
                actionResult.setAltered();
            } else {
                onNeighborBlockChange(world, x, y, z, this);
                world.notifyBlocksOfNeighborChange(x, y, z, this);
            }

        } else if (item instanceof ItemChisel) {

            if (entityPlayer.isSneaking() && TE.hasChiselDesign(effectiveSide)) {
                TE.removeChiselDesign(effectiveSide);
            } else if (TE.hasAttribute(TE.ATTR_COVER[effectiveSide])) {
                onChiselClick(TE, effectiveSide, true);
            }

        }
    }

    /**
     * Pops attribute in hard-coded order.
     *
     * @param TE
     * @param side
     */
    private void popAttribute(TEBase TE, int side)
    {
        if (TE.hasAttribute(TE.ATTR_ILLUMINATOR)) {
            TE.createBlockDropEvent(TE.ATTR_ILLUMINATOR);
        } else if (TE.hasAttribute(TE.ATTR_OVERLAY[side])) {
            TE.createBlockDropEvent(TE.ATTR_OVERLAY[side]);
        } else if (TE.hasAttribute(TE.ATTR_DYE[side])) {
            TE.createBlockDropEvent(TE.ATTR_DYE[side]);
        } else if (TE.hasAttribute(TE.ATTR_COVER[side])) {
            TE.removeChiselDesign(side);
            TE.createBlockDropEvent(TE.ATTR_COVER[side]);
        }
    }

    @Override
    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityPlayer, int side, float hitX, float hitY, float hitZ)
    {
        if (world.isRemote) {
            return true;
        }

        TEBase TE = getTileEntity(world, x, y, z);

        if (TE == null) {
            return false;
        }

        if (!canPlayerActivate(TE, entityPlayer)) {
            return false;
        }

        // Allow block to change TE if needed before altering attributes
        TE = getTileEntityForBlockActivation(TE);
        ActionResult actionResult = new ActionResult();

        //preOnBlockActivated(TE, entityPlayer, side, hitX, hitY, hitZ, actionResult);

        // If no prior event occurred, try regular activation
        if (!actionResult.altered) {

            if (PlayerPermissions.canPlayerEdit(TE, TE.xCoord, TE.yCoord, TE.zCoord, entityPlayer)) {

                ItemStack itemStack = entityPlayer.getCurrentEquippedItem();

                if (itemStack != null) {

                    /* Sides 0-5 are side covers, and 6 is the base block. */
                    int effectiveSide = TE.hasAttribute(TE.ATTR_COVER[side]) ? side : 6;

                    if (itemStack.getItem() instanceof ItemHammer) {

                        if (onHammerRightClick(TE, entityPlayer)) {
                            actionResult.setAltered();
                        }

                    } else if (itemStack.getItem() instanceof ItemChisel) {

                        if (TE.hasAttribute(TE.ATTR_COVER[effectiveSide])) {
                            if (onChiselClick(TE, effectiveSide, false)) {
                                actionResult.setAltered();
                            }
                        }

                    } else if (FeatureRegistry.enableCovers && BlockProperties.isCover(itemStack)) {

                        Block block = BlockProperties.toBlock(itemStack);

                        /* Will handle blocks that save directions using only y axis (pumpkin) */
                        int metadata = block instanceof BlockDirectional ? MathHelper.floor_double(entityPlayer.rotationYaw * 4.0F / 360.0F + 2.5D) & 3 : itemStack.getItemDamage();

                        /* Will handle blocks that save directions using all axes (logs, quartz) */
                        if (BlockProperties.blockRotates(itemStack)) {
                            int rot = Direction.rotateOpposite[EntityLivingUtil.getRotationValue(entityPlayer)];
                            int side_interpolated = entityPlayer.rotationPitch < -45.0F ? 0 : entityPlayer.rotationPitch > 45 ? 1 : rot == 0 ? 3 : rot == 1 ? 4 : rot == 2 ? 2 : 5;
                            metadata = block.onBlockPlaced(world, TE.xCoord, TE.yCoord, TE.zCoord, side_interpolated, hitX, hitY, hitZ, metadata);
                        }

                        ItemStack tempStack = itemStack.copy();
                        tempStack.setItemDamage(metadata);

                        /* Base cover should always be checked. */

                        if (effectiveSide == 6 && (!canCoverSide(TE, world, TE.xCoord, TE.yCoord, TE.zCoord, 6) || TE.hasAttribute(TE.ATTR_COVER[6]))) {
                            effectiveSide = side;
                        }

                        if (canCoverSide(TE, world, TE.xCoord, TE.yCoord, TE.zCoord, effectiveSide) && !TE.hasAttribute(TE.ATTR_COVER[effectiveSide])) {
                            TE.addAttribute(TE.ATTR_COVER[effectiveSide], tempStack);
                            actionResult.setAltered().decInventory().setSoundSource(itemStack);
                        }

                    } else if (entityPlayer.isSneaking()) {

                        if (FeatureRegistry.enableIllumination && BlockProperties.isIlluminator(itemStack)) {
                            if (!TE.hasAttribute(TE.ATTR_ILLUMINATOR)) {
                                TE.addAttribute(TE.ATTR_ILLUMINATOR, itemStack);
                                actionResult.setAltered().decInventory().setSoundSource(itemStack);
                            }
                        } else if (FeatureRegistry.enableOverlays && BlockProperties.isOverlay(itemStack)) {
                            if (!TE.hasAttribute(TE.ATTR_OVERLAY[effectiveSide]) && (effectiveSide < 6 && TE.hasAttribute(TE.ATTR_COVER[effectiveSide]) || effectiveSide == 6)) {
                                TE.addAttribute(TE.ATTR_OVERLAY[effectiveSide], itemStack);
                                actionResult.setAltered().decInventory().setSoundSource(itemStack);
                            }
                        } else if (FeatureRegistry.enableDyeColors && BlockProperties.isDye(itemStack, false)) {
                            if (!TE.hasAttribute(TE.ATTR_DYE[effectiveSide])) {
                                TE.addAttribute(TE.ATTR_DYE[effectiveSide], itemStack);
                                actionResult.setAltered().decInventory().setSoundSource(itemStack);
                            }
                        }

                    }
                }
            }
        }

        if (!actionResult.altered) {

            // If no prior or regular event occurred, try a post event
            //postOnBlockActivated(TE, entityPlayer, side, hitX, hitY, hitZ, actionResult);

        } else {

            if (actionResult.itemStack == null) {
                actionResult.setSoundSource(BlockProperties.getCover(TE, 6));
            }
            damageItemWithChance(world, entityPlayer);
            onNeighborBlockChange(world, TE.xCoord, TE.yCoord, TE.zCoord, this);
            world.notifyBlocksOfNeighborChange(TE.xCoord, TE.yCoord, TE.zCoord, this);

        }

        if (actionResult.playSound) {
            BlockProperties.playBlockSound(TE.getWorldObj(), actionResult.itemStack, TE.xCoord, TE.yCoord, TE.zCoord, false);
        }

        if (actionResult.decInv) {
            EntityLivingUtil.decrementCurrentSlot(entityPlayer);
        }

        return actionResult.altered;
    }

    /**
     * Indicates whether block destruction should be suppressed when block is clicked.
     * Will return true if player is holding a Carpenter's tool in creative mode.
     */
    protected boolean suppressDestroyBlock(EntityPlayer entityPlayer)
    {
        if (entityPlayer == null) {
            return false;
        }

        ItemStack itemStack = entityPlayer.getHeldItem();

        if (itemStack != null) {
            Item item = itemStack.getItem();
            return entityPlayer.capabilities.isCreativeMode && item != null && (item instanceof ICarpentersHammer || item instanceof ICarpentersChisel);
        }

        return false;
    }

    @Override
    /**
     * Gets the hardness of block at the given coordinates in the given world, relative to the ability of the given
     * EntityPlayer.
     */
    public float getPlayerRelativeBlockHardness(EntityPlayer entityPlayer, World world, int x, int y, int z)
    {
        /* Don't damage block if holding Carpenter's tool. */

        ItemStack itemStack = entityPlayer.getHeldItem();

        if (itemStack != null) {
            Item item = itemStack.getItem();
            if (item instanceof ItemHammer || item instanceof ItemChisel) {
                return -1;
            }
        }

        /* Return block hardness of cover. */

        TEBase TE = getTileEntity(world, x, y, z);

        if (TE != null) {
            return ForgeHooks.blockStrength(BlockProperties.toBlock(BlockProperties.getCover(TE, 6)), entityPlayer, world, x, y, z);
        } else {
            return super.getPlayerRelativeBlockHardness(entityPlayer, world, x, y, z);
        }
    }
}
