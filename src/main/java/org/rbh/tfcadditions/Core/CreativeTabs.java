package org.rbh.tfcadditions.Core;

import com.bioxx.tfc.Core.TFCTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by rbh on 13.09.2015.
 */
public class CreativeTabs extends TFCTabs {

    public static final net.minecraft.creativetab.CreativeTabs TFCAdditions_Tab = new CreativeTabs("TFCAdditions");

    private ItemStack is;

    public CreativeTabs(String par2Str){ super(par2Str);}

    public CreativeTabs(String par2Str, int icon) {
        super(par2Str, icon);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public Item getTabIconItem()
    {
        return is.getItem();
    }

    public void setTabIconItem(Item i)
    {
        is = new ItemStack(i);
    }

    @Override
    public ItemStack getIconItemStack()
    {
        return is;
    }

    public void setTabIconItemStack(ItemStack stack)
    {
        is = stack;
    }
}
