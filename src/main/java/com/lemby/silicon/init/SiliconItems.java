package com.lemby.silicon.init;

import com.gempire.util.ModItemGroup;
import com.lemby.silicon.Silicon;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SiliconItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Silicon.MODID);

    public static final RegistryObject<Item> GEM_PILLAR = ITEMS.register("gem_pillar", () ->
            new BlockItem(
                    SiliconBlocks.GEM_PILLAR.get(),
                    new Item.Properties().group(ModItemGroup.BLOCKS)
            )
    );
    public static final RegistryObject<Item> GEM_INSIGNIA = ITEMS.register("gem_insignia", () ->
            new BlockItem(
                    SiliconBlocks.GEM_INSIGNIA.get(),
                    new Item.Properties().group(ModItemGroup.BLOCKS)
            )
    );
}