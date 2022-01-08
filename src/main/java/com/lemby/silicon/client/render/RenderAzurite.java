package com.lemby.silicon.client.render;

import com.gempire.client.entity.render.layers.*;
import com.lemby.silicon.Silicon;
import com.lemby.silicon.client.model.ModelAzurite;
import com.lemby.silicon.client.model.ModelSmallPearl;
import com.lemby.silicon.entities.gems.EntityAzurite;
import com.lemby.silicon.entities.gems.EntityCoal;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class RenderAzurite extends MobRenderer<EntityAzurite, ModelAzurite<EntityAzurite>> {

    public RenderAzurite(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelAzurite<>(), .25f);
        this.addLayer(new SkinLayer(this));
        this.addLayer(new FaceLayer(this));
        this.addLayer(new HairLayer(this));
        this.addLayer(new OutfitLayer(this));
        this.addLayer(new InsigniaLayer(this));
        this.addLayer(new GemPlacementLayer(this));
    }

    @Override
    protected void preRenderCallback(EntityAzurite entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        super.preRenderCallback(entitylivingbaseIn, matrixStackIn, partialTickTime);
    }
    @Override
    public ResourceLocation getEntityTexture(EntityAzurite entity) {
        return new ResourceLocation(Silicon.MODID+":textures/entity/azurite/blank.png");
    }
    @Override
    protected void renderName(EntityAzurite entityIn, ITextComponent displayNameIn, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.renderName(entityIn, displayNameIn, matrixStackIn, bufferIn, packedLightIn);
    }
}