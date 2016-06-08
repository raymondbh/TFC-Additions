package org.rbh.tfcadditions.Config;

import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import org.rbh.tfcadditions.Handlers.ConfigHandler;
import org.rbh.tfcadditions.Reference.Reference;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by raymondbh on 08.06.2016.
 */
public class ConfigGUI extends GuiConfig {

    public ConfigGUI(GuiScreen parentScreen) {
        super(parentScreen, getConfigElements(), Reference.ModID, false, false, Reference.ModName);
    }

    private static List<IConfigElement> getConfigElements() {

        List<IConfigElement> configElementsList = new ArrayList<IConfigElement>();
        for (String catName : ConfigHandler.config.getCategoryNames() ) {
            if ( catName.contains(".")) continue;
            configElementsList.add(new ConfigElement(ConfigHandler.config.getCategory(catName)));
        }
        return configElementsList;
    }
}
