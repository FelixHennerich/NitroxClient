package me.nitrox.module.combat;

import me.nitrox.module.Module;
import me.nitrox.module.utils.Category;

public class NoVelocity extends Module {

	public NoVelocity(String name, String displayname, int KeyBind, int color, Category category) {
		super(name, displayname, KeyBind, color, category);
		
	}
	
	public static boolean noVelocity;
	
	public void onEnable() {
		noVelocity = true;
		mc.thePlayer.setVelocity(0, 0, 0);
		super.onEnable();
	}
	
	public void onDisable() {
		noVelocity = false;
		super.onDisable();
	}

}
