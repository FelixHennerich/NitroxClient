package me.nitrox.test;

import java.awt.Color;

import me.nitrox.main.NitroxClient;
import me.nitrox.module.Module;
import me.nitrox.module.ModuleManager;
import me.nitrox.module.movement.FastPlace;
import me.nitrox.module.movement.Fly;
import me.nitrox.module.render.ChestESP;
import me.nitrox.module.render.RenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;

public class HUD {

	public Minecraft mc = Minecraft.getMinecraft();

	public void draw() {
		ScaledResolution sr = new ScaledResolution(mc);
		FontRenderer fr = mc.fontRendererObj;
				
		int count = 0;
		int offset = count * (fr.FONT_HEIGHT + 6);

		int on = 0;
		for (Module m : ModuleManager.getMods()) {
			if (m.isEnabled()) {
			
		
			if(m.getName().equals("FastPlace")) {
				fr.drawStringWithShadow(m.getDisplayname(), sr.getScaledWidth() - fr.getStringWidth(m.getDisplayname()) - 4, 1, m.getColor());
			}
			if(m.getName().equals("FullBright")) {
				fr.drawStringWithShadow(m.getDisplayname(), sr.getScaledWidth() - fr.getStringWidth(m.getDisplayname()) - 4, 11, m.getColor());
			}
			if(m.getName().equals("ChestESP")) {
				fr.drawStringWithShadow(m.getDisplayname(), sr.getScaledWidth() - fr.getStringWidth(m.getDisplayname()) - 4, 21,  m.getColor());
			}
			if(m.getName().equals("Fly")) {
				fr.drawStringWithShadow(m.getDisplayname(), sr.getScaledWidth() - fr.getStringWidth(m.getDisplayname()) - 4, 31,  m.getColor());
			}
			
			
			}
		}
	}

}
