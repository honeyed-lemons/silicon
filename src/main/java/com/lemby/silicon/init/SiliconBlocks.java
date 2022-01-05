package com.lemby.silicon.init;

import com.lemby.silicon.Silicon;
import com.lemby.silicon.blocks.GemInsigniaBlock;
import com.lemby.silicon.blocks.GemWallBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SiliconBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Silicon.MODID);
    // ruin blocks
    public static final RegistryObject<Block> GEM_PILLAR = BLOCKS.register("gem_pillar", () ->
                    new RotatedPillarBlock(Block.Properties
                            .create(Material.ROCK)
                            .hardnessAndResistance(1.5f, 0.8f)
                            .sound(SoundType.STONE)
                            .harvestLevel(1)
                            .harvestTool(ToolType.PICKAXE)
                            .setRequiresTool()
                    ) {
                    }
    );
    public static final RegistryObject<Block> GEM_INSIGNIA = BLOCKS.register("gem_insignia", () ->
            new GemInsigniaBlock(Block.Properties
                    .create(Material.ROCK)
                    .hardnessAndResistance(1.5f, 0.8f)
                    .sound(SoundType.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()
            ) {
            }
    );
    public static final RegistryObject<Block> GEM_WALL_4 = BLOCKS.register("gem_wall_4", () ->
            new GemWallBlock(Block.Properties
                    .create(Material.ROCK)
                    .hardnessAndResistance(1.5f, 0.8f)
                    .sound(SoundType.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()
                    .setLightLevel((state) -> {
                        return 15;
                    })));
    public static final RegistryObject<Block> GEM_WALL_6 = BLOCKS.register("gem_wall_6", () ->
            new GemWallBlock(Block.Properties
                    .create(Material.ROCK)
                    .hardnessAndResistance(1.5f, 0.8f)
                    .sound(SoundType.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()
                    .setLightLevel((state) -> {
                        return 15;
                    })));
    public static final RegistryObject<Block> GEM_WALL_3 = BLOCKS.register("gem_wall_3", () ->
            new GemWallBlock(Block.Properties
                    .create(Material.ROCK)
                    .hardnessAndResistance(1.5f, 0.8f)
                    .sound(SoundType.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()
                    .setLightLevel((state) -> {
                        return 15;
                    })));
    public static final RegistryObject<Block> GEM_WALL_0 = BLOCKS.register("gem_wall_0", () ->
            new GemWallBlock(Block.Properties
                    .create(Material.ROCK)
                    .hardnessAndResistance(1.5f, 0.8f)
                    .sound(SoundType.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()
                    .setLightLevel((state) -> {
                        return 15;
                    })));
    public static final RegistryObject<Block> GEM_SLAB = BLOCKS.register("gem_slab", () ->
            new SlabBlock(Block.Properties
                    .create(Material.ROCK)
                    .hardnessAndResistance(1.5f, 0.8f)
                    .sound(SoundType.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()
            ) {
            }
    );
    public static final RegistryObject<Block> GEM_BLOCK = BLOCKS.register("gem_block", () ->
            new Block(Block.Properties
                    .create(Material.ROCK)
                    .hardnessAndResistance(1.5f, 0.8f)
                    .sound(SoundType.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()
            ) {
            }
    );
    //crystal tree stuff
    //public static final RegistryObject<Block> CRYSTAL_LOG = BLOCKS.register("crystal_log", () ->
            //new RotatedPillarBlock(Block.Properties
                    //.create(Material.WOOD)
                    //.hardnessAndResistance(2.0F)
                    //.sound(SoundType.WOOD)
            //) {
            //}
    //);
}