package org.rbh.tfcadditions.Core;

import com.bioxx.tfc.api.TFCItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import org.rbh.tfcadditions.Api.Items;
import org.rbh.tfcadditions.Reference.Names;

/**
 * Created by rbh on 17.09.2015.
 */
public class Recipes {

    public static void registerRecipes(){

        //Wood Recipes
        for(int i = 0; i < Names.WOOD_ALL.length; i++){
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(Items.PlankPlaned, 1, i), new ItemStack(TFCItems.singlePlank, 1, i), "itemPlaner"));
        }
    }
}
