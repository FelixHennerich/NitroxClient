package me.nitrox.cosmetic;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;

public abstract class CosmeticBase implements LayerRenderer<AbstractClientPlayer> {

	protected final RenderPlayer playerRenderer;
	
	public CosmeticBase(RenderPlayer p) {
		this.playerRenderer = p;
	}
	
	@Override
	public void doRenderLayer(AbstractClientPlayer p, float limbSwing, float limbSwingAmount,float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		if(p.hasPlayerInfo() && !p.isInvisible()) {
			render(p,limbSwing,limbSwingAmount,partialTicks,ageInTicks,netHeadYaw,headPitch,scale);
		}
		
	}

	public abstract void render(AbstractClientPlayer p, float limbSwing, float limbSwingAmount,float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale);
	
	@Override
	public boolean shouldCombineTextures() {
		return false;
	}

}
