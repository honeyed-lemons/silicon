package com.lemby.silicon.entities.gems;

import com.gempire.entities.abilities.AbilityBrewEssence;
import com.gempire.entities.abilities.base.Ability;
import com.gempire.entities.abilities.interfaces.IAlchemyAbility;
import com.gempire.entities.abilities.interfaces.IIdleAbility;
import com.gempire.entities.ai.EntityAIFollowOwner;
import com.gempire.entities.ai.EntityAIWander;
import com.gempire.entities.bases.EntityGem;
import com.gempire.init.ModItems;
import com.gempire.util.Abilities;
import com.gempire.util.GemPlacements;
import com.lemby.silicon.Silicon;
import com.lemby.silicon.init.SiliconItems;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;

public class EntitySugar extends EntityGem {

    public EntitySugar(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {

        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 50.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.4D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 6.0D)
                .createMutableAttribute(Attributes.ATTACK_SPEED, 1.0D);
    }


    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(7, new SwimGoal(this));
        this.goalSelector.addGoal(6, new PanicGoal(this, 1.1D));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 4.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(7, new EntityAIWander(this, 1.0D));
        this.goalSelector.addGoal(7, new EntityAIFollowOwner(this, 1.0D));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, MobEntity.class, 1, false, false, (p_234199_0_) -> {
            return p_234199_0_ instanceof IMob;
        }));
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0D, 60, 10.0F));
        this.getAbilityPowers();
    }

    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        Vector3d vector3d = target.getMotion();
        double d0 = target.getPosX() + vector3d.x - this.getPosX();
        double d1 = target.getPosYEye() - (double) 1.1F - this.getPosY();
        double d2 = target.getPosZ() + vector3d.z - this.getPosZ();
        float f = MathHelper.sqrt(d0 * d0 + d2 * d2);
        Potion potion = Potions.HARMING;
        if (target instanceof AbstractSkeletonEntity) {
            potion = Potions.HEALING;
        }
        if (target instanceof ZombieEntity) {
            potion = Potions.HEALING;
        }
        if (target instanceof HuskEntity) {
            potion = Potions.HEALING;
        }
        this.setAttackTarget((LivingEntity) null);
        PotionEntity potionentity = new PotionEntity(this.world, this);
        potionentity.setItem(PotionUtils.addPotionToItemStack(new ItemStack(Items.SPLASH_POTION), potion));
        potionentity.rotationPitch -= -20.0F;
        potionentity.shoot(d0, d1 + (double) (f * 0.2F), d2, 0.75F, 8.0F);
        if (!this.isSilent()) {
            this.world.playSound((PlayerEntity) null, this.getPosX(), this.getPosY(), this.getPosZ(), SoundEvents.ENTITY_WITCH_THROW, this.getSoundCategory(), 1.0F, 0.8F + this.rand.nextFloat() * 0.4F);
        }

        this.world.addEntity(potionentity);
    }

    public String getModID() {
        return Silicon.MODID;
    }

    @Override
    public Class getItemRegister() {
        return SiliconItems.class;
    }

    @Override
    public int generateSkinVariant() {
        return 0;
    }


    public ActionResultType applyPlayerInteraction(PlayerEntity player, Vector3d vec, Hand hand) {
        if (player.world.isRemote) {
            return super.applyPlayerInteraction(player, vec, hand);
        }
            if (hand == Hand.MAIN_HAND) {
                this.currentPlayer = player;
                if (player.getHeldItemMainhand().getItem() == Items.APPLE) {
                    if (this.isOwner(player)) {
                        this.entityDropItem(SiliconItems.CRYSTAL_APPLE.get());
                            if (!player.abilities.isCreativeMode) {
                                player.getHeldItemMainhand().shrink(1);
                        }
                    }
                }
            }
        return super.applyPlayerInteraction(player, vec, hand);
        }

    @Override
    public GemPlacements[] getPlacements() {
        return new GemPlacements[]{
                GemPlacements.TOP_OF_HEAD,
                GemPlacements.BACK,
                GemPlacements.BACK_OF_HEAD,
                GemPlacements.CHEST,
                GemPlacements.BELLY,
                GemPlacements.LEFT_CHEEK,
                GemPlacements.RIGHT_CHEEK,
                GemPlacements.FOREHEAD,
                GemPlacements.LEFT_EYE,
                GemPlacements.RIGHT_EYE,
        };
    }


    @Override
    public int generateHairVariant() {
        return this.rand.nextInt(3);
    }

    @Override
    public int generateOutfitVariant() {
        return 0;
    }

    @Override
    public int generateInsigniaVariant() {
        return this.getOutfitVariant();
    }

    @Override
    public int generateSkinColorVariant() {
        return 0;
    }

    @Override
    public boolean hasSkinColorVariant() {
        return false;
    }

    @Override
    public boolean generateIsEmotional() {
        return false;
    }

    @Override
    public int generateInsigniaColor() {
        return 3;
    }

    @Override
    public int generateOutfitColor() {
        return 0;
    }

    @Override
    public byte EmotionThreshold() {
        return 0;
    }

    @Override
    public boolean canChangeUniformColorByDefault() {
        return false;
    }

    @Override
    public boolean canChangeInsigniaColorByDefault() {
        return false;
    }

    @Override
    public Abilities[] possibleAbilities() {
        return new Abilities[]{
                Abilities.NO_ABILITY
        };
    }

    @Override
    public Abilities[] definiteAbilities() {
        return new Abilities[]{
                Abilities.NO_ABILITY
        };
    }
    @Override
    public boolean canOpenInventoryByDefault() {
        return true;
    }
}
