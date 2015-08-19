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

    public static void LoadBlocks(){
        System.out.println(new StringBuilder().append("[TFC-Addition] Loading Blocks").toString());

        StoneMMDent = new BlockMMDent().setHardness(15F).setBlockName("MMRockDent");
        StoneMMDentSmall = new BlockMMDentSmall().setHardness(15F).setBlockName("MMRockDentSmall");

        StoneIGEXDent = new BlockIGEXDent().setHardness(16F).setBlockName("IgExRockDent");
        StoneIGEXDentSmall = new BlockIGEXDentSmall().setHardness(16F).setBlockName("IgExRockDentSmall");

        StoneIGINDent = new BlockIGINDent().setHardness(16F).setBlockName("IgInRockDent");
        StoneIGINDentSmall = new BlockIGINDentSmall().setHardness(16F).setBlockName("IgInRockDentSmall");

        StoneSEDDent = new BlockSEDDent().setHardness(16F).setBlockName("SedRockDent");
        StoneSEDDentSmall = new BlockSEDDentSmall().setHardness(16F).setBlockName("SedRockDentSmall");

        PlanksOutline = new BlockPlankDent().setBlockName("PlanksOutline");
        PlanksOutline2 = new BlockPlank2Dent().setBlockName("PlanksOutline2");
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
    }
}
