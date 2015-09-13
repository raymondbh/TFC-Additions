package org.rbh.tfcadditions.Blocks.DentSmall;

import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import org.rbh.tfcadditions.Reference.Names;

/**
 * Created by rbh on 01.08.2015.
 */
public class BlockIGEXDentSmall extends BlockDentSmall {
    public BlockIGEXDentSmall() {
        super(Material.rock);
        names = Names.STONE_IGEX;
        icons = new IIcon[names.length];
    }
}
