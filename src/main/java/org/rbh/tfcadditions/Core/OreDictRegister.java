package org.rbh.tfcadditions.Core;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by raymondbh on 18.09.2015.
 */
public class OreDictRegister {

    public static void registerOreDict(){

        final int WILD = OreDictionary.WILDCARD_VALUE;

        for (Item planer : Recipes.planers)
            OreDictionary.registerOre("itemPlaner", new ItemStack(planer, 1, WILD));
    }
}
