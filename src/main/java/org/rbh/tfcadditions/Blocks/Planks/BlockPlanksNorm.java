package org.rbh.tfcadditions.Blocks.Planks;

import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import org.rbh.tfcadditions.Blocks.BlockPlanks;

/**
 * Created by rbh on 20.08.2015.
 */
public class BlockPlanksNorm extends BlockPlanks {
    public BlockPlanksNorm() {
        super(Material.wood, " Plank");
        names = getMetaNames(NameType.FIRST_BRACKET);
        icons = new IIcon[names.length];
    }
}
