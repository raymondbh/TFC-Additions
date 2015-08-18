package org.rbh.tfcadditions.Handlers;

import com.bioxx.tfc.Core.Player.PlayerInfo;
import com.bioxx.tfc.Core.Player.PlayerManagerTFC;
import com.bioxx.tfc.Handlers.Network.AbstractPacket;
import com.bioxx.tfc.Handlers.Network.KeyPressPacket;
import com.bioxx.tfc.Items.Tools.ItemChisel;
import com.bioxx.tfc.TerraFirmaCraft;
import com.bioxx.tfc.api.Tools.ChiselManager;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;
import org.rbh.tfcadditions.Reference.Reference;

/**
 * Created by raymond on 07.08.2015.
 */
public class KeyBindingHandler {

    public static KeyBinding Key_PrevChiselMode = new KeyBinding("key.PrevChiselMode", Keyboard.KEY_N/*49*/, Reference.ModName);

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        PlayerInfo pi = PlayerManagerTFC.getInstance().getClientPlayer();
        EntityClientPlayerMP player = FMLClientHandler.instance().getClient().thePlayer;

        if (FMLClientHandler.instance().getClient().inGameHasFocus &&
                FMLClientHandler.instance().getClient().thePlayer.getCurrentEquippedItem() != null &&
                FMLClientHandler.instance().getClient().currentScreen == null) {
            if (Key_PrevChiselMode.isPressed()) {
                if (player.getCurrentEquippedItem().getItem() instanceof ItemChisel) {
                    pi.setChiselMode(prevChiselMode(pi));
                    //Let's send the actual ChiselMode so the server/client does not
                    //come out of sync.
                    AbstractPacket pkt = new KeyPressPacket(pi.ChiselMode);
                    TerraFirmaCraft.packetPipeline.sendToServer(pkt);

                }
            }
        }
    }
    public byte prevChiselMode(PlayerInfo pi){

        if(pi.ChiselMode == 0)
            return (byte)(ChiselManager.getInstance().getSize() - 1);

        return --pi.ChiselMode;
    }
}
