package org.rbh.tfcadditions.Blocks.Planks;

import com.bioxx.tfc.Core.TFCTabs;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import org.rbh.tfcadditions.Blocks.BlockPlanks;

/**
 * Created by rbh on 20.08.2015.
 */
public class BlockPlanksNorm2 extends BlockPlanks{
    public BlockPlanksNorm2()
    {
        super(Material.wood, " Plank");
        this.setCreativeTab(TFCTabs.TFCBuilding);
        names = getMetaNames(BlockPlanks.NameType.SECOND_BRACKET);
        icons = new IIcon[names.length];
    }
}
