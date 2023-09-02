package me.nitrox.testmodule.combat;

import net.minecraft.entity.Entity;
import net.minecraft.network.play.server.S0CPacketSpawnPlayer;
import me.nitrox.testmodule.Category;
import me.nitrox.testmodule.Module;
import me.nitrox.testmodule.event.EventTarget;
import me.nitrox.testmodule.event.events.EventReceivePacket;
import me.nitrox.testmodule.event.events.EventUpdate;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

public class AntiBotCombat extends Module {
    public AntiBotCombat() {
        super("AntiBot", Keyboard.KEY_M, Category.COMBAT);
    }

    @Override
    public void setup() {
        ArrayList<String> options = new ArrayList<>();
        options.add("Advanced");
        options.add("Watchdog");
        Tutorial.instance.settingsManager.rSetting(new Setting("AntiBot Mode", this, "Advanced", options));
    }

    @EventTarget
    public void onReceivePacket(EventReceivePacket event) {
        String mode = Tutorial.instance.settingsManager.getSettingByName("AntiBot Mode").getValString();

        if(mode.equalsIgnoreCase("Advanced") && event.getPacket() instanceof S0CPacketSpawnPlayer) {
            S0CPacketSpawnPlayer packet = (S0CPacketSpawnPlayer)event.getPacket();
            double posX = packet.getX() / 32D;
            double posY = packet.getY() / 32D;
            double posZ = packet.getZ() / 32D;

            double diffX = mc.thePlayer.posX - posX;
            double diffY = mc.thePlayer.posY - posY;
            double diffZ = mc.thePlayer.posZ - posZ;

            double dist = Math.sqrt(diffX * diffX + diffY * diffY + diffZ * diffZ);

            if(dist <= 17D && posX != mc.thePlayer.posX && posY != mc.thePlayer.posY && posZ != mc.thePlayer.posZ)
                event.setCancelled(true);
        }
    }

    @EventTarget
    public void onUpdate(EventUpdate event) {
        String mode = Tutorial.instance.settingsManager.getSettingByName("AntiBot Mode").getValString();
        this.setDisplayName("AntiBot \u00A77" + mode);

        if(mode.equalsIgnoreCase("Watchdog"))
            for (Object entity : mc.theWorld.loadedEntityList)
                if (((Entity) entity).isInvisible() && entity != mc.thePlayer)
                    mc.theWorld.removeEntity((Entity) entity);
    }
}
