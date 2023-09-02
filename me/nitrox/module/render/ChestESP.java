package me.nitrox.module.render;

import java.awt.Color;
import java.util.ArrayList;

import javax.xml.stream.Location;

import org.lwjgl.input.Keyboard;

import me.nitrox.listener.EventUpdate;
import me.nitrox.module.Module;
import me.nitrox.module.ModuleManager;
import me.nitrox.module.utils.Category;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.ChatComponentText;

public class ChestESP extends Module {

	public static int message;
	
	public ChestESP(String name, String displayname, int KeyBind, int color, Category category) {
		super(name, displayname, KeyBind, color, category);
		name = "ChestESP";
		displayname = "ChestESP";
		KeyBind = Keyboard.KEY_Z;
		color = Color.WHITE.getRGB();
		category = Category.RENDER;

	}
	
	public void onDisable() {
		message = 0;
		super.onDisable();
	}

	public void onRender() {
		if(this.isEnabled()) {
			for(Object o: mc.theWorld.loadedTileEntityList) {
				if(o instanceof TileEntityChest) {
					RenderUtils.blockESPBox(((TileEntityChest)o).getPos());
					if(!(message == 1)) {
					Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("§7§kIII§r §6§lKiste » §4" + ((TileEntityChest)o).getPos()));
					message = 1;
					}
				}
			}
		}
	}
}
