package me.nitrox.command;

import joptsimple.HelpFormatter;
import me.nitrox.main.NitroxClient;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class CommandRegister {
	
	private static String Nitrox1 = ".Nitrox";
	private static String Nitrox2 = ".nitrox";
	private static String Nitrox3 = ".nITROX";
	private static String Nitrox4 = ".NITROX";
	
	public static void helpMenu() {
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(NitroxClient.pre + "§6-- §fHelp §fMenu §6--"));
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(NitroxClient.pre + "§c.Nitrox §c fps"));
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(NitroxClient.pre + "§c.Nitrox §c ping"));
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(NitroxClient.pre + "§c.Nitrox §c help"));
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(NitroxClient.pre + "§c.Nitrox §c test"));
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(NitroxClient.pre + "§c.Nitrox §c support"));
	}
	
	public static void AllCommandRegister(String message) {
		/*String[] nachricht = message.split("");
		int ping = Minecraft.getMinecraft().getNetHandler().getPlayerInfo(Minecraft.getMinecraft().thePlayer.getUniqueID()).getResponseTime();
		int fps = Minecraft.getDebugFPS();
		
		if(message.startsWith(Nitrox1) || message.startsWith(Nitrox2) || message.startsWith(Nitrox3) || message.startsWith(Nitrox4)) {
			
			if(nachricht.length == 7) {
				if(nachricht[0] != null) {
					helpMenu();
				}
			}else if(nachricht.length == 11){
				if(message.contains(".Nitrox fps")) {
					Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(NitroxClient.pre + "§cDeine §cFPS §8[§5FramesPerSecond§8] §cbetragen §c: " + fps));
				}
			}else if(nachricht.length == 12) {
				if(message.contains(".Nitrox test")) {
					Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(NitroxClient.pre + "§cDies §cist §cein §cTest §cder §cvom §cOffiziellen §cNitrox-Client §causgeführt §cwird!"));
				}else if(message.contains(".Nitrox ping")) {
					Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(NitroxClient.pre + "§cDein §cPing §czum §cNetzwerk §cbeträgt §c: " + ping));
				}else if(message.contains(".Nitrox help")) {
					helpMenu();
				}
			}else if(nachricht.length == 15){
				if(message.contains(".Nitrox support")) {
					Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(NitroxClient.pre + "§cDu §cbrauchst §cSupport? §cMelde §cdich §cauf §cDiscord §cbei §51BlueNitrox | Java-Developer#5360§c."));
				}
			}else {
				helpMenu();
			}
			
			
			}
		}*/
	}
}
