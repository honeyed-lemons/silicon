package com.lemby.silicon.init;

import com.gempire.items.ItemGem;
import com.gempire.util.ModItemGroup;
import com.lemby.silicon.Silicon;
import com.lemby.silicon.itemgroup.SiliconBlockGroup;
import com.lemby.silicon.itemgroup.SiliconGemGroup;
import com.lemby.silicon.itemgroup.SiliconItemGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SiliconItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Silicon.MODID);
    // ruin blocks
    public static final RegistryObject<Item> GEM_PILLAR = ITEMS.register("gem_pillar", () ->
            new BlockItem(
                    SiliconBlocks.GEM_PILLAR.get(),
                    new Item.Properties().group(SiliconBlockGroup.SILICON_BLOCK_GROUP)
            )
    );
    public static final RegistryObject<Item> GEM_INSIGNIA = ITEMS.register("gem_insignia", () ->
            new BlockItem(
                    SiliconBlocks.GEM_INSIGNIA.get(),
                    new Item.Properties().group(SiliconBlockGroup.SILICON_BLOCK_GROUP)
            )
    );
    public static final RegistryObject<Item> GEM_WALL_6 = ITEMS.register("gem_wall_6", () ->
            new BlockItem(
                    SiliconBlocks.GEM_WALL_6.get(),
                    new Item.Properties().group(SiliconGemGroup.SILICON_GEM_GROUP)
            )
    );
    public static final RegistryObject<Item> GEM_WALL_4 = ITEMS.register("gem_wall_4", () ->
            new BlockItem(
                    SiliconBlocks.GEM_WALL_4.get(),
                    new Item.Properties().group(SiliconGemGroup.SILICON_GEM_GROUP)
            )
    );
    public static final RegistryObject<Item> GEM_WALL_3 = ITEMS.register("gem_wall_3", () ->
            new BlockItem(
                    SiliconBlocks.GEM_WALL_3.get(),
                    new Item.Properties().group(SiliconGemGroup.SILICON_GEM_GROUP)
            )
    );
    public static final RegistryObject<Item> GEM_WALL_0 = ITEMS.register("gem_wall_0", () ->
            new BlockItem(
                    SiliconBlocks.GEM_WALL_0.get(),
                    new Item.Properties().group(SiliconGemGroup.SILICON_GEM_GROUP)
            )
    );
    public static final RegistryObject<Item> GEM_SLAB = ITEMS.register("gem_slab", () ->
            new BlockItem(
                    SiliconBlocks.GEM_SLAB.get(),
                    new Item.Properties().group(SiliconBlockGroup.SILICON_BLOCK_GROUP)
            )
    );
    public static final RegistryObject<Item> GEM_BLOCK = ITEMS.register("gem_block", () ->
            new BlockItem(
                    SiliconBlocks.GEM_BLOCK.get(),
                    new Item.Properties().group(SiliconBlockGroup.SILICON_BLOCK_GROUP)
            )
    );
    // crystal tree stuff
    //public static final RegistryObject<Item> CRYSTAL_LOG = ITEMS.register("crystal_log", () ->
            // BlockItem(
                    //SiliconBlocks.CRYSTAL_LOG.get(),
                    //new Item.Properties().group(SiliconBlockGroup.SILICON_BLOCK_GROUP)
            //)
    //);

    public static final RegistryObject<Item> CRYSTAL_APPLE = ITEMS.register("crystal_apple", () ->
            new Item(new Item.Properties().group(SiliconItemGroup.SILICON_ITEM_GROUP)
                    .food(new Food.Builder().hunger(8).saturation(0.8F).build()))
            );
    //gems

    public static final RegistryObject<Item> SUGAR_GEM = ITEMS.register("sugar_gem", () ->
            new ItemGem(new Item.Properties().group(SiliconGemGroup.SILICON_GEM_GROUP).maxStackSize(1).isImmuneToFire(), Silicon.MODID));
}