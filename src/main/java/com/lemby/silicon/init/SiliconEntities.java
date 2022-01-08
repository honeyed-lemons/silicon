package com.lemby.silicon.init;


import com.gempire.init.AddonHandler;
import com.gempire.init.ModEntities;
import com.gempire.systems.injection.GemFormation;
import com.lemby.silicon.Silicon;
import com.lemby.silicon.entities.gems.EntityAzurite;
import com.lemby.silicon.entities.gems.EntityCoal;
import com.lemby.silicon.entities.gems.EntitySugar;
import com.lemby.silicon.entities.projectiles.BubbleEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SiliconEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Silicon.MODID);

    public static final RegistryObject<EntityType<EntitySugar>> SUGAR = ENTITIES.register("sugar",
            () -> EntityType.Builder.create(EntitySugar::new, EntityClassification.CREATURE)
                    .size(.75f, 1.5f) // Hitbox Size
                    .build(new ResourceLocation(Silicon.MODID, "sugar").toString()));

    public static final RegistryObject<EntityType<EntityCoal>> COAL = ENTITIES.register("coal",
            () -> EntityType.Builder.create(EntityCoal::new, EntityClassification.CREATURE)
                    .size(.75f, 1.5f) // Hitbox Size
                    .build(new ResourceLocation(Silicon.MODID, "coal").toString()));

    public static final RegistryObject<EntityType<EntityAzurite>> AZURITE = ENTITIES.register("azurite",
            () -> EntityType.Builder.create(EntityAzurite::new, EntityClassification.CREATURE)
                    .size(.75f, 3f) // Hitbox Size
                    .build(new ResourceLocation(Silicon.MODID, "azurite").toString()));

    public static final RegistryObject<EntityType<BubbleEntity>> BUBBLE = ENTITIES.register("bubble", () -> {
        return EntityType.Builder.<BubbleEntity>create(BubbleEntity::new, EntityClassification.MISC)
                .size(0.25F, 0.25F)
                .setTrackingRange(64)
                .setUpdateInterval(10)
                .setCustomClientFactory((spawnEntity, world) -> new BubbleEntity(SiliconEntities.BUBBLE.get(), world))
                .setShouldReceiveVelocityUpdates(true)
                .build(new ResourceLocation(Silicon.MODID, "bubble").toString());
    });

    public static void registerEntitiesToGempire(){
//sugar
        ModEntities.CRUXTOGEM.put("sugar", SiliconCruxes.SUGAR_CONDITIONS());
        GemFormation.POSSIBLE_GEMS.add("sugar");
        AddonHandler.ENTITY_ADDON_ENTITY_REGISTRIES.put("sugar", SiliconEntities.class);
//coal
        ModEntities.CRUXTOGEM.put("coal", SiliconCruxes.AZURITE_CONDITIONS());
        GemFormation.POSSIBLE_GEMS.add("coal");
        AddonHandler.ENTITY_ADDON_ENTITY_REGISTRIES.put("coal", SiliconEntities.class);

        AddonHandler.ADDON_ENTITY_REGISTRIES.put("silicon", SiliconEntities.class);
    }
}
