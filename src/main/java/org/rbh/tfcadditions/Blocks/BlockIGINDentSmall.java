package org.rbh.tfcadditions.Blocks;

import com.bioxx.tfc.Core.TFCTabs;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import org.rbh.tfcadditions.Reference.Names;

/**
 * Created by rbh on 01.08.2015.
 */
public class BlockIGINDentSmall extends BlockDentSmall {
    protected BlockIGINDentSmall() {
        super(Material.rock);
        this.setCreativeTab(TFCTabs.TFCBuilding);
        names = Names.STONE_IGIN;
        icons = new IIcon[names.length];
    }
}
