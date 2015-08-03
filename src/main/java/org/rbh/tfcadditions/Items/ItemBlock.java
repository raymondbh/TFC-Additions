package org.rbh.tfcadditions.Items;

import com.bioxx.tfc.Items.ItemBlocks.ItemTerraBlock;
import net.minecraft.block.Block;
import org.rbh.tfcadditions.Blocks.Dent.BlockIGEXDent;
import org.rbh.tfcadditions.Blocks.Dent.BlockIGINDent;
import org.rbh.tfcadditions.Blocks.Dent.BlockMMDent;
import org.rbh.tfcadditions.Blocks.DentSmall.BlockIGEXDentSmall;
import org.rbh.tfcadditions.Blocks.DentSmall.BlockIGINDentSmall;
import org.rbh.tfcadditions.Blocks.DentSmall.BlockMMDentSmall;
import org.rbh.tfcadditions.Reference.Names;

/**
 * Created by raymondbh on 24.07.2015.
 */
public class ItemBlock extends ItemTerraBlock {
    public ItemBlock(Block block){
        super(block);
        if(block instanceof BlockMMDent) MetaNames = Names.STONE_MM;
        else if(block instanceof BlockMMDentSmall) MetaNames = Names.STONE_MM;
        else if(block instanceof BlockIGEXDent) MetaNames = Names.STONE_IGEX;
        else if(block instanceof BlockIGEXDentSmall) MetaNames = Names.STONE_IGEX;
        else if(block instanceof BlockIGINDent) MetaNames = Names.STONE_IGIN;
        else if(block instanceof BlockIGINDentSmall) MetaNames = Names.STONE_IGIN;
    }
}
