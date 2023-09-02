package me.nitrox.module;

import java.awt.Color;
import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

import me.nitrox.main.NitroxClient;
import me.nitrox.module.movement.FastPlace;
import me.nitrox.module.movement.Fly;
import me.nitrox.module.render.ChestESP;
import me.nitrox.module.render.FullBright;
import me.nitrox.module.utils.Category;
import net.minecraft.client.entity.AbstractClientPlayer;

public class ModuleManager {

	public static ArrayList<Module> activeMods = new ArrayList<Module>();
	
	// Register
	public ModuleManager() {
		this.addModule(new ChestESP("ChestESP", "ChestESP", Keyboard.KEY_Z, Color.YELLOW.getRGB(), Category.RENDER));
		this.addModule(new FastPlace("FastPlace", "FastPlace", Keyboard.KEY_V, Color.YELLOW.getRGB(), Category.MOVEMENT));
		this.addModule(new Fly("Fly", "Fly", Keyboard.KEY_G, Color.YELLOW.getRGB(), Category.MOVEMENT));
		this.addModule(new FullBright("FullBright","FullBright", Keyboard.KEY_NUMPAD0, Color.YELLOW.getRGB(), Category.RENDER));
	}

	public static void addModule(Module module) {
		activeMods.add(module);
	}

	public static ArrayList<Module> getMods() {
		return activeMods;
	}

	public static Module getModuleByName(String name) {
		try {
			for (Module mod : activeMods) {
				if ((mod.getName().trim().equalsIgnoreCase(name.trim()))
						|| (mod.toString().trim().equalsIgnoreCase(name.trim()))) {
					return mod;
				}
			}
		} catch (Exception e) {
		}
		return null;
	}

	public static void onKeypressed(int k) {
		for (Module m : activeMods) {
			if (m.getKeyBind() == k) {
				m.toggleMod();
			}
		}
	}
	
	public static void onRender() {
		for(Module m: activeMods) {
			m.onRender();
		}
	}

}
