package com.lemby.silicon.init;

import com.lemby.silicon.Silicon;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SiliconBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Silicon.MODID);

    public static final RegistryObject<Block> GEM_PILLAR = BLOCKS.register("gem_pillar", () ->
                    new RotatedPillarBlock(Block.Properties
                            .create(Material.ROCK)
                            .hardnessAndResistance(5.0f, 6.0f)
                            .sound(SoundType.STONE)
                            .harvestLevel(1)
                            .harvestTool(ToolType.PICKAXE)
                    ) {
                    }
    );
    public static final RegistryObject<Block> GEM_INSIGNIA = BLOCKS.register("gem_insignia", () ->
            new Block(Block.Properties
                    .create(Material.ROCK)
                    .hardnessAndResistance(5.0f, 6.0f)
                    .sound(SoundType.STONE)
                    .harvestLevel(1)
                    .harvestTool(ToolType.PICKAXE)
            ) {
            }
    );
}