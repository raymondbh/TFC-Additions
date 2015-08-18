package org.rbh.tfcadditions.Items.Tools;

import com.bioxx.tfc.Items.Tools.ItemTerraTool;
import com.bioxx.tfc.api.Enums.EnumItemReach;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

/**
 * Created by raymond on 07.08.2015.
 */
public class ItemPlaner extends ItemTerraTool {

    public ItemPlaner(ToolMaterial e){
        super(0F, e, Sets.newHashSet(new Block[]{}));
        this.setMaxDamage(e.getMaxUses());
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
}
