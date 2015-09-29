package org.rbh.tfcadditions;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import org.rbh.tfcadditions.Proxy.CommonProxy;
import org.rbh.tfcadditions.Reference.Reference;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Dependecies are specified in mcmod.info
 * Created by raymondbh on 15.07.2015.
 */

@Mod(modid = Reference.ModID, name = Reference.ModName, version = Reference.ModVersion)
public class TFCAdditions {

    public static final Logger LOG = LogManager.getLogger(Reference.ModID);

    @Instance(Reference.ModID)
    public static TFCAdditions instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event){
        proxy.preInit(event);
    }

    @EventHandler
    public void Init(FMLInitializationEvent event){
        proxy.Init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event){
        proxy.postInit(event);
    }
}
