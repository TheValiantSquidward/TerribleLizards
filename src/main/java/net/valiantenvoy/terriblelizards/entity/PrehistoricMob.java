package net.valiantenvoy.terriblelizards.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.valiantenvoy.terriblelizards.entity.ai.PrehistoricBodyRotationControl;
import net.valiantenvoy.terriblelizards.entity.ai.PrehistoricLookControl;
import net.valiantenvoy.terriblelizards.entity.ai.PrehistoricMoveControl;
import net.valiantenvoy.terriblelizards.entity.ai.SmoothGroundNavigation;
import net.valiantenvoy.terriblelizards.entity.client.SmoothAnimationState;
import org.jetbrains.annotations.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.CommonHooks;

public abstract class PrehistoricMob extends Animal {

    protected static final EntityDataAccessor<Integer> ATTACK_STATE = SynchedEntityData.defineId(PrehistoricMob.class, EntityDataSerializers.INT);
    protected static final EntityDataAccessor<Integer> IDLE_STATE = SynchedEntityData.defineId(PrehistoricMob.class, EntityDataSerializers.INT);

    protected static final EntityDataAccessor<Boolean> RUNNING = SynchedEntityData.defineId(PrehistoricMob.class, EntityDataSerializers.BOOLEAN);

    protected int eepyTicks;

    protected float bodyYaw;
    protected float prevBodyYaw;
    protected float tailYaw;
    protected float prevTailYaw;

    public final SmoothAnimationState idleAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState swimAnimationState = new SmoothAnimationState();
    public final SmoothAnimationState eepyAnimationState = new SmoothAnimationState(0.25F);
    public final SmoothAnimationState sitAnimationState = new SmoothAnimationState(0.25F);
    public final SmoothAnimationState eatAnimationState = new SmoothAnimationState(1.0F);

    protected int idleAnimationCooldown;


    protected PrehistoricMob(EntityType<? extends PrehistoricMob> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new PrehistoricMoveControl(this);
        this.lookControl = new PrehistoricLookControl(this);
        this.setPersistenceRequired();
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(ATTACK_STATE, 0);
        builder.define(IDLE_STATE, 0);
        builder.define(RUNNING, false);
    }

    // Idle and attack states
    public int getAttackState() {
        return this.entityData.get(ATTACK_STATE);
    }
    public void setAttackState(int attackState) {
        this.entityData.set(ATTACK_STATE, attackState);
    }

    public int getIdleState() {
        return this.entityData.get(IDLE_STATE);
    }
    public void setIdleState(int idleState) {
        this.entityData.set(IDLE_STATE, idleState);
    }

    // Running
    public boolean isRunning() {
        return this.entityData.get(RUNNING);
    }
    public void setRunning(boolean running) {
        this.entityData.set(RUNNING, running);
    }

    // region navigation
    @Override
    protected BodyRotationControl createBodyControl() {
        return new PrehistoricBodyRotationControl(this);
    }

    @Override
    protected PathNavigation createNavigation(Level level) {
        return new SmoothGroundNavigation(this, level);
    }

    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader level) {
        return 0.0F;
    }

    // Floating
    @Override
    public double getFluidJumpThreshold() {
        if (this.isInWater() && this.horizontalCollision) {
            return super.getFluidJumpThreshold();
        }
        return 0.6D * this.getBbHeight();
    }

    // region animations
    public void setupAnimationStates() {
    }

    @Override
    public void calculateEntityAnimation(boolean flying) {
        float pos = (float) Mth.length(this.getX() - this.xo, this.getY() - this.yo, this.getZ() - this.zo);
        float speed = Math.min(pos * this.getWalkAnimationSpeed(), 1.0F);
        this.walkAnimation.update(speed, 0.4F);
    }

    public float getWalkAnimationSpeed() {
        return this.isBaby() ? 5.0F : 10.0F;
    }

    public void setIdleAnimationCooldown(int animationCooldown) {
        this.idleAnimationCooldown = animationCooldown;
    }

    public int getIdleAnimationCooldown() {
        return this.idleAnimationCooldown;
    }

    public int getIdleAnimationCooldown(int idleState) {
        return 0;
    }
    // endregion



    // Persistence
    @Override
    public boolean requiresCustomPersistence() {
        return true;
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return !this.requiresCustomPersistence();
    }


    // Tail
    public void tickTailYaw(float maxYaw, float yawMultiplier) {
        this.prevBodyYaw = this.bodyYaw;
        this.bodyYaw += Mth.clamp(Mth.wrapDegrees(this.yBodyRot - this.bodyYaw) * yawMultiplier, -maxYaw, maxYaw);

        this.prevTailYaw = this.tailYaw;
        this.tailYaw = Mth.clamp(Mth.wrapDegrees(this.bodyYaw - this.yBodyRot), -maxYaw, maxYaw);
    }

    public float getTailYaw(float partialTicks) {
        if (this.isPassenger()) {
            return 0.0F;
        }
        return Mth.lerp(partialTicks, this.prevTailYaw, this.tailYaw);
    }

}
