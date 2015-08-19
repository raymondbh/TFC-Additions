package org.rbh.tfcadditions.Reference;

/**
 * Created by raymondbh on 15.07.2015.
 */
public class Reference {
    public static final String ModID = "tfcadditions";
    public static final String ModName = "TFCAdditions";

    public static final String ModVersion = "@MODVERSION@";
    public static final String TFCVersion = "@TFCVERSION@";

    public static final String ModDependencies = "required-after:terrafirmacraft;required-after:CarpentersBlocks;required-after:NotEnoughItems";
    public static final String SERVER_PROXY_CLASS = "org.rbh.tfcadditions.Proxy.CommonProxy";
    public static final String CLIENT_PROXY_CLASS = "org.rbh.tfcadditions.Proxy.ClientProxy";

    public static final String AssetPath = "/assets/" + ModID + "/";
    public static final String AssetPathGui = "textures/gui/";
}
