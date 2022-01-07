package com.lemby.silicon.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * ModelCoal - Either Mojang or a mod author (Taken From Memory)
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class ModelCoal<T extends Entity> extends EntityModel<T> {
    public ModelRenderer gemHead;
    public ModelRenderer gemLeftArm;
    public ModelRenderer gemRightArm;
    public ModelRenderer gemLeftLeg;
    public ModelRenderer gemRightLeg;
    public ModelRenderer gemBody;
    public ModelRenderer gemCandyCane;
    public ModelRenderer gemBun;
    public ModelRenderer gemHeadwear;
    public ModelRenderer bipedBangsThingUwU;
    public ModelRenderer gemSkirt;

    public ModelCoal() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.gemCandyCane = new ModelRenderer(this, 0, 0);
        this.gemCandyCane.setRotationPoint(0.0F, -2.3F, 0.0F);
        this.gemCandyCane.addBox(-1.8F, -7.7F, 0.0F, 1.0F, 2.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(gemCandyCane, 0.0F, 0.27314403792396663F, -0.13665927909957545F);
        this.gemBody = new ModelRenderer(this, 8, 16);
        this.gemBody.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.gemBody.addBox(-3.0F, 0.0F, -2.0F, 6.0F, 12.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.gemHeadwear = new ModelRenderer(this, 32, 0);
        this.gemHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.gemHeadwear.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.4000001F, 0.39999962F, 0.4000001F);
        this.bipedBangsThingUwU = new ModelRenderer(this, 40, 16);
        this.bipedBangsThingUwU.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedBangsThingUwU.addBox(-6.0F, -10.1F, -4.4F, 12.0F, 10.0F, 0.0F, 0.6F, 0.5F, 0.0F);
        this.gemBun = new ModelRenderer(this, 0, 44);
        this.gemBun.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.gemBun.addBox(-6.5F, -3.2F, -2.0F, 13.0F, 4.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.gemLeftArm = new ModelRenderer(this, 0, 16);
        this.gemLeftArm.setRotationPoint(4.0F, 0.0F, 0.0F);
        this.gemLeftArm.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.gemLeftLeg = new ModelRenderer(this, 28, 16);
        this.gemLeftLeg.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.gemLeftLeg.addBox(-1.3F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.gemRightLeg = new ModelRenderer(this, 28, 30);
        this.gemRightLeg.setRotationPoint(-2.0F, 12.0F, 0.0F);
        this.gemRightLeg.addBox(-0.7F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.gemSkirt = new ModelRenderer(this, 34, 48);
        this.gemSkirt.setRotationPoint(0.0F, 8.7F, 0.0F);
        this.gemSkirt.addBox(-4.5F, 0.0F, -3.1F, 9.0F, 10.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.gemHead = new ModelRenderer(this, 0, 0);
        this.gemHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.gemHead.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.gemRightArm = new ModelRenderer(this, 0, 30);
        this.gemRightArm.setRotationPoint(-4.0F, 0.0F, 0.0F);
        this.gemRightArm.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.gemHead.addChild(this.gemCandyCane);
        this.gemHead.addChild(this.gemHeadwear);
        this.gemHead.addChild(this.bipedBangsThingUwU);
        this.gemHead.addChild(this.gemBun);
        this.gemBody.addChild(this.gemSkirt);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.gemBody, this.gemLeftArm, this.gemLeftLeg, this.gemRightLeg, this.gemHead, this.gemRightArm).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
