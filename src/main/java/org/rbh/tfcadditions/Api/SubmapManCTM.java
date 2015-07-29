package org.rbh.tfcadditions.Api;

import com.cricketcraft.ctmlib.RenderBlocksCTM;
import com.cricketcraft.ctmlib.SubmapManagerCTM;
import com.cricketcraft.ctmlib.TextureSubmap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by raymondbh on 29.07.2015.
 */
public class SubmapManCTM extends SubmapManagerCTM {

    @SideOnly(Side.CLIENT)
    private static RenderBlocksCTM rb;

    private TextureSubmap submap, submapSmall;
    private String blockNames;
    private String blockType;
    private String chiselType;

    public SubmapManCTM(String names, String block, String chisel) {
        super("dummy");
        blockNames = names;
        blockType = block;
        chiselType = chisel;
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return submapSmall.getBaseIcon();
    }

    @Override
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
        return getIcon(side, world.getBlockMetadata(x, y, z));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(String modName, Block block, IIconRegister register) {
            submap = new TextureSubmap(register.registerIcon(modName + ":" + blockType + "/" + blockNames + "/" + blockNames + " " + chiselType + "-ctm"), 4, 4);
            submapSmall = new TextureSubmap(register.registerIcon(modName + ":" + blockType + "/" + blockNames + "/" + blockNames + " " + chiselType), 2, 2);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public RenderBlocks createRenderContext(RenderBlocks rendererOld, Block block, IBlockAccess world) {
        if (rb == null) {
            rb = new RenderBlocksCTM();
        }
        rb.setRenderBoundsFromBlock(block);
        rb.submap = submap;
        rb.submapSmall = submapSmall;
        return rb;
    }

    @Override
    public void preRenderSide(RenderBlocks renderer, IBlockAccess world, int x, int y, int z, ForgeDirection side) {
    }

    @Override
    public void postRenderSide(RenderBlocks renderer, IBlockAccess world, int x, int y, int z, ForgeDirection side) {
    }
}
