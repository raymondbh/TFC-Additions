package org.rbh.tfcadditions.Items;

import com.bioxx.tfc.TFCItems;
import net.minecraft.item.Item;
import net.minecraft.item.Item.*;
import org.rbh.tfcadditions.Items.Tools.ItemPlaner;

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

    public static ToolMaterial BismuthBronzeToolMaterial;
    public static ToolMaterial BlackBronzeToolMaterial;
    public static ToolMaterial BlackSteelToolMaterial;
    public static ToolMaterial BlueSteelToolMaterial;
    public static ToolMaterial BronzeToolMaterial;
    public static ToolMaterial CopperToolMaterial;
    public static ToolMaterial IronToolMaterial;
    public static ToolMaterial RedSteelToolMaterial;
    public static ToolMaterial SteelToolMaterial;

    public static void Setup(){

        BismuthBronzePlaner = new ItemPlaner(BismuthBronzeToolMaterial).setUnlocalizedName("Bismuth Bronze Planer").setMaxDamage(TFCItems.BismuthBronzeUses);
        BlackBronzePlaner = new ItemPlaner(BlackBronzeToolMaterial).setUnlocalizedName("Black Bronze Planer").setMaxDamage(TFCItems.BlackBronzeUses);
        BlackSteelPlaner = new ItemPlaner(BlackSteelToolMaterial).setUnlocalizedName("Black Steel Planer").setMaxDamage(TFCItems.BlackSteelUses);
        BlueSteelPlaner = new ItemPlaner(BlueSteelToolMaterial).setUnlocalizedName("Blue Steel Planer").setMaxDamage(TFCItems.BlueSteelUses);
        BronzePlaner = new ItemPlaner(BronzeToolMaterial).setUnlocalizedName("Bronze Planer").setMaxDamage(TFCItems.BronzeUses);
        CopperPlaner = new ItemPlaner(CopperToolMaterial).setUnlocalizedName("Copper Planer").setMaxDamage(TFCItems.CopperUses);
        WroughtIronPlaner = new ItemPlaner(IronToolMaterial).setUnlocalizedName("Wrought Iron Planer").setMaxDamage(TFCItems.WroughtIronUses);
        RedSteelPlaner = new ItemPlaner(RedSteelToolMaterial).setUnlocalizedName("Red Steel Planer").setMaxDamage(TFCItems.RedSteelUses);
        SteelPlaner = new ItemPlaner(SteelToolMaterial).setUnlocalizedName("Steel Planer").setMaxDamage(TFCItems.SteelUses);
    }
}
