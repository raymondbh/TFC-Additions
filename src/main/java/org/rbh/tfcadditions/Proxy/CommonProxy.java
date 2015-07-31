package org.rbh.tfcadditions.Proxy;

import com.bioxx.tfc.api.Tools.ChiselManager;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import org.rbh.tfcadditions.Blocks.BlockSetup;
import org.rbh.tfcadditions.Tools.ChiselMode_Dent;
import org.rbh.tfcadditions.Tools.ChiselMode_DentSmall;

/**
 * Created by raymondbh on 15.07.2015.
 */
public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event){
        BlockSetup.LoadBlocks();
        BlockSetup.RegisterBlocks();
    }

    public void Init(FMLInitializationEvent event){
        ChiselManager.getInstance().addChiselMode(new ChiselMode_Dent("Dent"));
        ChiselManager.getInstance().addChiselMode(new ChiselMode_DentSmall("DentSmall"));
    }

    public void postInit(FMLPostInitializationEvent event){

    }
}
