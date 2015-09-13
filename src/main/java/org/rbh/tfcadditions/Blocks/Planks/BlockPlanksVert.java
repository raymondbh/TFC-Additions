package org.rbh.tfcadditions.Blocks.Planks;

import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import org.rbh.tfcadditions.Blocks.BlockPlanks;

/**
 * Created by rbh on 20.08.2015.
 */
public class BlockPlanksVert extends BlockPlanks {
    public BlockPlanksVert() {
        super(Material.wood, " Plank Vertical");
        names = getMetaNames(NameType.FIRST_BRACKET);
        icons = new IIcon[names.length];
    }
}
