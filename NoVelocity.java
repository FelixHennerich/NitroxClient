package me.nitrox.module.MODULE_player;

import java.util.ArrayList;

import me.nitrox.main.NitroxClient;
import me.nitrox.module.Category;
import me.nitrox.module.Module;
import me.nitrox.module.event.Event;
import me.nitrox.module.event.EventTarget;
import me.nitrox.module.event.events.EventPostMotionUpdate;
import me.nitrox.module.event.events.EventPreMotionUpdate;
import me.nitrox.module.event.events.EventTick;
import me.nitrox.module.event.events.EventUpdate;
import me.nitrox.module.event.events.EventVelocity;
import me.nitrox.module.settings.Setting;
import me.nitrox.module.utils.OnlineRotation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.item.ItemSword;
import net.minecraft.network.play.server.S12PacketEntityVelocity;
import net.minecraft.util.MovementInput;
import net.minecraft.util.Vec3;

public class NoVelocity extends Module {

	private boolean shouldReduce;
	private float lastTimer;
    private boolean playerAttacking = false;
    private boolean ignoreVelocity = false;
    private float velocityDirection = 0.0F;
    private Vec3 velocityStart = null;
    private S12PacketEntityVelocity velocityPacket = null;

	public NoVelocity() {
		super("No Velocity", 0, Category.PLAYER);
		// TODO Auto-generated constructor stub
	}

    public void setMotion(double paramDouble) {
        double d1 = this.mc.thePlayer.movementInput.moveForward;
        double d2 = this.mc.thePlayer.movementInput.moveStrafe;
        float f = OnlineRotation.getOnlineYaw();
        if ((d1 == 0.0D) && (d2 == 0.0D)) {
            this.mc.thePlayer.motionX = 0.0D;
            this.mc.thePlayer.motionZ = 0.0D;
        } else {
            if (d1 != 0.0D) {
                if (d2 > 0.0D) {
                    f += (d1 > 0.0D ? -45 : 45);
                } else if (d2 < 0.0D) {
                    f += (d1 > 0.0D ? 45 : -45);
                }
                d2 = 0.0D;
                if (d1 > 0.0D) {
                    d1 = 1.0D;
                } else if (d1 < 0.0D) {
                    d1 = -1.0D;
                }
            }
            this.mc.thePlayer.motionX = (d1 * paramDouble * Math.cos(Math.toRadians(f + 90.0F)) + d2 * paramDouble * Math.sin(Math.toRadians(f + 90.0F)));
            this.mc.thePlayer.motionZ = (d1 * paramDouble * Math.sin(Math.toRadians(f + 90.0F)) - d2 * paramDouble * Math.cos(Math.toRadians(f + 90.0F)));
        }
    }
	
	public static void setSpeed(double paramDouble, float paramFloat) {
		Minecraft localMinecraft = Minecraft.getMinecraft();
		MovementInput localMovementInput = localMinecraft.thePlayer.movementInput;
		float f1 = localMovementInput.moveForward;
		float f2 = localMovementInput.moveStrafe;
		if ((f1 == 0.0F) && (f2 == 0.0F)) {
			localMinecraft.thePlayer.motionX = 0.0D;
			localMinecraft.thePlayer.motionZ = 0.0D;
		} else if (f1 != 0.0F) {
			if (f2 >= 1.0F) {
				paramFloat += (f1 > 0.0F ? -45 : 45);
				f2 = 0.0F;
			} else if (f2 <= -1.0F) {
				paramFloat += (f1 > 0.0F ? 45 : -45);
				f2 = 0.0F;
			}
			if (f1 > 0.0F) {
				f1 = 1.0F;
			} else if (f1 < 0.0F) {
				f1 = -1.0F;
			}
		}
		double d1 = Math.cos(Math.toRadians(paramFloat + 90.0F));
		double d2 = Math.sin(Math.toRadians(paramFloat + 90.0F));
		double d3 = f1 * paramDouble * d1 + f2 * paramDouble * d2;
		double d4 = f1 * paramDouble * d2 - f2 * paramDouble * d1;
		localMinecraft.thePlayer.motionX = d3;
		localMinecraft.thePlayer.motionZ = d4;
	}

