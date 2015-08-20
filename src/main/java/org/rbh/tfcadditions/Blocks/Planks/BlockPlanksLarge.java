package org.rbh.tfcadditions.Blocks.Planks;

import com.bioxx.tfc.Core.TFCTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import org.rbh.tfcadditions.Blocks.BlockPlanks;
import org.rbh.tfcadditions.Reference.Reference;

/**
 * Created by raymondbh on 20.08.2015.
 */
public class BlockPlanksLarge extends BlockPlanks {
    public BlockPlanksLarge() {
        super(Material.wood, " Plank Large");
        this.setCreativeTab(TFCTabs.TFCBuilding);
        names = getMetaNames(NameType.FIRST_BRACKET);
        icons = new IIcon[names.length];
    }
}
