package org.rbh.tfcadditions.Core;

import com.bioxx.tfc.api.TFCBlocks;
import com.bioxx.tfc.api.TFCItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import org.rbh.tfcadditions.Api.Blocks;
import org.rbh.tfcadditions.Api.Items;
import org.rbh.tfcadditions.Reference.Names;

/**
 * Created by rbh on 17.09.2015.
 */
public class Recipes {

    public static Item[] planers;

    public static void registerRecipes(){

        //Wood planers
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.BismuthBronzePlaner, 1), "SHS", "WWW", 'S', "stickWood", 'H', TFCItems.bismuthBronzeChiselHead, 'W', "woodLumber"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.BlackBronzePlaner, 1), "SHS", "WWW", 'S', "stickWood", 'H', TFCItems.blackBronzeChiselHead, 'W', "woodLumber"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.BlackSteelPlaner, 1), "SHS", "WWW", 'S', "stickWood", 'H', TFCItems.blackSteelChiselHead, 'W', "woodLumber"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.BlueSteelPlaner, 1), "SHS", "WWW", 'S', "stickWood", 'H', TFCItems.blueSteelChiselHead, 'W', "woodLumber"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.BronzePlaner, 1), "SHS", "WWW", 'S', "stickWood", 'H', TFCItems.bronzeChiselHead, 'W', "woodLumber"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.CopperPlaner, 1), "SHS", "WWW", 'S', "stickWood", 'H', TFCItems.copperChiselHead, 'W', "woodLumber"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.WroughtIronPlaner, 1), "SHS", "WWW", 'S', "stickWood", 'H', TFCItems.wroughtIronChiselHead, 'W', "woodLumber"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.RedSteelPlaner, 1), "SHS", "WWW", 'S', "stickWood", 'H', TFCItems.redSteelChiselHead, 'W', "woodLumber"));
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.SteelPlaner, 1), "SHS", "WWW", 'S', "stickWood", 'H', TFCItems.steelChiselHead, 'W', "woodLumber"));

        //Wood items and blocks
        for(int i = 0; i < Names.WOOD_ALL.length; i++){
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.PlankPlaned, 1, i), new ItemStack(TFCItems.singlePlank, 1, i), "itemPlaner"));

            int l = i%16;
            if(i==l){
                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.PlanksVert, 1, i), " 1 ","11 ","1  ", '1', new ItemStack(TFCItems.singlePlank, 1, i)));
                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.PlanksParquet, 1, i), "11","11", '1', new ItemStack(Items.PlankPlaned, 1, i)));
                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.PlanksLarge, 2, i), "111","111","111", '1', new ItemStack(Items.PlankPlaned, 1, i)));
            } else if(i/16 == 1){
                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.PlanksVert2, 1, l), " 1 ","11 ","1  ", '1', new ItemStack(TFCItems.singlePlank, 1, i)));
                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.PlanksParquet2, 2, l), "11","11", '1', new ItemStack(Items.PlankPlaned, 1, i)));
                GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.PlanksLarge2, 2, l), "111","111","111", '1', new ItemStack(Items.PlankPlaned, 1, i)));
            }
        }
    }
}
