package me.nitrox.main;

import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.lwjgl.opengl.Display;

import me.nitrox.module.Module;
//import me.nitrox.module.ModuleManager;
import me.nitrox.module.render.RenderUtils;
import me.nitrox.test.HUD;
import me.nitrox.testmodule.ModuleManager;
import me.nitrox.testmodule.event.EventManager;
import me.nitrox.testmodule.event.EventTarget;
import me.nitrox.testmodule.event.events.EventKey;
import me.nitrox.testmodule.render.ClickGUI;
import me.nitrox.testmodule.settings.SettingsManager;
import net.minecraft.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;

public class NitroxClient {

	public static String name = "NitroxClient";
	public static double version = 1.0;
	public static String versionS = " Beta v" + version;
	public static String author = " by 1BlueNitrox";
	private static float test;
	public static ModuleManager modulemanager;
	public static String pre = "§8» ";
	public static Minecraft mc = Minecraft.getMinecraft();

	
	public static HUD hud = new HUD();	
	
	
	public static NitroxClient instance = new NitroxClient();

    public static SettingsManager settingsManager;
    public static EventManager eventManager;
    public static ModuleManager moduleManager;
    public static ClickGUI clickGui;
	
	public static void nameChange() {
		Display.setTitle(name + versionS);
		modulemanager = new ModuleManager();
	
		settingsManager = new SettingsManager();
        eventManager = new EventManager();
        moduleManager = new ModuleManager();
        clickGui = new ClickGUI();


        eventManager.register(new NitroxClient());
	}


	public static void ingameGUI() {
		ScaledResolution sr = new ScaledResolution(mc);
		FontRenderer fr = mc.fontRendererObj;
		
		String m = "FPS";
		Gui.drawRect(sr.getScaledWidth() - fr.getStringWidth(m) - 212, sr.getScaledHeight(), sr.getScaledWidth(),sr.getScaledHeight() - sr.getScaledHeight()/16 , Color.DARK_GRAY.getRGB());
		Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("§5FPS: " + Minecraft.getDebugFPS(), 429 + 10, sr.getScaledHeight() - 19, Color.BLACK.getRGB());
		Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("§5Ping: " + Minecraft.getMinecraft().getCurrentServerData().pingToServer, 429 + 10, sr.getScaledHeight() - 10, Color.BLACK.getRGB());
		mc.fontRendererObj.drawStringWithShadow("§5Server: " +  Minecraft.getMinecraft().getCurrentServerData().serverIP, 439+60, sr.getScaledHeight()- 14, Color.BLACK.getRGB());
		GlStateManager.scale(2,  2, 1);
		Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(name, 2, 1, Color.ORANGE.getRGB());
		GlStateManager.scale(0.5,  0.5, 0.25);
		Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(versionS, 4, 30, Color.ORANGE.getRGB());
		Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(author, 4, 20, Color.ORANGE.getRGB());
		GlStateManager.scale(3, 3, 3);
		Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("§b«", 207,113, Color.white.getRGB());
		Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("§b»", 139,113, Color.white.getRGB());
		GlStateManager.scale(0.334, 0.334, 0.334);	
		
	}
	
	public static ModuleManager getModuleManager() {
		return modulemanager;
	}
	
    public void stopClient() {
        eventManager.unregister(this);
    }
	
	@EventTarget
    public void onKey(EventKey event) {
        moduleManager.getModules().stream().filter(module -> module.getKey() == event.getKey()).forEach(module -> module.toggle());
    }
}
