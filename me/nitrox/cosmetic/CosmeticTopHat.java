package me.nitrox.cosmetic;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class CosmeticTopHat extends CosmeticBase {

	private final ModelTopHat mth;
	private static final ResourceLocation TEXTURE = new ResourceLocation("NitroxClient/hat.png");
	
	public CosmeticTopHat(RenderPlayer p) {
		super(p);
		mth = new ModelTopHat(p);
	}
	
	@Override
	public void render(AbstractClientPlayer p, float limbSwing, float limbSwingAmount, float partialTicks,
			float ageInTicks, float headYaw, float headPitch, float scale) {
		if(CosmeticsController.shouldRenderTopHat(p)) {
		
			GlStateManager.pushMatrix();
			playerRenderer.bindTexture(TEXTURE);
			if(p.isSneaking()) {
				GL11.glTranslated(0, 0.225D,  0);
			}
			float[] color = CosmeticsController.getTopHatColor(p);
			GL11.glColor3f(color[0], color[1], color[2]);
			mth.render(p, limbSwing, limbSwingAmount, ageInTicks, headYaw, headPitch, scale);
			GL11.glColor3f(1,1,1);
			GL11.glPopMatrix();
		
		}

	}

	private class ModelTopHat extends CosmeticModelBase {

		private ModelRenderer rim;
		private ModelRenderer pointy;
		
		public ModelTopHat(RenderPlayer p) {
			super(p);
			rim = new ModelRenderer(playerModel,0,0);
			rim.addBox(-5.5F, -9F, -5.5F, 11, 2, 11);
			pointy = new ModelRenderer(playerModel,0,13);
			pointy.addBox(-3.5F, -17F, -3.5F, 7, 8, 7);
		}
		
		public void render(Entity entiy, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch, float scale) {
			rim.rotateAngleX = playerModel.bipedHead.rotateAngleX;
			rim.rotateAngleY = playerModel.bipedHead.rotateAngleY;
			rim.rotationPointX = 0.0F;
			rim.rotationPointY = 0.0F;
			rim.render(scale);
			
			pointy.rotateAngleX = playerModel.bipedHead.rotateAngleX;
			pointy.rotateAngleY = playerModel.bipedHead.rotateAngleY;
			pointy.rotationPointX = 0.0F;
			pointy.rotationPointY = 0.0F;
			pointy.render(scale);
		}

	}

}
