package org.rbh.tfcadditions.Items;


import com.bioxx.tfc.api.TFCItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import org.rbh.tfcadditions.Api.Items;
import org.rbh.tfcadditions.Core.Recipes;
import org.rbh.tfcadditions.Items.Tools.ItemPlaner;
import org.rbh.tfcadditions.TFCAdditions;

/**
 * Created by raymond on 07.08.2015.
 */
public class ItemSetup extends Items {

    public static void LoadItems(){
        TFCAdditions.LOG.info(new StringBuilder().append("Loading Items").toString());

        BismuthBronzePlaner = new ItemPlaner(TFCItems.bismuthBronzeToolMaterial).setUnlocalizedName("Bismuth Bronze Planer").setMaxDamage(TFCItems.bismuthBronzeUses);
        BlackBronzePlaner = new ItemPlaner(TFCItems.blackBronzeToolMaterial).setUnlocalizedName("Black Bronze Planer").setMaxDamage(TFCItems.blackBronzeUses);
        BlackSteelPlaner = new ItemPlaner(TFCItems.blackSteelToolMaterial).setUnlocalizedName("Black Steel Planer").setMaxDamage(TFCItems.blackSteelUses);
        BlueSteelPlaner = new ItemPlaner(TFCItems.blueSteelToolMaterial).setUnlocalizedName("Blue Steel Planer").setMaxDamage(TFCItems.blueSteelUses);
        BronzePlaner = new ItemPlaner(TFCItems.bronzeToolMaterial).setUnlocalizedName("Bronze Planer").setMaxDamage(TFCItems.bronzeUses);
        CopperPlaner = new ItemPlaner(TFCItems.copperToolMaterial).setUnlocalizedName("Copper Planer").setMaxDamage(TFCItems.copperUses);
        WroughtIronPlaner = new ItemPlaner(TFCItems.ironToolMaterial).setUnlocalizedName("Wrought Iron Planer").setMaxDamage(TFCItems.wroughtIronUses);
        RedSteelPlaner = new ItemPlaner(TFCItems.redSteelToolMaterial).setUnlocalizedName("Red Steel Planer").setMaxDamage(TFCItems.redSteelUses);
        SteelPlaner = new ItemPlaner(TFCItems.steelToolMaterial).setUnlocalizedName("Steel Planer").setMaxDamage(TFCItems.steelUses);

        PlankPlaned = new ItemPlankPlaned().setUnlocalizedName("Plank Planed");
    }

    public static void RegisterItems(){
        TFCAdditions.LOG.info(new StringBuilder().append("Register Items").toString());

        GameRegistry.registerItem(BismuthBronzePlaner, BismuthBronzePlaner.getUnlocalizedName());
        GameRegistry.registerItem(BlackBronzePlaner, BlackBronzePlaner.getUnlocalizedName());
        GameRegistry.registerItem(BlackSteelPlaner, BlackSteelPlaner.getUnlocalizedName());
        GameRegistry.registerItem(BlueSteelPlaner, BlueSteelPlaner.getUnlocalizedName());
        GameRegistry.registerItem(BronzePlaner, BronzePlaner.getUnlocalizedName());
        GameRegistry.registerItem(CopperPlaner, CopperPlaner.getUnlocalizedName());
        GameRegistry.registerItem(WroughtIronPlaner, WroughtIronPlaner.getUnlocalizedName());
        GameRegistry.registerItem(RedSteelPlaner, RedSteelPlaner.getUnlocalizedName());
        GameRegistry.registerItem(SteelPlaner, SteelPlaner.getUnlocalizedName());

        GameRegistry.registerItem(PlankPlaned, PlankPlaned.getUnlocalizedName());

        Recipes.planers = new Item[]{BismuthBronzePlaner,BlackBronzePlaner,BlackSteelPlaner,BlueSteelPlaner,BronzePlaner,CopperPlaner,WroughtIronPlaner,RedSteelPlaner,SteelPlaner};
    }
}
