package me.nitrox.clickgui.util;


import java.awt.Color;

import me.nitrox.main.NitroxClient;


public class ColorUtil {
	
	public static Color getClickGUIColor(){
		return new Color((int) NitroxClient.instance.settingsManager.getSettingByName("GuiRed").getValDouble(), (int)NitroxClient.instance.settingsManager.getSettingByName("GuiGreen").getValDouble(), (int)NitroxClient.instance.settingsManager.getSettingByName("GuiBlue").getValDouble());
	}
}
