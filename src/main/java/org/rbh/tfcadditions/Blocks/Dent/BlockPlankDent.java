package org.rbh.tfcadditions.Blocks.Dent;

import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import org.rbh.tfcadditions.Blocks.BlockChisel;
import org.rbh.tfcadditions.Reference.Names;

/**
 * Created by raymondbh on 19.08.2015.
 */
public class BlockPlankDent extends BlockChisel {
    public BlockPlankDent()
    {
        super(Material.wood, "wood", "Plank Outline");
        names = new String[16];
        System.arraycopy(Names.WOOD_ALL, 0, names, 0, 16);
        icons = new IIcon[names.length];
    }
}
