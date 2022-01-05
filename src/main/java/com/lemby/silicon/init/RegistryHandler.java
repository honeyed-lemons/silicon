package com.lemby.silicon.init;

import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class RegistryHandler {
    public static void init(){
        SiliconBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        SiliconItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        SiliconEntities.ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