	@Override
	public void setup() {
		ArrayList<String> options = new ArrayList<>();
		options.add("Legit");
		options.add("Push");
		options.add("AAC4");
		options.add("AAC3");
		NitroxClient.instance.settingsManager.rSetting(new Setting("Velocity Mode", this, "Push", options));
	}

	@EventTarget
	public void onUpdate(EventUpdate paramEvent) {
		this.setDisplayName("No Velocity §7" + NitroxClient.instance.settingsManager.getSettingByName("Velocity Mode").getValString());
		 if (NitroxClient.instance.settingsManager.getSettingByName("Velocity Mode").getValString().equalsIgnoreCase("Push")
				&& (MC.thePlayer.hurtTime > 0) && (MC.thePlayer.hurtTime < 10)) {
			MC.thePlayer.motionX *= 0.6D;
			MC.thePlayer.motionZ *= 0.6D;
			EntityPlayerSP tmp183_180 = MC.thePlayer;
			tmp183_180.jumpMovementFactor = ((float) (tmp183_180.jumpMovementFactor * 10.15D));
		}
		if (NitroxClient.instance.settingsManager.getSettingByName("Velocity Mode").getValString().equalsIgnoreCase("Legit")) {
			if (MC.thePlayer.hurtTime == 9) {
				MC.thePlayer.motionX *= 0.5D;
				MC.thePlayer.motionZ *= 0.5D;
			}
			if (MC.thePlayer.hurtTime == 8) {
				MC.thePlayer.motionX *= 0.5D;
				MC.thePlayer.motionZ *= 0.5D;
			}
			if (MC.thePlayer.hurtTime == 7) {
				MC.thePlayer.motionX *= 0.4D;
				MC.thePlayer.motionZ *= 0.4D;
			}
		}
		if (NitroxClient.instance.settingsManager.getSettingByName("Velocity Mode").getValString().equalsIgnoreCase("AAC4")) {
			if(((this.mc.thePlayer.hurtTime == 3) || (this.mc.thePlayer.hurtTime == 4))) {
				setMotion(0.05D);
			}
            if (this.mc.thePlayer.hurtTime == 10) {
                this.velocityStart = new Vec3(this.mc.thePlayer.motionX, 0.0D, this.mc.thePlayer.motionZ);
            }
            if ((this.mc.thePlayer.onGround) && (this.velocityPacket != null)) {
                this.mc.thePlayer.sendQueue.handleEntityVelocity(this.velocityPacket);
                this.velocityPacket = null;
            }
            if (!this.ignoreVelocity) {
                handleAAC4Velocity();
            }
		}
		if(NitroxClient.instance.settingsManager.getSettingByName("Velocity Mode").getValString().equalsIgnoreCase("AAC3")) {
			
		}
		if (((paramEvent instanceof EventUpdate)) && (MC.thePlayer.hurtTime == 10)) {
			this.lastTimer = MC.timer.timerSpeed;
			this.shouldReduce = (!this.shouldReduce);
		}
		
	}
    private void handleAAC4Velocity() {
        if (!this.mc.thePlayer.isSprinting()) {
            return;
        }
        int i = this.mc.thePlayer.isBlocking() || (this.mc.thePlayer.getCurrentEquippedItem() != null) && ((this.mc.thePlayer.getCurrentEquippedItem().getItem() instanceof ItemSword)) ? 1 : 0;
        if ((this.mc.thePlayer.hurtTime != 0) && (i == 0) && (this.mc.thePlayer.onGround)) {
            this.mc.thePlayer.jump();
        } else if ((i != 0) && (this.playerAttacking)) {
            this.playerAttacking = false;
            this.mc.thePlayer.motionX *= 0.9D;
            this.mc.thePlayer.motionZ *= 0.9D;
        }
    }
}
