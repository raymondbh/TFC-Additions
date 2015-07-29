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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raymondbh on 29.07.2015.
 */
public class SubmapManCTM extends SubmapManagerCTM {

    @SideOnly(Side.CLIENT)
    private static RenderBlocksCTM rb;

    private List<TextureSubmap> submap = new ArrayList<TextureSubmap>();
    private List<TextureSubmap> submapSmall = new ArrayList<TextureSubmap>();
    private String[] blockNames;
    private String blockType;
    private String chiselType;

    public SubmapManCTM(String[] names, String block, String chisel) {
        blockNames = names;
        blockType = block;
        chiselType = chisel;
    }

    @Override
    public IIcon getIcon(int side, int meta) {
        return submapSmall.get(meta).getBaseIcon();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(String modName, Block block, IIconRegister register) {
        for(int i = 0; i < blockNames.length; i++){
            submap.add(i, new TextureSubmap(register.registerIcon(modName + ":" + blockType + "/" + blockNames[i] + "/" + blockNames[i] + " " + chiselType + "-ctm"), 4, 4));
            submapSmall.add(i, new TextureSubmap(register.registerIcon(modName + ":" + blockType + "/" + blockNames[i] + "/" + blockNames[i] + " " + chiselType), 2, 2));
        }
    }

    @SideOnly(Side.CLIENT)
    public RenderBlocks createRenderContext(RenderBlocks rendererOld, Block block, IBlockAccess world, int meta) {
        if (rb == null) {
            rb = new RenderBlocksCTM();
        }
        rb.setRenderBoundsFromBlock(block);
        rb.submap = submap.get(meta);
        rb.submapSmall = submapSmall.get(meta);
        return rb;
    }

    @Override
    public void preRenderSide(RenderBlocks renderer, IBlockAccess world, int x, int y, int z, ForgeDirection side) {
    }

    @Override
    public void postRenderSide(RenderBlocks renderer, IBlockAccess world, int x, int y, int z, ForgeDirection side) {
    }
}
