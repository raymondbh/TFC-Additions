package org.rbh.tfcadditions.Blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import org.rbh.tfcadditions.Blocks.Dent.BlockIGEXDent;
import org.rbh.tfcadditions.Blocks.Dent.BlockIGINDent;
import org.rbh.tfcadditions.Blocks.Dent.BlockMMDent;
import org.rbh.tfcadditions.Blocks.DentSmall.BlockIGEXDentSmall;
import org.rbh.tfcadditions.Blocks.DentSmall.BlockIGINDentSmall;
import org.rbh.tfcadditions.Blocks.DentSmall.BlockMMDentSmall;
import org.rbh.tfcadditions.Items.ItemBlock;

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

    public static Block Slope;

    public static void LoadBlocks(){
        System.out.println(new StringBuilder().append("[TFC-Addition] Loading Blocks").toString());

        StoneMMDent = new BlockMMDent().setHardness(15F).setBlockName("MMRockDent");
        StoneMMDentSmall = new BlockMMDentSmall().setHardness(15F).setBlockName("MMRockDentSmall");

        StoneIGEXDent = new BlockIGEXDent().setHardness(16F).setBlockName("IgExRockDent");
        StoneIGEXDentSmall = new BlockIGEXDentSmall().setHardness(16F).setBlockName("IgExRockDentSmall");

        StoneIGINDent = new BlockIGINDent().setHardness(16F).setBlockName("IgInRockDent");
        StoneIGINDentSmall = new BlockIGINDentSmall().setHardness(16F).setBlockName("IgInRockDentSmall");

        //Slope = new BlockSlope(Material.rock).setBlockName("TFCSlope");
    }

    public static void RegisterBlocks(){
        System.out.println(new StringBuilder().append("[TFC-Addition] Register Blocks").toString());

        GameRegistry.registerBlock(StoneMMDent, ItemBlock.class, "StoneMMDent");
        GameRegistry.registerBlock(StoneMMDentSmall, ItemBlock.class, "StoneMMDentSmall");

        GameRegistry.registerBlock(StoneIGEXDent, ItemBlock.class, "StoneIGEXDent");
        GameRegistry.registerBlock(StoneIGEXDentSmall, ItemBlock.class, "StoneIGEXDentSmall");

        GameRegistry.registerBlock(StoneIGINDent, ItemBlock.class, "StoneIGINDent");
        GameRegistry.registerBlock(StoneIGINDentSmall, ItemBlock.class, "StoneIGINDentSmall");

        //GameRegistry.registerBlock(Slope, ItemBlock.class, "Slipperyslope");
    }
}
