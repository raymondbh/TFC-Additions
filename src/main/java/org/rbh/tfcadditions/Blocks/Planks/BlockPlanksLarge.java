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
public class BlockPlanksLarge extends BlockPlanks
{
    public BlockPlanksLarge()
    {
        super(Material.wood);
        this.setCreativeTab(TFCTabs.TFCBuilding);
        names = new String[16];
        System.arraycopy(Names.WOOD_ALL, 0, names, 0, 16);
        icons = new IIcon[names.length];
    }

    @Override
    public IIcon getIcon(int side, int meta)
    {
        if(meta < 0)
            return icons[0];
        if(meta < icons.length)
            return icons[meta];
        return BlockSetup.PlanksLarge2.getIcon(side, meta - 16);
    }

    @Override
    public void registerBlockIcons(IIconRegister registerer)
    {
        for(int meta = 0; meta < names.length; meta++)
            icons[meta] = registerer.registerIcon(Reference.ModID + ":" + "wood/"+names[meta]+" Plank Large");
        //Blocks.planks.registerBlockIcons(registerer);
    }
}
