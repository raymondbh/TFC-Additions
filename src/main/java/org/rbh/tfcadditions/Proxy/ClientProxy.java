package org.rbh.tfcadditions.Proxy;

import com.cricketcraft.ctmlib.CTMRenderer;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by raymondbh on 15.07.2015.
 */
public class ClientProxy extends CommonProxy {

    public static int CTMRendrerID;

    @Override
    public void preInit(FMLPreInitializationEvent event){
        super.preInit(event);
    }

    @Override
    public void Init(FMLInitializationEvent event){
        super.Init(event);
        CTMRendrerID = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new CTMRenderer(CTMRendrerID));
    }

    @Override
    public void postInit(FMLPostInitializationEvent event){
        super.postInit(event);
    }
}
