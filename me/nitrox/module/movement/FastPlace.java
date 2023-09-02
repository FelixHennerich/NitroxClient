package me.nitrox.module.movement;

import java.awt.Color;

import org.lwjgl.input.Keyboard;

import me.nitrox.module.Module;
import me.nitrox.module.ModuleManager;
import me.nitrox.module.utils.Category;
import net.minecraft.client.Minecraft;

public class FastPlace extends Module {


	public FastPlace(String name, String displayname, int KeyBind, int color, Category category) {
		super(name, displayname, KeyBind, color, category);

		name = "FastPlace";
		displayname = "FastPlace";
		KeyBind = 47;
		color = Color.YELLOW.getRGB();
		category = Category.MOVEMENT;
	}


	
	public void onDisable() {
		Minecraft.getMinecraft().rightClickDelayTimer = 5;
		super.onDisable();
	}
	
	public void onUpdate() {
		if(this.isEnabled()) {
			Minecraft.getMinecraft().rightClickDelayTimer = 1;
		}
		super.onUpdate();
	}
	
}
