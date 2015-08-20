package org.rbh.tfcadditions.Blocks.Planks;

import com.bioxx.tfc.Blocks.BlockTerra;
import com.bioxx.tfc.Core.TFCTabs;
import com.bioxx.tfc.Items.Tools.ItemHammer;
import com.bioxx.tfc.api.Tools.IToolChisel;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import org.rbh.tfcadditions.Blocks.BlockSetup;
import org.rbh.tfcadditions.Reference.Names;
import org.rbh.tfcadditions.Reference.Reference;

import java.util.List;

/**
 * Created by raymondbh on 20.08.2015.
 */
public class BlockPlanksLarge extends BlockTerra
{
    String[] names;
    IIcon[] icons;

    public BlockPlanksLarge()
    {
        super(Material.wood);
        this.setCreativeTab(TFCTabs.TFCBuilding);
        names = new String[16];
        System.arraycopy(Names.WOOD_ALL, 0, names, 0, 16);
        icons = new IIcon[names.length];
    }

    @SideOnly(Side.CLIENT)
    @Override
    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List list)
    {
        for(int i = 0; i < names.length; i++)
            list.add(new ItemStack(this,1,i));
    }

    @Override
    public int damageDropped(int j)
    {
        return j;
    }

    @Override
    public IIcon getIcon(int side, int meta)
    {
        if(meta < 0)
            return icons[0];
        if(meta < icons.length)
            return icons[meta];
        return BlockSetup.PlanksLarge2.getIcon(side, meta - 16);
    }

    @Override
    public void registerBlockIcons(IIconRegister registerer)
    {
        for(int meta = 0; meta < names.length; meta++)
            icons[meta] = registerer.registerIcon(Reference.ModID + ":" + "wood/"+names[meta]+" Plank Large");
        //Blocks.planks.registerBlockIcons(registerer);
    }

    /**
     * Called when the block is clicked by a player. Args: x, y, z, entityPlayer
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityplayer, int side, float par7, float par8, float par9)
    {
        boolean hasHammer = false;
        for(int i = 0; i < 9;i++)
            if(entityplayer.inventory.mainInventory[i] != null && entityplayer.inventory.mainInventory[i].getItem() instanceof ItemHammer)
                hasHammer = true;
        if(!world.isRemote && entityplayer.getCurrentEquippedItem() != null &&
                entityplayer.getCurrentEquippedItem().getItem() instanceof IToolChisel &&
                hasHammer && ((IToolChisel)entityplayer.getCurrentEquippedItem().getItem()).canChisel(entityplayer, x, y, z))
        {
            Block block = world.getBlock(x, y, z);
            byte meta = (byte) world.getBlockMetadata(x, y, z);

            return ((IToolChisel)entityplayer.getCurrentEquippedItem().getItem()).onUsed(world, entityplayer, x, y, z, block, meta, side, par7, par8, par9);
        }
        return false;
    }

}
