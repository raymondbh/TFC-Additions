package org.rbh.tfcadditions.Handlers;

import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by raymondbh on 08.06.2016.
 */
public class ConfigHandler {

    public static final String GENERAL = "General";
    public static Configuration config;

    public static boolean HideNEI = false;

    public static void preInit(FMLPreInitializationEvent event) {

        config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();

        loadGeneralConfig();
    }

    public static void loadGeneralConfig() {

        HideNEI = config.getBoolean("HideNEIVanilla", GENERAL, false, "This will hide vanilla blocks not used by TFC in NEI.");

        if(config.hasChanged()) config.save();
    }
}
