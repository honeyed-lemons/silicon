package com.lemby.silicon.client.render;

import com.gempire.client.entity.render.layers.*;
import com.lemby.silicon.Silicon;
import com.lemby.silicon.client.model.ModelSugar;
import com.lemby.silicon.entities.gems.EntitySugar;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class RenderSugar extends MobRenderer<EntitySugar, ModelSugar<EntitySugar>> {

    public RenderSugar(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelSugar<>(), .25f);
        this.addLayer(new SkinLayer(this));
        this.addLayer(new FaceLayer(this));
        this.addLayer(new HairLayer(this));
        this.addLayer(new OutfitLayer(this));
        this.addLayer(new InsigniaLayer(this));
        this.addLayer(new GemPlacementLayer(this));
    }

    @Override
    protected void preRenderCallback(EntitySugar entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(.8f, .8f, .8f);
        super.preRenderCallback(entitylivingbaseIn, matrixStackIn, partialTickTime);
    }
    @Override
    public ResourceLocation getEntityTexture(EntitySugar entity) {
        return new ResourceLocation(Silicon.MODID+":textures/entity/sugar/blank.png");
    }
    @Override
    protected void renderName(EntitySugar entityIn, ITextComponent displayNameIn, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.renderName(entityIn, displayNameIn, matrixStackIn, bufferIn, packedLightIn);
    }
}