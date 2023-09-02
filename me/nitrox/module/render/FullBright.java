package me.nitrox.module.render;

import me.nitrox.module.Module;
import me.nitrox.module.utils.Category;

public class FullBright extends Module {

	public FullBright(String name, String displayname, int KeyBind, int color, Category category) {
		super(name, displayname, KeyBind, color, category);
		
	}
	
	public void onEnable() {
		mc.gameSettings.gammaSetting = 1000.0F;
		super.onEnable();
	}

	public void onDisable() {
		mc.gameSettings.gammaSetting = 0.0F;
		super.onDisable();
	}
	
}
