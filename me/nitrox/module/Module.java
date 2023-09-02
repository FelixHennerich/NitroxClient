package me.nitrox.module;

import me.nitrox.module.utils.Category;
import net.minecraft.client.Minecraft;

public class Module {
		
	private String name;
	private String displayname;
	private Category category;
	private int KeyBind;
	public static  Minecraft mc = Minecraft.getMinecraft();
	private boolean toggled; 
	public int color;
	
	public Module(String name, String displayname, int KeyBind, int color, Category category) {
		this.name = name;
		this.displayname = displayname;
		this.category = category;
		this.KeyBind = KeyBind; 
		this.color = color;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDisplayname() {
		return displayname;
	}
	
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public int getKeyBind() {
		return KeyBind;
	}
	
	public void setKeyBind(int KeyBind) {
		this.KeyBind = KeyBind;
	}
	
	public int getColor() {
		return color;
	}
	
	public void setColor(int color) {
		this.color = color;
	}
	
	public boolean isEnabled() {
		return this.toggled;
	}
	
	public void setEnabled(boolean enabled) {
		onToggle();
		if(enabled == true) {
			this.toggled = true;
			onEnable();
		}else {
			this.toggled = false;
			onDisable();
		}
	}
	
	public void toggleMod() {
		if(this.toggled) {
			this.toggled = false;
			onDisable();
		}else {
			this.toggled = true;
			onEnable();
		}
	}
	
	public void onToggle() {}
	
	public void onUpdate() {}
	
	public void onEnable() {}
	
	public void onDisable() {}
	
	public void onRender() {}
	
	public boolean isCategory(Category category) {
		return this.category == category;
	}
	
	
}
