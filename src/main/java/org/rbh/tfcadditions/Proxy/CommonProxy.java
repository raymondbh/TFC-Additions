package org.rbh.tfcadditions.Proxy;

import com.bioxx.tfc.api.Tools.ChiselManager;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import org.rbh.tfcadditions.Blocks.BlockSetup;
import org.rbh.tfcadditions.Core.OreDictRegister;
import org.rbh.tfcadditions.Core.Recipes;
import org.rbh.tfcadditions.Handlers.ConfigHandler;
import org.rbh.tfcadditions.Handlers.CraftingHandler;
import org.rbh.tfcadditions.Items.ItemSetup;
import org.rbh.tfcadditions.Tools.ChiselMode_Dent;
import org.rbh.tfcadditions.Tools.ChiselMode_DentSmall;


/**
 * Created by raymondbh on 15.07.2015.
 */
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event){
        ConfigHandler.preInit(event);

        BlockSetup.LoadBlocks();
        BlockSetup.RegisterBlocks();

        ItemSetup.LoadItems();
        ItemSetup.RegisterItems();

        OreDictRegister.registerOreDict();

        Recipes.registerRecipes();

        //if(CarpentersBlocksHandler.isLoaded())
        //    CarpentersBlocksHandler.preInit();
    }

    public void Init(FMLInitializationEvent event){
        ChiselManager.getInstance().addChiselMode(new ChiselMode_Dent("Dent"));
        ChiselManager.getInstance().addChiselMode(new ChiselMode_DentSmall("DentSmall"));

        FMLCommonHandler.instance().bus().register(new CraftingHandler());
    }

    public void postInit(FMLPostInitializationEvent event){

    }
}
