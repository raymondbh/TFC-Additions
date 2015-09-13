package org.rbh.tfcadditions.Blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import org.rbh.tfcadditions.Blocks.Dent.BlockIGEXDent;
import org.rbh.tfcadditions.Blocks.Dent.BlockIGINDent;
import org.rbh.tfcadditions.Blocks.Dent.BlockMMDent;
import org.rbh.tfcadditions.Blocks.Dent.BlockSEDDent;
import org.rbh.tfcadditions.Blocks.DentSmall.BlockIGEXDentSmall;
import org.rbh.tfcadditions.Blocks.DentSmall.BlockIGINDentSmall;
import org.rbh.tfcadditions.Blocks.DentSmall.BlockMMDentSmall;
import org.rbh.tfcadditions.Blocks.DentSmall.BlockSEDDentSmall;
import org.rbh.tfcadditions.Blocks.Dent.BlockPlank2Dent;
import org.rbh.tfcadditions.Blocks.Dent.BlockPlankDent;
import org.rbh.tfcadditions.Blocks.Planks.*;
import org.rbh.tfcadditions.Core.TFCAdditionsTabs;
import org.rbh.tfcadditions.Items.ItemBlocks.ItemBlock;
import org.rbh.tfcadditions.Items.ItemBlocks.ItemBlockPlanks;

/**
 * Created by raymondbh on 15.07.2015.
 */
public class BlockSetup {
    public static Block StoneMMDent;
    public static Block StoneMMDentSmall;

    public static Block StoneIGEXDent;
    public static Block StoneIGEXDentSmall;

    public static Block StoneIGINDent;
    public static Block StoneIGINDentSmall;

    public static Block StoneSEDDent;
    public static Block StoneSEDDentSmall;

    public static Block PlanksOutline;
    public static Block PlanksOutline2;

    public static Block PlanksLarge;
    public static Block PlanksLarge2;

    public static Block PlanksParquet;
    public static Block PlanksParquet2;

    public static Block PlanksNorm;
    public static Block PlanksNorm2;

    public static Block PlanksVert;
    public static Block PlanksVert2;

