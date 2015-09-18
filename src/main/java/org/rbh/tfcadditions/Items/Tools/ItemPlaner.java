package org.rbh.tfcadditions.Items.Tools;

import com.bioxx.tfc.Items.Tools.ItemTerraTool;
import com.bioxx.tfc.api.Enums.EnumItemReach;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import org.rbh.tfcadditions.Core.CreativeTabs;
import org.rbh.tfcadditions.Reference.Reference;

/**
 * Created by raymond on 07.08.2015.
 */
public class ItemPlaner extends ItemTerraTool {

    public ItemPlaner(ToolMaterial e){
        super(0F, e, Sets.newHashSet(new Block[]{}));
        this.setMaxDamage(e.getMaxUses());
        setCreativeTab(CreativeTabs.TFCAdditions_Tab);
    }
    @Override
    public EnumSize getSize(ItemStack is)
    {
        return EnumSize.VERYSMALL;
    }

    @Override
    public EnumItemReach getReach(ItemStack is){
        return EnumItemReach.SHORT;
    }

    @Override
    public void registerIcons(IIconRegister registerer){
        this.itemIcon = registerer.registerIcon(Reference.ModID + ":" + "tools/" + "Wood Planer");
    }
}
