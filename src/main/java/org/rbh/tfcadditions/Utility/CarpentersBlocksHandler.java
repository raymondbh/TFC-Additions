package org.rbh.tfcadditions.Utility;

import com.bioxx.tfc.Core.Recipes;
import com.bioxx.tfc.api.Tools.ChiselManager;
import com.carpentersblocks.renderer.BlockHandlerCarpentersBlock;
import com.carpentersblocks.renderer.BlockHandlerCarpentersSlope;
import com.carpentersblocks.util.registry.BlockRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import org.rbh.tfcadditions.Blocks.CarpentersBlocks.CarpentersSlope;
import org.rbh.tfcadditions.Blocks.CarpentersBlocks.CarpentersBlock;
import org.rbh.tfcadditions.Items.ItemBlocks.ItemBlock;
import org.rbh.tfcadditions.Tools.ChiselMode_Slope;

/**
 * Created by rbh on 17.08.2015.
 */
public class CarpentersBlocksHandler {

    public static Block Block;
    public static Block Slope;

    public static int BlockRendrerID;
    public static int SlopeRendrerID;

    public static boolean isLoaded(){
        return Loader.isModLoaded("CarpentersBlocks");
    }

    public static void preInit(){
        Block = new CarpentersBlock(Material.wood).setHardness(0.2F).setBlockName("CarpentersBlock");
        Slope = new CarpentersSlope(Material.wood).setHardness(0.2F).setBlockName("CarpentersSlope");

        GameRegistry.registerBlock(Block, ItemBlock.class, "CarpentersBlock");
        GameRegistry.registerBlock(Slope, ItemBlock.class, "CarpentersSlope");
    }

    public static void Init(){
        setupRendrer();

        ChiselManager.getInstance().addChiselMode(new ChiselMode_Slope("Slope"));

        Recipes.RemoveRecipe(BlockRegistry.blockCarpentersBlock.getClass());
    }

    public static void postInit(){}

    @SideOnly(Side.CLIENT)
    public static void setupRendrer(){
        BlockRendrerID = RenderingRegistry.getNextAvailableRenderId();
        SlopeRendrerID = RenderingRegistry.getNextAvailableRenderId();

        RenderingRegistry.registerBlockHandler(BlockRendrerID, new BlockHandlerCarpentersBlock());
        RenderingRegistry.registerBlockHandler(SlopeRendrerID, new BlockHandlerCarpentersSlope());
    }
}