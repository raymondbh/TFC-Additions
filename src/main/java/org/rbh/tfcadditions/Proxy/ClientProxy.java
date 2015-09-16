package org.rbh.tfcadditions.Proxy;

import com.bioxx.tfc.api.Util.KeyBindings;
import com.cricketcraft.ctmlib.CTMRenderer;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.item.ItemStack;
import org.rbh.tfcadditions.Blocks.BlockSetup;
import org.rbh.tfcadditions.Core.TFCAdditionsTabs;
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
        registerKeys();
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

        //Setup Creative Tab Icon
        ((TFCAdditionsTabs) TFCAdditionsTabs.TFCAdditions_Tab).setTabIconItemStack(new ItemStack(BlockSetup.StoneMMDent, 1, 5));
    }

    @Override
    public void postInit(FMLPostInitializationEvent event){
        super.postInit(event);
    }

    public void registerKeys() {
        KeyBindings.addKeyBinding(KeyBindingHandler.Key_PrevChiselMode);
        KeyBindings.addIsRepeating(false);
        uploadKeyBindingsToGame();
    }

    public void uploadKeyBindingsToGame()
    {
        GameSettings settings = Minecraft.getMinecraft().gameSettings;
        KeyBinding[] tfcKeyBindings = KeyBindings.gatherKeyBindings();
        KeyBinding[] allKeys = new KeyBinding[settings.keyBindings.length + tfcKeyBindings.length];
        System.arraycopy(settings.keyBindings, 0, allKeys, 0, settings.keyBindings.length);
        System.arraycopy(tfcKeyBindings, 0, allKeys, settings.keyBindings.length, tfcKeyBindings.length);
        settings.keyBindings = allKeys;
        settings.loadOptions();
    }

    public void registerKeyBindingHandler()
    {
        FMLCommonHandler.instance().bus().register(new KeyBindingHandler());
    }

}
