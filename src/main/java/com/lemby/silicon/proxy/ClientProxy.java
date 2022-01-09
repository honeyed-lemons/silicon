package com.lemby.silicon.proxy;

import com.lemby.silicon.Silicon;
import com.lemby.silicon.client.render.RenderAzurite;
import com.lemby.silicon.client.render.RenderCoal;
import com.lemby.silicon.client.render.RenderSugar;
import com.lemby.silicon.init.SiliconBlocks;
import com.lemby.silicon.init.SiliconEntities;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Silicon.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientProxy {
    @SubscribeEvent
    public static void doClientStuff(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(SiliconEntities.BUBBLE.get(), new Silicon.RenderBubbleFactory());
        RenderingRegistry.registerEntityRenderingHandler(SiliconEntities.SUGAR.get(), RenderSugar::new);
        RenderingRegistry.registerEntityRenderingHandler(SiliconEntities.AZURITE.get(), RenderAzurite::new);
        RenderingRegistry.registerEntityRenderingHandler(SiliconEntities.COAL.get(), RenderCoal::new);

        RenderTypeLookup.setRenderLayer(SiliconBlocks.COAL_TORCH.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(SiliconBlocks.WALL_COAL_TORCH.get(),RenderType.getCutout());
    }
}
