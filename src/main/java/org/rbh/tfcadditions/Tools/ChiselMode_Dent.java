package org.rbh.tfcadditions.Tools;

import com.bioxx.tfc.Blocks.Terrain.BlockStone;
import com.bioxx.tfc.Core.TFC_Core;
import com.bioxx.tfc.api.TFCBlocks;
import com.bioxx.tfc.api.Tools.ChiselMode;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.rbh.tfcadditions.Blocks.BlockSetup;
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
            if(id == TFCBlocks.StoneIgIn || id == TFCBlocks.StoneIgInSmooth || id == BlockSetup.StoneIGINDentSmall) {
                world.setBlock(x, y, z, BlockSetup.StoneIGINDent, meta, 0x2);
            } else if(id == TFCBlocks.StoneIgEx || id == TFCBlocks.StoneIgExSmooth || id == BlockSetup.StoneIGEXDentSmall) {
                world.setBlock(x, y, z, BlockSetup.StoneIGEXDent, meta, 0x2);
            //} else if(id == TFCBlocks.StoneSed) {
            //    world.setBlock(x, y, z, TFCBlocks.StoneSedSmooth, meta, 0x2);
            } else if(id == TFCBlocks.StoneMM || id == TFCBlocks.StoneMMSmooth || id == BlockSetup.StoneMMDentSmall) {
                world.setBlock(x, y, z, BlockSetup.StoneMMDent, meta, 0x2);
            }

            player.inventory.mainInventory[hasChisel].damageItem(1, player);
        }

        return true;
    }
}
