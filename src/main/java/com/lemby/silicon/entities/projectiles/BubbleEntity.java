package com.lemby.silicon.entities.projectiles;

import com.lemby.silicon.Silicon;
import com.lemby.silicon.init.SiliconEntities;
import com.lemby.silicon.init.SiliconItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.IPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.NetworkHooks;

public class BubbleEntity extends ProjectileItemEntity {
    public BubbleEntity(EntityType<? extends BubbleEntity> entityType, World world) {
        super(entityType, world);
    }

    public BubbleEntity(World world, LivingEntity livingEntity) {
        super(SiliconEntities.BUBBLE.get(), livingEntity, world);
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    protected Item getDefaultItem() {
        return SiliconItems.BUBBLE.get();
    }

    protected void onEntityHit(EntityRayTraceResult rayTraceResult) {
        super.onEntityHit(rayTraceResult);
        Entity entity = rayTraceResult.getEntity();
        int i = entity instanceof LivingEntity ? 3 : 0;
        if (entity instanceof LivingEntity) {
            ((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.LEVITATION, 200));
            entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.func_234616_v_()), (float)i);
        }
    }

    /**
     * Called when this EntityFireball hits a block or entity.
     */
    protected void onImpact(RayTraceResult result) {
        super.onImpact(result);
        if (!this.world.isRemote) {
            this.world.setEntityState(this, (byte)3);
            this.remove();
        }

    }
}
