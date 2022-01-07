package com.lemby.silicon.entities.gems;

import com.gempire.entities.ai.EntityAIFollowOwner;
import com.gempire.entities.ai.EntityAIWander;
import com.gempire.entities.bases.EntityGem;
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
import net.minecraft.entity.monster.AbstractSkeletonEntity;
import net.minecraft.entity.monster.HuskEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class EntityCoal extends EntityGem {

    public EntityCoal(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {

        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 30.0D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.4D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 2.0D)
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
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.1D, false));        this.getAbilityPowers();
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
            if (player.getHeldItemMainhand().getItem() == Items.COAL) {
                if (this.isOwner(player)) {
                    this.entityDropItem(SiliconItems.COAL_TORCH.get());
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
        if (this.getGemPlacement() == 1) {
            return 1;
        } else if (this.getGemPlacement() == 2) {
            return 0;
        } else {
            return this.rand.nextInt(2);
        }
    }

    public int generateOutfitVariant(){
        if (this.getGemPlacement() == 17) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int generateInsigniaVariant() {
        return 0;
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
        return true;
    }

    @Override
    public int generateInsigniaColor() {
        return 0;
    }

    @Override
    public int generateOutfitColor() {
        return 10;
    }

    @Override
    public byte EmotionThreshold() {
        return 15;
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
                Abilities.PYROKINESIS,
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
        return false;
    }
}
