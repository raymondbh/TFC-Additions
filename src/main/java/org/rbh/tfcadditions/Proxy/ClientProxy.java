package org.rbh.tfcadditions.Proxy;

import com.cricketcraft.ctmlib.CTMRenderer;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import org.rbh.tfcadditions.Handlers.KeyBindingHandler;
import org.rbh.tfcadditions.Utility.CarpentersBlocksHandler;
import org.rbh.tfcadditions.Utility.NotEnoughItemsHandler;

/**
 * Created by raymondbh on 15.07.2015.
 */
public class ClientProxy extends CommonProxy {

    public static int CTMRendrerID;

    @Override
    public void preInit(FMLPreInitializationEvent event){
        super.preInit(event);
        registerKeyBindingHandler();
    }

    @Override
    public void Init(FMLInitializationEvent event){
        super.Init(event);

        CTMRendrerID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new CTMRenderer(CTMRendrerID));

        if(CarpentersBlocksHandler.isLoaded())
            CarpentersBlocksHandler.Init();

        if(NotEnoughItemsHandler.isLoaded())
            NotEnoughItemsHandler.HideNEIItems();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event){
        super.postInit(event);
    }

    public void registerKeyBindingHandler()
    {
        FMLCommonHandler.instance().bus().register(new KeyBindingHandler());
    }

}