    public static void LoadBlocks(){
        System.out.println(new StringBuilder().append("[TFC-Addition] Loading Blocks").toString());

        StoneMMDent = new BlockMMDent().setHardness(15F).setBlockName("MMRockDent").setCreativeTab(TFCAdditionsTabs.TFCAdditions_Tab);
        StoneMMDentSmall = new BlockMMDentSmall().setHardness(15F).setBlockName("MMRockDentSmall").setCreativeTab(TFCAdditionsTabs.TFCAdditions_Tab);

        StoneIGEXDent = new BlockIGEXDent().setHardness(16F).setBlockName("IgExRockDent").setCreativeTab(TFCAdditionsTabs.TFCAdditions_Tab);
        StoneIGEXDentSmall = new BlockIGEXDentSmall().setHardness(16F).setBlockName("IgExRockDentSmall").setCreativeTab(TFCAdditionsTabs.TFCAdditions_Tab);

        StoneIGINDent = new BlockIGINDent().setHardness(16F).setBlockName("IgInRockDent").setCreativeTab(TFCAdditionsTabs.TFCAdditions_Tab);
        StoneIGINDentSmall = new BlockIGINDentSmall().setHardness(16F).setBlockName("IgInRockDentSmall").setCreativeTab(TFCAdditionsTabs.TFCAdditions_Tab);

        StoneSEDDent = new BlockSEDDent().setHardness(16F).setBlockName("SedRockDent").setCreativeTab(TFCAdditionsTabs.TFCAdditions_Tab);
        StoneSEDDentSmall = new BlockSEDDentSmall().setHardness(16F).setBlockName("SedRockDentSmall").setCreativeTab(TFCAdditionsTabs.TFCAdditions_Tab);

        PlanksOutline = new BlockPlankDent().setHardness(4.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("PlanksOutline").setCreativeTab(TFCAdditionsTabs.TFCAdditions_Tab);
        PlanksOutline2 = new BlockPlank2Dent().setHardness(4.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("PlanksOutline2").setCreativeTab(TFCAdditionsTabs.TFCAdditions_Tab);

        PlanksLarge = new BlockPlanksLarge().setHardness(4.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("PlanksLarge").setCreativeTab(TFCAdditionsTabs.TFCAdditions_Tab);
        PlanksLarge2 = new BlockPlanksLarge2().setHardness(4.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("PlanksLarge2").setCreativeTab(TFCAdditionsTabs.TFCAdditions_Tab);

        PlanksParquet = new BlockPlanksParquet().setHardness(4.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("PlanksParquet").setCreativeTab(TFCAdditionsTabs.TFCAdditions_Tab);
        PlanksParquet2 = new BlockPlanksParquet2().setHardness(4.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("PlanksParquet2").setCreativeTab(TFCAdditionsTabs.TFCAdditions_Tab);

        PlanksNorm = new BlockPlanksNorm().setHardness(4.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("PlanksNorm").setCreativeTab(TFCAdditionsTabs.TFCAdditions_Tab);
        PlanksNorm2 = new BlockPlanksNorm2().setHardness(4.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("PlanksNorm2").setCreativeTab(TFCAdditionsTabs.TFCAdditions_Tab);

        PlanksVert = new BlockPlanksVert().setHardness(4.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("PlanksVert").setCreativeTab(TFCAdditionsTabs.TFCAdditions_Tab);
        PlanksVert2 = new BlockPlanksVert2().setHardness(4.0F).setResistance(5.0F).setStepSound(Block.soundTypeWood).setBlockName("PlanksVert2").setCreativeTab(TFCAdditionsTabs.TFCAdditions_Tab);

        StoneMMDent.setHarvestLevel("pickaxe", 0);
        StoneMMDentSmall.setHarvestLevel("pickaxe", 0);

        StoneIGEXDent.setHarvestLevel("pickaxe", 0);
        StoneIGEXDentSmall.setHarvestLevel("pickaxe", 0);

        StoneIGINDent.setHarvestLevel("pickaxe", 0);
        StoneIGINDentSmall.setHarvestLevel("pickaxe", 0);

        StoneSEDDent.setHarvestLevel("pickaxe", 0);
        StoneSEDDentSmall.setHarvestLevel("pickaxe", 0);

        PlanksOutline.setHarvestLevel("axe", 0);
        PlanksOutline2.setHarvestLevel("axe", 0);

        PlanksLarge.setHarvestLevel("axe", 0);
        PlanksLarge2.setHarvestLevel("axe", 0);

        PlanksParquet.setHarvestLevel("axe", 0);
        PlanksParquet2.setHarvestLevel("axe", 0);

        PlanksNorm.setHarvestLevel("axe", 0);
        PlanksNorm2.setHarvestLevel("axe", 0);

        PlanksVert.setHarvestLevel("axe", 0);
        PlanksVert2.setHarvestLevel("axe", 0);
    }

    public static void RegisterBlocks(){
        System.out.println(new StringBuilder().append("[TFC-Addition] Register Blocks").toString());

        GameRegistry.registerBlock(StoneMMDent, ItemBlock.class, "StoneMMDent");
        GameRegistry.registerBlock(StoneMMDentSmall, ItemBlock.class, "StoneMMDentSmall");

        GameRegistry.registerBlock(StoneIGEXDent, ItemBlock.class, "StoneIGEXDent");
        GameRegistry.registerBlock(StoneIGEXDentSmall, ItemBlock.class, "StoneIGEXDentSmall");

        GameRegistry.registerBlock(StoneIGINDent, ItemBlock.class, "StoneIGINDent");
        GameRegistry.registerBlock(StoneIGINDentSmall, ItemBlock.class, "StoneIGINDentSmall");

        GameRegistry.registerBlock(StoneSEDDent, ItemBlock.class, "StoneSEDDent");
        GameRegistry.registerBlock(StoneSEDDentSmall, ItemBlock.class, "StoneSEDDentSmall");

        GameRegistry.registerBlock(PlanksOutline, ItemBlockPlanks.class, "OutlinedPlanks");
        GameRegistry.registerBlock(PlanksOutline2, ItemBlockPlanks.class, "OutlinedPlanks2");

        GameRegistry.registerBlock(PlanksLarge, ItemBlockPlanks.class, "LargePlanks");
        GameRegistry.registerBlock(PlanksLarge2, ItemBlockPlanks.class, "LargePlanks2");

        GameRegistry.registerBlock(PlanksParquet, ItemBlockPlanks.class, "ParquetPlanks");
        GameRegistry.registerBlock(PlanksParquet2, ItemBlockPlanks.class, "ParquetPlanks2");

        GameRegistry.registerBlock(PlanksNorm, ItemBlockPlanks.class, "NormalPlanks");
        GameRegistry.registerBlock(PlanksNorm2, ItemBlockPlanks.class, "NormalPlanks2");

        GameRegistry.registerBlock(PlanksVert, ItemBlockPlanks.class, "VerticalPlanks");
        GameRegistry.registerBlock(PlanksVert2, ItemBlockPlanks.class, "VerticalPlanks2");
    }
}
