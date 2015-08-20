package org.rbh.tfcadditions.Blocks.Planks;

import com.bioxx.tfc.Core.TFCTabs;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import org.rbh.tfcadditions.Blocks.BlockPlanks;
import org.rbh.tfcadditions.Reference.Reference;

/**
 * Created by raymondbh on 20.08.2015.
 */
public class BlockPlanksParquet extends BlockPlanks {
    public BlockPlanksParquet()
    {
        super(Material.wood);
        this.setCreativeTab(TFCTabs.TFCBuilding);
        names = getMetaNames(NameType.FIRST_BRACKET);
        icons = new IIcon[names.length];
    }

    @Override
    public void registerBlockIcons(IIconRegister registerer)
    {
        for(int meta = 0; meta < names.length; meta++)
            icons[meta] = registerer.registerIcon(Reference.ModID + ":" + "wood/"+names[meta]+" Plank Parquet");
        Blocks.planks.registerBlockIcons(registerer);
    }
}
