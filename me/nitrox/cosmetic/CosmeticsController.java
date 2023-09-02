package me.nitrox.cosmetic;

import net.minecraft.client.entity.AbstractClientPlayer;

public class CosmeticsController {

	public static boolean shouldRenderTopHat(AbstractClientPlayer p) {
		return true;
	}
	
	public static float[] getTopHatColor(AbstractClientPlayer p) {
		return new float[] {1,0,0};
	}
	public static float[] getCapeColor(AbstractClientPlayer p) {
		return new float[] {1,0,0};
	}
	
	
}
