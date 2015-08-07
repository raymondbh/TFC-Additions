package org.rbh.tfcadditions.Items.Tools;

import com.bioxx.tfc.Items.Tools.ItemTerraTool;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.Set;

/**
 * Created by raymond on 07.08.2015.
 */
public class ItemPlaner extends ItemTerraTool {

    private static final Set<Block> blocks = Sets.newHashSet(new Block[]{});

    public ItemPlaner(ToolMaterial e){
        super(0, e, blocks);
        this.setMaxDamage(e.getMaxUses() / 2);
    }
}
