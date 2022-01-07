package com.lemby.silicon.client.model;

import com.gempire.client.entity.model.ModelGem;
import com.gempire.entities.bases.EntityGem;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ModelSmallPearl<T extends EntityGem> extends ModelGem<T> {
    public ModelRenderer gemHeadwear;
    public ModelRenderer gemHead;
    public ModelRenderer gemBody;
    public ModelRenderer gemLeftArm;
    public ModelRenderer gemRightArm;
    public ModelRenderer gemLeftLeg;
    public ModelRenderer gemRightLeg;
    public ModelRenderer gemBun;
    public ModelRenderer gemCandyCane;
    public ModelRenderer gemSkirt;
    public ModelRenderer gemBangsThingUwU;

    public ModelSmallPearl() {
        this.textureWidth = 64;
        this.textureHeight = 64;

        this.gemSkirt = new ModelRenderer(this, 34, 48);
        this.gemSkirt.setRotationPoint(0.0F, 8.7F, 0.0F);
        this.gemSkirt.addBox(-4.5F, 0.0F, -3.1F, 9, 10, 6, 0.0F);

        this.gemBangsThingUwU = new ModelRenderer(this, 40, 16);
        this.gemBangsThingUwU.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.gemBangsThingUwU.addBox(-6.0F, -10.1F, -4.4F, 12.0F, 10.0F, 0.0F, 0.6F, 0.5F, 0.0F);

        this.gemLeftArm = new ModelRenderer(this, 0, 16);
        this.gemLeftArm.setRotationPoint(4.0F, 0.0F, 0.0F);
        this.gemLeftArm.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F);
        this.setRotateAngle(gemLeftArm, 0.0F, 0.0F, -0.05235987755982988F);

        this.gemRightArm = new ModelRenderer(this, 0, 30);
        this.gemRightArm.setRotationPoint(-4.0F, 0.0F, 0.0F);
        this.gemRightArm.addBox(-1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F);
        this.setRotateAngle(gemRightArm, 0.0F, 0.0F, 0.05235987755982988F);

        this.gemCandyCane = new ModelRenderer(this, 0, 0);
        this.gemCandyCane.setRotationPoint(0.0F, -2.3F, 0.0F);
        this.gemCandyCane.addBox(-1.8F, -7.7F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(gemCandyCane, 0.0F, 0.27314402793711257F, -0.136659280431156F);

        this.gemBody = new ModelRenderer(this, 8, 16);
        this.gemBody.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.gemBody.addBox(-3.0F, 0.0F, -2.0F, 6, 12, 4, 0.0F);

        this.gemHead = new ModelRenderer(this, 0, 0);
        this.gemHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.gemHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);

        this.gemRightLeg = new ModelRenderer(this, 28, 30);
        this.gemRightLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
        this.gemRightLeg.addBox(-0.7F, 0.0F, -1.0F, 2, 12, 2, 0.0F);

        this.gemLeftLeg = new ModelRenderer(this, 28, 16);
        this.gemLeftLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.gemLeftLeg.addBox(-1.3F, 0.0F, -1.0F, 2, 12, 2, 0.0F);

        this.gemBun = new ModelRenderer(this, 0, 44);
        this.gemBun.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.gemBun.addBox(-6.5F, -3.2F, -2.0F, 13, 4, 4, 0.0F);

        this.gemHeadwear = new ModelRenderer(this, 32, 0);
        this.gemHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.gemHeadwear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.4F);

        this.gemBody.addChild(this.gemSkirt);
        this.gemHead.addChild(this.gemCandyCane);
        this.gemHead.addChild(this.gemBun);
        this.gemHead.addChild(this.gemHeadwear);
        this.gemHead.addChild(this.gemBangsThingUwU);
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
        this.setRotateAngle(this.gemLeftArm, MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * 1.5F * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.gemRightArm, MathHelper.cos(limbSwing * 0.5F) * 1.5F * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.gemLeftLeg, MathHelper.cos(limbSwing * 0.5F) * 1.5F * limbSwingAmount * 0.8f, 0, 0);
        this.setRotateAngle(this.gemRightLeg, MathHelper.cos(limbSwing * 0.5F + (float)Math.PI) * 1.5F * limbSwingAmount * 0.8f, 0, 0);
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