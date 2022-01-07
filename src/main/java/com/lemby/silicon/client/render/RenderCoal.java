package com.lemby.silicon.client.render;

import com.gempire.client.entity.render.layers.*;
import com.lemby.silicon.Silicon;
import com.lemby.silicon.client.model.ModelSmallPearl;
import com.lemby.silicon.entities.gems.EntityCoal;
import com.lemby.silicon.entities.gems.EntitySugar;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class RenderCoal extends MobRenderer<EntityCoal, ModelSmallPearl<EntityCoal>> {

    public RenderCoal(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelSmallPearl<>(), .25f);
        this.addLayer(new SkinLayer(this));
        this.addLayer(new FaceLayer(this));
        this.addLayer(new HairLayer(this));
        this.addLayer(new OutfitLayer(this));
        this.addLayer(new InsigniaLayer(this));
        this.addLayer(new GemPlacementLayer(this));
    }

    @Override
    protected void preRenderCallback(EntityCoal entitylivingbaseIn, MatrixStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(.8f, .8f, .8f);
        super.preRenderCallback(entitylivingbaseIn, matrixStackIn, partialTickTime);
    }
    @Override
    public ResourceLocation getEntityTexture(EntityCoal entity) {
        return new ResourceLocation(Silicon.MODID+":textures/entity/coal/blank.png");
    }
    @Override
    protected void renderName(EntityCoal entityIn, ITextComponent displayNameIn, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        super.renderName(entityIn, displayNameIn, matrixStackIn, bufferIn, packedLightIn);
    }
}