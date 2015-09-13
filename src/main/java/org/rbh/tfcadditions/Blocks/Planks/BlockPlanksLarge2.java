package org.rbh.tfcadditions.Blocks.Planks;

import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import org.rbh.tfcadditions.Blocks.BlockPlanks;

/**
 * Created by raymondbh on 20.08.2015.
 */
public class BlockPlanksLarge2 extends BlockPlanks {
    public BlockPlanksLarge2() {
        super(Material.wood, " Plank Large");
        names = getMetaNames(NameType.SECOND_BRACKET);
        icons = new IIcon[names.length];
    }
}
