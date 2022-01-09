package com.lemby.silicon.entities.gems;

import com.gempire.entities.ai.EntityAIFollowOwner;
import com.gempire.entities.ai.EntityAIWander;
import com.gempire.entities.bases.EntityGem;
import com.gempire.util.Abilities;
import com.gempire.util.GemPlacements;
import com.lemby.silicon.Silicon;
import com.lemby.silicon.entities.projectiles.BubbleEntity;
import com.lemby.silicon.init.SiliconItems;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityAzurite extends EntityGem implements IRangedAttackMob{

    public EntityAzurite(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {

        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 60.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 100.0D)
                .createMutableAttribute(Attributes.ATTACK_SPEED, 1.0D);
    }

    public EntityAzurite holder;

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(6, new PanicGoal(this, 1.1D));
        this.goalSelector.addGoal(7, new LookAtGoal(this, PlayerEntity.class, 4.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(7, new EntityAIWander(this, 1.0D));
        this.goalSelector.addGoal(7, new EntityAIFollowOwner(this, 1.0D));
        this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25D, 20, 10.0F));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, MobEntity.class, 10, true, false, (p_213621_0_) -> {
            return p_213621_0_ instanceof IMob;
        }));
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

    @Override
    public GemPlacements[] getPlacements() {
        return new GemPlacements[]{
                GemPlacements.FOREHEAD,
                GemPlacements.LEFT_EYE,
                GemPlacements.RIGHT_EYE,
                GemPlacements.LEFT_EAR,
                GemPlacements.RIGHT_EAR,
                GemPlacements.NOSE,
                GemPlacements.LEFT_CHEEK,
                GemPlacements.RIGHT_CHEEK,
                GemPlacements.MOUTH,
                GemPlacements.LEFT_SHOULDER,
                GemPlacements.RIGHT_SHOULDER,
                GemPlacements.CHEST,
                GemPlacements.BACK,
                GemPlacements.BELLY,
                GemPlacements.BACK_OF_HEAD

        };
    }

    public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
        BubbleEntity bubblyentity = new BubbleEntity(this.world, this);
        double d0 = target.getPosYEye() - (double)1.1F;
        double d1 = target.getPosX() - this.getPosX();
        double d2 = d0 - bubblyentity.getPosY();
        double d3 = target.getPosZ() - this.getPosZ();
        float f = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;
        bubblyentity.shoot(d1, d2 + (double)f, d3, 1.6F, 12.0F);
        this.playSound(SoundEvents.ENTITY_SNOW_GOLEM_SHOOT, 1.0F, 0.4F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.world.addEntity(bubblyentity);
    }

    @Override
    public int generateHairVariant() {
        return this.rand.nextInt(2);
        }

    @Override
    public int generateOutfitVariant(){
        return 0;
    }

    @Override
    public int generateInsigniaVariant() {
        return this.rand.nextInt(2);
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
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public boolean generateIsEmotional() {
        return false;
    }

    @Override
    public int generateInsigniaColor() {
        return 11;
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
        return true;
    }

    @Override
    public boolean canChangeInsigniaColorByDefault() {
        return true;
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
                Abilities.AMPHIBIAN
        };
    }
    @Override
    public boolean canOpenInventoryByDefault() {
        return false;
    }
}
