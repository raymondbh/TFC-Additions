package org.rbh.tfcadditions.Blocks.Dent;

import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import org.rbh.tfcadditions.Reference.Names;

/**
 * Created by rbh on 30.07.2015.
 */
public class BlockIGEXDent extends BlockDent {
    public BlockIGEXDent() {
        super(Material.rock);
        names = Names.STONE_IGEX;
        icons = new IIcon[names.length];
    }
}
