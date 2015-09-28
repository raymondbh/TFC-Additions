package org.rbh.tfcadditions.Items.Tools;

import com.bioxx.tfc.Items.Tools.ItemTerraTool;
import com.bioxx.tfc.api.Enums.EnumItemReach;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import org.rbh.tfcadditions.Core.CreativeTabs;
import org.rbh.tfcadditions.Reference.Reference;

import java.util.Set;

/**
 * Created by raymond on 07.08.2015.
 */
public class ItemPlaner extends ItemTerraTool {

    private static final Set<Block> BLOCKS = Sets.newHashSet(new Block[] {});

    public ItemPlaner(ToolMaterial e){
        super(0F, e, BLOCKS);
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

    @Override
    public Multimap getItemAttributeModifiers()
    {
        return HashMultimap.create();
    }
}
