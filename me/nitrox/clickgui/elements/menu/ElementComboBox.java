package me.nitrox.clickgui.elements.menu;

import java.awt.Color;

import me.nitrox.clickgui.elements.Element;
import me.nitrox.clickgui.elements.ModuleButton;
import me.nitrox.clickgui.util.ColorUtil;
import me.nitrox.clickgui.util.FontUtil;
import me.nitrox.main.NitroxClient;
import me.nitrox.testmodule.settings.Setting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;



public class ElementComboBox extends Element {
	/*
	 * Konstrukor
	 */
	public ElementComboBox(ModuleButton iparent, Setting iset) {
		parent = iparent;
		set = iset;
		super.setup();
	}

	
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		Color temp = ColorUtil.getClickGUIColor();
		int color = new Color(temp.getRed(), temp.getGreen(), temp.getBlue(), 150).getRGB();
		
		
		Gui.drawRect(x, y, x + width, y + height, 0xff1a1a1a);

		FontUtil.drawTotalCenteredString(setstrg, x + width / 2, y + 15/2, 0xffffffff);
		int clr1 = color;
		int clr2 = temp.getRGB();

		Gui.drawRect(x, y + 14, x + width, y + 15, 0x77000000);
		if (comboextended) {
			Gui.drawRect(x, y + 15, x + width, y + height, 0xaa121212);
			double ay = y + 15;
			for (String sld : set.getOptions()) {
				String elementtitle = sld.substring(0, 1).toUpperCase() + sld.substring(1, sld.length());
				FontUtil.drawCenteredString(elementtitle, x + width / 2, ay + 2, 0xffffffff);
				
				
				if (sld.equalsIgnoreCase(set.getValString())) {
					Gui.drawRect(x, ay, x + 1.5, ay + FontUtil.getFontHeight() + 2, clr1);
				}
				
				if (mouseX >= x && mouseX <= x + width && mouseY >= ay && mouseY < ay + FontUtil.getFontHeight() + 2) {
					Gui.drawRect(x + width - 1.2, ay, x + width, ay + FontUtil.getFontHeight() + 2, clr2);
				}
				ay += FontUtil.getFontHeight() + 2;
			}
		}
	}

	
	public boolean mouseClicked(int mouseX, int mouseY, int mouseButton) {
		if (mouseButton == 0) {
			if (isButtonHovered(mouseX, mouseY)) {
				comboextended = !comboextended;
				return true;
			}
			
			
			if (!comboextended)return false;
			double ay = y + 15;
			for (String slcd : set.getOptions()) {
				if (mouseX >= x && mouseX <= x + width && mouseY >= ay && mouseY <= ay + FontUtil.getFontHeight() + 2) {
					if(NitroxClient.instance.settingsManager.getSettingByName("Sound").getValBoolean())
					Minecraft.getMinecraft().thePlayer.playSound("tile.piston.in", 20.0F, 20.0F);
					
					if(clickgui != null && clickgui.setmgr != null)
					clickgui.setmgr.getSettingByName(set.getName()).setValString(slcd.toLowerCase());
					return true;
				}
				ay += FontUtil.getFontHeight() + 2;
			}
		}

		return super.mouseClicked(mouseX, mouseY, mouseButton);
	}

	/*
	 * Einfacher HoverCheck, bentigt damit die Combobox geffnet und geschlossen werden kann
	 */
	public boolean isButtonHovered(int mouseX, int mouseY) {
		return mouseX >= x && mouseX <= x + width && mouseY >= y && mouseY <= y + 15;
	}
}
