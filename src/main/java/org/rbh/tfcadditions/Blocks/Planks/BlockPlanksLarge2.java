package org.rbh.tfcadditions.Blocks.Planks;

import com.bioxx.tfc.Core.TFCTabs;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import org.rbh.tfcadditions.Blocks.BlockPlanks;
import org.rbh.tfcadditions.Blocks.BlockSetup;
import org.rbh.tfcadditions.Reference.Names;
import org.rbh.tfcadditions.Reference.Reference;

/**
 * Created by raymondbh on 20.08.2015.
 */
public class BlockPlanksLarge2 extends BlockPlanks
{

    public BlockPlanksLarge2()
    {
        super(Material.wood);
        this.setCreativeTab(TFCTabs.TFCBuilding);
        names = new String[Names.WOOD_ALL.length-16];
        System.arraycopy(Names.WOOD_ALL, 16, names, 0, Names.WOOD_ALL.length-16);
        icons = new IIcon[names.length];
    }

    @Override
    public IIcon getIcon(int side, int meta)
    {
        if(meta > 16)
            return icons[meta-16];
        return BlockSetup.PlanksLarge.getIcon(side, meta);
    }

    @Override
    public void registerBlockIcons(IIconRegister registerer)
    {
        for(int meta = 0; meta < names.length; meta++)
            icons[meta] = registerer.registerIcon(Reference.ModID + ":" + "wood/"+names[meta]+" Plank Large");
        //Blocks.planks.registerBlockIcons(registerer);
    }
}
