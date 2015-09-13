package org.rbh.tfcadditions.Blocks.Planks;

import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import org.rbh.tfcadditions.Blocks.BlockPlanks;

/**
 * Created by raymondbh on 20.08.2015.
 */
public class BlockPlanksLarge extends BlockPlanks {
    public BlockPlanksLarge() {
        super(Material.wood, " Plank Large");
        names = getMetaNames(NameType.FIRST_BRACKET);
        icons = new IIcon[names.length];
    }
}
