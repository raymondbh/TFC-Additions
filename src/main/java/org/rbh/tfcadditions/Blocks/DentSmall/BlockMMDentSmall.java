package org.rbh.tfcadditions.Blocks.DentSmall;

import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import org.rbh.tfcadditions.Reference.Names;

/**
 * Created by rbh on 30.07.2015.
 */
public class BlockMMDentSmall extends BlockDentSmall {
    public BlockMMDentSmall(){
        super(Material.rock);
        names = Names.STONE_MM;
        icons = new IIcon[names.length];
    }
}
