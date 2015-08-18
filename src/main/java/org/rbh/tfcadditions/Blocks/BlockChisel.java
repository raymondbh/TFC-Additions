package org.rbh.tfcadditions.Blocks;

import com.bioxx.tfc.Blocks.BlockTerra;
import com.bioxx.tfc.Items.Tools.ItemHammer;
import com.bioxx.tfc.api.Tools.IToolChisel;
import com.cricketcraft.ctmlib.ICTMBlock;
import com.cricketcraft.ctmlib.ISubmapManager;
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
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.rbh.tfcadditions.Api.SubmapManCTM;
import org.rbh.tfcadditions.Proxy.ClientProxy;
import org.rbh.tfcadditions.Reference.Reference;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rbh on 30.07.2015.
 */
public class BlockChisel extends BlockTerra implements ICTMBlock{

    //@SideOnly(Side.CLIENT)
    private List<SubmapManCTM> manager = new ArrayList<SubmapManCTM>();

    protected String[] names;
    protected IIcon[] icons;
    private String blockType, chiselType;

    public BlockChisel(Material material, String blockType, String chiselType)
    {
        super(material);
        this.chiselType = chiselType;
        this.blockType = blockType;

    }

    @SideOnly(Side.CLIENT)
    @Override
    /*
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List list)
    {
        for(int i = 0; i < names.length; i++)
            list.add(new ItemStack(this,1,i));
    }

    /*
     * Mapping from metadata value to damage value
     */
    @Override
    public int damageDropped(int i)
    {
        return i;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        for(int i = 0; i < names.length; i++) {
            manager.add(i, new SubmapManCTM(names[i], blockType, chiselType));
            manager.get(i).registerIcons(Reference.ModID, this, iconRegister);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
        int meta = world.getBlockMetadata(x, y, z);
        return manager.get(meta).getIcon(world, x, y, z, side);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return manager.get(meta).getIcon(side, meta);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderType() {
        return ClientProxy.CTMRendrerID;
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

        if(entityplayer.getCurrentEquippedItem() != null && entityplayer.getCurrentEquippedItem().getItem() instanceof IToolChisel &&
                hasHammer && !world.isRemote && ((IToolChisel)entityplayer.getCurrentEquippedItem().getItem()).canChisel(entityplayer, x, y, z))
        {
            Block id = world.getBlock(x, y, z);
            byte meta = (byte) world.getBlockMetadata(x, y, z);

            return ((IToolChisel)entityplayer.getCurrentEquippedItem().getItem()).onUsed(world, entityplayer, x, y, z, id, meta, side, par7, par8, par9);
        }
        return false;
    }

    @Override
    public ISubmapManager getManager(IBlockAccess world, int x, int y, int z, int meta) {
        return manager.get(meta);
    }

    @Override
    public ISubmapManager getManager(int meta) {
        return manager.get(meta);
    }
}
