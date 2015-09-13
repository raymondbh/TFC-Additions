package org.rbh.tfcadditions.Blocks.Dent;

import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import org.rbh.tfcadditions.Reference.Names;

/**
 * Created by rbh on 01.08.2015.
 */
public class BlockIGINDent extends BlockDent {
    public BlockIGINDent() {
        super(Material.rock);
        names = Names.STONE_IGIN;
        icons = new IIcon[names.length];
    }
}
