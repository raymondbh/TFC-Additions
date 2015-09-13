package org.rbh.tfcadditions.Blocks.Planks;

import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import org.rbh.tfcadditions.Blocks.BlockPlanks;

/**
 * Created by raymondbh on 20.08.2015.
 */
public class BlockPlanksParquet extends BlockPlanks {
    public BlockPlanksParquet() {
        super(Material.wood, " Plank Parquet");
        names = getMetaNames(NameType.FIRST_BRACKET);
        icons = new IIcon[names.length];
    }
}
