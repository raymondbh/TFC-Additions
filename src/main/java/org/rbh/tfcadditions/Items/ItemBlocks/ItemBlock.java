package org.rbh.tfcadditions.Items.ItemBlocks;

import com.bioxx.tfc.Items.ItemBlocks.ItemTerraBlock;
import net.minecraft.block.Block;
import org.rbh.tfcadditions.Blocks.Dent.BlockIGEXDent;
import org.rbh.tfcadditions.Blocks.Dent.BlockIGINDent;
import org.rbh.tfcadditions.Blocks.Dent.BlockMMDent;
import org.rbh.tfcadditions.Blocks.Dent.BlockSEDDent;
import org.rbh.tfcadditions.Blocks.DentSmall.BlockIGEXDentSmall;
import org.rbh.tfcadditions.Blocks.DentSmall.BlockIGINDentSmall;
import org.rbh.tfcadditions.Blocks.DentSmall.BlockMMDentSmall;
import org.rbh.tfcadditions.Blocks.DentSmall.BlockSEDDentSmall;
import org.rbh.tfcadditions.Blocks.Dent.BlockPlankDent;
import org.rbh.tfcadditions.Reference.Names;

/**
 * Created by raymondbh on 24.07.2015.
 */
public class ItemBlock extends ItemTerraBlock {
    public ItemBlock(Block block){
        super(block);
        if(block instanceof BlockMMDent) metaNames = Names.STONE_MM;
        else if(block instanceof BlockMMDentSmall) metaNames = Names.STONE_MM;
        else if(block instanceof BlockIGEXDent) metaNames = Names.STONE_IGEX;
        else if(block instanceof BlockIGEXDentSmall) metaNames = Names.STONE_IGEX;
        else if(block instanceof BlockIGINDent) metaNames = Names.STONE_IGIN;
        else if(block instanceof BlockIGINDentSmall) metaNames = Names.STONE_IGIN;
        else if(block instanceof BlockSEDDent) metaNames = Names.STONE_SED;
        else if(block instanceof BlockSEDDentSmall) metaNames = Names.STONE_SED;
        else if(block instanceof BlockPlankDent) metaNames = Names.WOOD_ALL;
    }
}
