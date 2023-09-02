package me.nitrox.module.movement;

import me.nitrox.listener.EventUpdate;
import me.nitrox.module.Module;
import me.nitrox.module.utils.Category;

public class Fly extends Module {

	public static boolean fly;
	
	public Fly(String name, String displayname, int KeyBind, int color, Category category) {
		super(name, displayname, KeyBind, color, category);
	}

	public void onDisable() {
		mc.thePlayer.capabilities.isFlying = false;
		super.onDisable();
	}
	
	public void onUpdate() {
		if(this.isEnabled()) {
			mc.thePlayer.capabilities.isFlying = true;
		}
		super.onUpdate();
	}
	
	
}
