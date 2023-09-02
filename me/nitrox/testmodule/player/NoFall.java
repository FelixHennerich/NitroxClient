package me.nitrox.testmodule.player;

import org.lwjgl.input.Keyboard;

import me.nitrox.testmodule.Category;
import me.nitrox.testmodule.Module;
import me.nitrox.testmodule.event.EventTarget;
import me.nitrox.testmodule.event.events.EventUpdate;
import net.minecraft.network.play.client.C03PacketPlayer;

public class NoFall extends Module {
    public NoFall() {
        super("NoFall", Keyboard.KEY_B, Category.PLAYER);
    }

    @EventTarget
    public void onUpdate(EventUpdate event) {
        if(mc.thePlayer.fallDistance > 2F)
            mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(true));
    }
}