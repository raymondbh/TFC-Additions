package org.rbh.tfcadditions.Proxy;

import com.bioxx.tfc.api.Tools.ChiselManager;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import org.rbh.tfcadditions.Blocks.BlockSetup;
import org.rbh.tfcadditions.Items.ItemSetup;
import org.rbh.tfcadditions.Tools.ChiselMode_Dent;
import org.rbh.tfcadditions.Tools.ChiselMode_DentSmall;


/**
 * Created by raymondbh on 15.07.2015.
 */
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event){
        BlockSetup.LoadBlocks();
        BlockSetup.RegisterBlocks();

        ItemSetup.LoadItems();
        ItemSetup.RegisterItems();
    }

    public void Init(FMLInitializationEvent event){
        ChiselManager.getInstance().addChiselMode(new ChiselMode_Dent("Dent"));
        ChiselManager.getInstance().addChiselMode(new ChiselMode_DentSmall("DentSmall"));
        //ChiselManager.getInstance().addChiselMode(new ChiselMode_Slope("Slope"));
    }

    public void postInit(FMLPostInitializationEvent event){

    }

    public void registerKeyBindingHandler(){

    }
}
