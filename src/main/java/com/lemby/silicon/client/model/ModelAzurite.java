package com.lemby.silicon.client.model;

import com.gempire.client.entity.model.ModelGem;
import com.gempire.entities.bases.EntityGem;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ModelAzurite<T extends EntityGem> extends ModelGem<T> {
    public ModelRenderer gemHead;
    public ModelRenderer gemNeck;
    public ModelRenderer gemHeadwear;
    public ModelRenderer gemBody;
    public ModelRenderer gemKimono1;
    public ModelRenderer gemKimono2;
    public ModelRenderer gemLeftArm;
    public ModelRenderer gemRightArm;
    public ModelRenderer gemLeftLeg;
    public ModelRenderer gemRightLeg;
    public ModelRenderer gemAhoge;
    public ModelRenderer gemBangs;

    public ModelAzurite() {
        this.textureWidth = 64;
        this.textureHeight = 76;

        this.gemLeftArm = new ModelRenderer(this, 0, 0);
        this.gemLeftArm.setRotationPoint(4.0F, -12.8F, 0.0F);
        this.gemLeftArm.setTextureOffset(32, 37).addBox(-0.5F, -0.1F, -1.5F, 3.0F, 17.0F, 3.0F, -0.1F, -0.1F, -0.1F);
        this.setRotateAngle(gemLeftArm, 0.0F, 0.0F, -0.07853981633974483F);

        this.gemBangs = new ModelRenderer(this, 0, 0);
        this.gemBangs.setRotationPoint(0.0F, -5.0F, -2.0F);
        this.gemBangs.setTextureOffset(0, 69).addBox(-4.0F, 11.5F, -3.0F, 8.0F, 4.0F, 3.0F, -0.6F, -0.5F, -0.5F);

        this.gemKimono1 = new ModelRenderer(this, 0, 0);
        this.gemKimono1.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.gemKimono1.setTextureOffset(36, 65).addBox(-3.5F, 4.5F, -3.5F, 7.0F, 4.0F, 7.0F, -0.1F, -0.1F, -0.1F);

        this.gemRightLeg = new ModelRenderer(this, 0, 0);
        this.gemRightLeg.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.gemRightLeg.setTextureOffset(32, 57).addBox(-3.0F, 6.0F, -1.5F, 2.0F, 8.0F, 2.0F, 0.2F, 0.0F, 0.2F);

        this.gemHead = new ModelRenderer(this, 0, 0);
        this.gemHead.setRotationPoint(0.0F, -13.5F, 0.0F);
        this.gemHead.addBox(-4.0F, -8.5F, -4.0F, 8.0F, 9.0F, 8.0F, -0.5F, -0.7F, -0.5F);

        this.gemKimono2 = new ModelRenderer(this, 0, 0);
        this.gemKimono2.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.gemKimono2.setTextureOffset(0, 34).addBox(-4.0F, 7.0F, -4.0F, 8.0F, 26.0F, 8.0F, 0.0F, 0.0F, 0.0F);

        this.gemBody = new ModelRenderer(this, 0, 0);
        this.gemBody.setRotationPoint(0.0F, -8.5F, 0.0F);
        this.gemBody.setTextureOffset(32, 2).addBox(-4.0F, -4.5F, -4.0F, 8.0F, 6.0F, 8.0F, -0.2F, -0.2F, -0.2F);

        this.gemLeftLeg = new ModelRenderer(this, 0, 0);
        this.gemLeftLeg.mirror = true;
        this.gemLeftLeg.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.gemLeftLeg.setTextureOffset(32, 57).addBox(1.0F, 6.0F, -1.5F, 2.0F, 8.0F, 2.0F, 0.2F, 0.0F, 0.2F);

        this.gemNeck = new ModelRenderer(this, 0, 0);
        this.gemNeck.setRotationPoint(0.0F, -13.0F, 0.0F);
        this.gemNeck.setTextureOffset(33, 21).addBox(-1.5F, 7.0F, -1.5F, 3.0F, 2.0F, 3.0F, -0.1F, -0.3F, -0.1F);

        this.gemRightArm = new ModelRenderer(this, 0, 0);
        this.gemRightArm.setRotationPoint(-4.0F, -12.8F, 0.0F);
        this.gemRightArm.setTextureOffset(44, 37).addBox(-2.5F, -0.1F, -1.5F, 3.0F, 17.0F, 3.0F, -0.1F, -0.1F, -0.1F);
        this.setRotateAngle(gemRightArm, 0.0F, 0.0F, 0.07853981633974483F);

        this.gemAhoge = new ModelRenderer(this, 0, 0);
        this.gemAhoge.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.gemAhoge.setTextureOffset(5, 24).addBox(-1.5F, 3.8F, 0.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F);

        this.gemHeadwear = new ModelRenderer(this, 0, 0);
        this.gemHeadwear.setRotationPoint(0.0F, -13.5F, 0.0F);
        this.gemHeadwear.setTextureOffset(0, 17).addBox(-6.0F, 6F, -4.0F, 12.0F, 8.0F, 9.0F, -0.6F, -0.5F, -0.5F);

        this.gemHead.addChild(this.gemHeadwear);
        this.gemHeadwear.addChild(this.gemBangs);
        this.gemHeadwear.addChild(this.gemAhoge);
        this.gemBody.addChild(this.gemNeck);
        this.gemBody.addChild(this.gemKimono1);
        this.gemBody.addChild(this.gemKimono2);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        ImmutableList.of(this.gemLeftArm, this.gemLeftLeg, this.gemRightLeg, this.gemBody, this.gemRightArm, this.gemHead).forEach((modelRenderer) -> {
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.setRotateAngle(this.gemHead, headPitch * 0.9f * ((float)Math.PI / 180F), netHeadYaw * ((float)Math.PI / 180F), 0);
        this.setRotateAngle(this.gemLeftArm, MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * 1.5F * limbSwingAmount * 0.5f, 0, 0);
        this.setRotateAngle(this.gemRightArm, MathHelper.cos(limbSwing * 0.5F) * 1.5F * limbSwingAmount * 0.5f, 0, 0);
        this.setRotateAngle(this.gemLeftLeg, MathHelper.cos(limbSwing * 2.0F) * 0.8F * limbSwingAmount * 0.25f, 0, 0);
        this.setRotateAngle(this.gemRightLeg, MathHelper.cos(limbSwing * 2.0F + (float)Math.PI) * 0.8F * limbSwingAmount * 0.25f, 0, 0);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}