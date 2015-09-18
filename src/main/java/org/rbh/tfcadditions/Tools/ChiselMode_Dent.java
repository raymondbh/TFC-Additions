package org.rbh.tfcadditions.Tools;

import com.bioxx.tfc.Blocks.Terrain.BlockStone;
import com.bioxx.tfc.Core.TFC_Core;
import com.bioxx.tfc.api.TFCBlocks;
import com.bioxx.tfc.api.Tools.ChiselMode;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.rbh.tfcadditions.Api.Blocks;
import org.rbh.tfcadditions.Reference.Reference;

/**
 * Created by raymondbh on 15.07.2015.
 */
public class ChiselMode_Dent extends ChiselMode {

    private static String name;
    private static ResourceLocation resourcelocation = new ResourceLocation(Reference.ModID, Reference.AssetPathGui + "icons.png");
    private static int texture_u, texture_v, div;

    public ChiselMode_Dent(String n){
        name = n;
        texture_u = 0;
        texture_v = 0;
        div = 1;
    }

    public ResourceLocation getResourceLocation(){
        return resourcelocation;
    }

    public int getTexture_u(){
        return texture_u;
    }

    public int getTexture_v(){
        return texture_v;
    }

    public int getDivX(Block block){
        if(block instanceof BlockStone){
            return div;
        }
        else {
            return 0;
        }
    }

    public int getDivY(Block block){
        if(block instanceof BlockStone){
            return div;
        }
        else {
            return 0;
        }
    }

    public int getDivZ(Block block){
        if(block instanceof BlockStone){
            return div;
        }
        else {
            return 0;
        }
    }

    public boolean onUsedHandler(World world, EntityPlayer player, int x, int y, int z, Block id, int meta, int side, float hitX, float hitY, float hitZ){

        if(TFC_Core.isNaturalStone(world.getBlock(x, y + 1, z)) && TFC_Core.isNaturalStone(world.getBlock(x, y+2, z))) {
            return false;
        }

        int hasChisel = hasChisel(player);
        if( hasChisel >= 0 ){
            if(id == TFCBlocks.stoneIgIn || id == TFCBlocks.stoneIgInSmooth || id == Blocks.StoneIGINDentSmall) {
                world.setBlock(x, y, z, Blocks.StoneIGINDent, meta, 0x2);
            } else if(id == TFCBlocks.stoneIgEx || id == TFCBlocks.stoneIgExSmooth || id == Blocks.StoneIGEXDentSmall) {
                world.setBlock(x, y, z, Blocks.StoneIGEXDent, meta, 0x2);
            } else if(id == TFCBlocks.stoneSed || id == TFCBlocks.stoneSedSmooth || id == Blocks.StoneSEDDentSmall) {
                world.setBlock(x, y, z, Blocks.StoneSEDDent, meta, 0x2);
            } else if(id == TFCBlocks.stoneMM || id == TFCBlocks.stoneMMSmooth || id == Blocks.StoneMMDentSmall) {
                world.setBlock(x, y, z, Blocks.StoneMMDent, meta, 0x2);
            } else if(id == TFCBlocks.planks ||id == Blocks.PlanksVert) {
                world.setBlock(x, y, z, Blocks.PlanksOutline, meta, 0x2);
            } else if(id == TFCBlocks.planks2 ||id == Blocks.PlanksVert2) {
                world.setBlock(x, y, z, Blocks.PlanksOutline2, meta, 0x2);
            }

            player.inventory.mainInventory[hasChisel].damageItem(1, player);
        }

        return true;
    }
}
