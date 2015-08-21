package org.rbh.tfcadditions.Blocks;

import com.bioxx.tfc.Blocks.BlockTerra;
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
import org.rbh.tfcadditions.Reference.Names;
import org.rbh.tfcadditions.Reference.Reference;

import java.util.List;

/**
 * Created by raymondbh on 20.08.2015.
 */
public class BlockPlanks extends BlockTerra {

    public enum NameType {
        FIRST_BRACKET,
        SECOND_BRACKET
    }

    protected String[] names;
    protected IIcon[] icons;
    protected String plankType;

    public BlockPlanks(Material material, String Type)
    {
        super(material);
        plankType = Type;
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
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister registerer)
    {
        for(int meta = 0; meta < names.length; meta++)
            icons[meta] = registerer.registerIcon(Reference.ModID + ":" + "wood/" + names[meta] + "/" + names[meta] + plankType);
    }

    @Override
    public IIcon getIcon(int side, int meta)
    {
        if(meta < 0)
            return icons[0];
        return icons[meta];
    }

    @Override
    public int damageDropped(int j)
    {
        return j;
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

    public String[] getNames(){return names;}

    protected String[] getMetaNames(NameType bracket){
        String[] MetaNames;
        if(bracket == NameType.FIRST_BRACKET){
            MetaNames = new String[16];
            System.arraycopy(Names.WOOD_ALL, 0, MetaNames, 0, 16);
            return MetaNames;
        } else if(bracket == NameType.SECOND_BRACKET){
            MetaNames = new String[Names.WOOD_ALL.length - 16];
            System.arraycopy(Names.WOOD_ALL, 16, MetaNames, 0, Names.WOOD_ALL.length - 16);
            return MetaNames;
        }
        return null;
    }
}
