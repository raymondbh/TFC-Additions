package org.rbh.tfcadditions.Items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import org.rbh.tfcadditions.Items.Tools.ItemPlaner;

import com.bioxx.tfc.api.TFCItems;

/**
 * Created by raymond on 07.08.2015.
 */
public class ItemSetup {

    public static Item BismuthBronzePlaner;
    public static Item BlackBronzePlaner;
    public static Item BlackSteelPlaner;
    public static Item BlueSteelPlaner;
    public static Item BronzePlaner;
    public static Item CopperPlaner;
    public static Item WroughtIronPlaner;
    public static Item RedSteelPlaner;
    public static Item SteelPlaner;

    public static void LoadItems(){

        BismuthBronzePlaner = new ItemPlaner(TFCItems.BismuthBronzeToolMaterial).setUnlocalizedName("Bismuth Bronze Planer").setMaxDamage(TFCItems.BismuthBronzeUses);
        BlackBronzePlaner = new ItemPlaner(TFCItems.BlackBronzeToolMaterial).setUnlocalizedName("Black Bronze Planer").setMaxDamage(TFCItems.BlackBronzeUses);
        BlackSteelPlaner = new ItemPlaner(TFCItems.BlackSteelToolMaterial).setUnlocalizedName("Black Steel Planer").setMaxDamage(TFCItems.BlackSteelUses);
        BlueSteelPlaner = new ItemPlaner(TFCItems.BlueSteelToolMaterial).setUnlocalizedName("Blue Steel Planer").setMaxDamage(TFCItems.BlueSteelUses);
        BronzePlaner = new ItemPlaner(TFCItems.BronzeToolMaterial).setUnlocalizedName("Bronze Planer").setMaxDamage(TFCItems.BronzeUses);
        CopperPlaner = new ItemPlaner(TFCItems.CopperToolMaterial).setUnlocalizedName("Copper Planer").setMaxDamage(TFCItems.CopperUses);
        WroughtIronPlaner = new ItemPlaner(TFCItems.IronToolMaterial).setUnlocalizedName("Wrought Iron Planer").setMaxDamage(TFCItems.WroughtIronUses);
        RedSteelPlaner = new ItemPlaner(TFCItems.RedSteelToolMaterial).setUnlocalizedName("Red Steel Planer").setMaxDamage(TFCItems.RedSteelUses);
        SteelPlaner = new ItemPlaner(TFCItems.SteelToolMaterial).setUnlocalizedName("Steel Planer").setMaxDamage(TFCItems.SteelUses);
    }

    public static void RegisterItems(){
        GameRegistry.registerItem(BismuthBronzePlaner, BismuthBronzePlaner.getUnlocalizedName());
        GameRegistry.registerItem(BlackBronzePlaner, BlackBronzePlaner.getUnlocalizedName());
        GameRegistry.registerItem(BlackSteelPlaner, BlackSteelPlaner.getUnlocalizedName());
        GameRegistry.registerItem(BlueSteelPlaner, BlueSteelPlaner.getUnlocalizedName());
        GameRegistry.registerItem(BronzePlaner, BronzePlaner.getUnlocalizedName());
        GameRegistry.registerItem(CopperPlaner, CopperPlaner.getUnlocalizedName());
        GameRegistry.registerItem(WroughtIronPlaner, WroughtIronPlaner.getUnlocalizedName());
        GameRegistry.registerItem(RedSteelPlaner, RedSteelPlaner.getUnlocalizedName());
        GameRegistry.registerItem(SteelPlaner, SteelPlaner.getUnlocalizedName());
    }
}
