package net.valiantenvoy.terriblelizards.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.valiantenvoy.terriblelizards.entity.PrehistoricFlyingMob;
import net.valiantenvoy.terriblelizards.entity.ai.PrehistoricFlyingMoveControl;
import net.valiantenvoy.terriblelizards.entity.ai.PrehistoricMoveControl;
import net.valiantenvoy.terriblelizards.entity.ai.SmoothFlyingNavigation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

@SuppressWarnings("deprecation")
public class PteranodonEntity extends PrehistoricFlyingMob {

    public PteranodonEntity(EntityType<? extends PrehistoricFlyingMob> entityType, Level level) {
        super(entityType, level);
        this.setPathfindingMalus(PathType.LEAVES, 0.0F);
        this.switchNavigator(true);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 4.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.01F)
                .add(Attributes.FLYING_SPEED, 0.7F);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(3, new PteranodonEntityFlyGoal(this));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
    }

    @Override
    public void switchNavigator(boolean onLand) {
        if (onLand) {
            this.moveControl = new PrehistoricMoveControl(this);
            this.navigation = this.createNavigation(this.level());
            this.isLandNavigator = true;
        } else {
            this.moveControl = new PrehistoricFlyingMoveControl(this, 16);
            SmoothFlyingNavigation flyingPathNavigation = new SmoothFlyingNavigation(this, this.level()){
                @Override
                public boolean isStableDestination(BlockPos blockPos) {
                    return !level().getBlockState(blockPos.below()).isAir();
                }
            };
            flyingPathNavigation.setCanOpenDoors(false);
            flyingPathNavigation.setCanFloat(false);
            flyingPathNavigation.setCanPassDoors(true);
            this.navigation = flyingPathNavigation;
            this.isLandNavigator = false;
        }
    }

    @Override
    public float getWalkTargetValue(@NotNull BlockPos pos, @NotNull LevelReader level) {
        return level.getBlockState(pos).isAir() ? 10.0F : 0.0F;
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return false;
    }

    @Override
    public void travel(@NotNull Vec3 travelVec) {
        if (this.onGround()) {
            if (this.getNavigation().getPath() != null) {
                this.getNavigation().stop();
            }
            travelVec = travelVec.multiply(0.0, 1.0, 0.0);
        }
        super.travel(travelVec);
    }

    @Override
    protected void doPush(@NotNull Entity entity) {
    }

    @Override
    protected void pushEntities() {
    }

    @Override
    protected @NotNull MovementEmission getMovementEmission() {
        return MovementEmission.EVENTS;
    }

    @Override
    protected void doWaterSplashEffect() {
    }

    @Override
    public void setupAnimationStates() {
        this.idleAnimationState.animateWhen(!this.isFlying(), this.tickCount);
        this.flyAnimationState.animateWhen(
                this.isFlying() && !this.isRunning(),
                this.tickCount
        );
    }

    @Override
    protected void playStepSound(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
    }

    @Override
    protected float getSoundVolume() {
        return 0.5F;
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }


    private static class PteranodonEntityFlyGoal extends Goal {

        private final PteranodonEntity pterodactylus;
        private double x;
        private double y;
        private double z;

        public PteranodonEntityFlyGoal(PteranodonEntity pterodactylus) {
            this.setFlags(EnumSet.of(Flag.MOVE));
            this.pterodactylus = pterodactylus;
        }

        @Override
        public boolean canUse() {
            if (pterodactylus.isVehicle() || (pterodactylus.getTarget() != null && pterodactylus.getTarget().isAlive()) || pterodactylus.isPassenger()) {
                return false;
            }
            if (!pterodactylus.isFlying() && pterodactylus.getRandom().nextInt(70) != 0) {
                return false;
            }
            Vec3 target = this.getPosition();
            this.x = target.x;
            this.y = target.y;
            this.z = target.z;
            return true;
        }

        private Vec3 getPosition() {
            return this.findFlightPos();
        }

        @Override
        public void start() {
            this.pterodactylus.setFlying(true);
            this.pterodactylus.getNavigation().moveTo(this.x, this.y, this.z, 0.9F);
        }

        @Override
        public void tick() {
            if (pterodactylus.isFlying() && pterodactylus.onGround() && pterodactylus.flightTicks > 40) {
                this.pterodactylus.setFlying(false);
            }
        }

        @Override
        public boolean canContinueToUse() {
            {
                return pterodactylus.isFlying() && !pterodactylus.getNavigation().isDone();
            }
        }

        private Vec3 findFlightPos() {
            int range = 13;
            Vec3 heightAdjusted = pterodactylus.position().add(pterodactylus.getRandom().nextInt(range * 2) - range, 0, pterodactylus.getRandom().nextInt(range * 2) - range);
            if (pterodactylus.level().canSeeSky(BlockPos.containing(heightAdjusted))) {
                Vec3 ground = groundPosition(heightAdjusted);
                heightAdjusted = new Vec3(heightAdjusted.x, ground.y + 4 + pterodactylus.getRandom().nextInt(3), heightAdjusted.z);
            } else {
                Vec3 ground = groundPosition(heightAdjusted);
                BlockPos ceiling = BlockPos.containing(ground).above(2);
                while (ceiling.getY() < pterodactylus.level().getMaxBuildHeight() && !pterodactylus.level().getBlockState(ceiling).isSolid()) {
                    ceiling = ceiling.above();
                }
                float randCeilVal = 0.3F + pterodactylus.getRandom().nextFloat() * 0.5F;
                heightAdjusted = new Vec3(heightAdjusted.x, ground.y + (ceiling.getY() - ground.y) * randCeilVal, heightAdjusted.z);
            }

            BlockHitResult result = pterodactylus.level().clip(new ClipContext(pterodactylus.getEyePosition(), heightAdjusted, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, pterodactylus));
            if (result.getType() == HitResult.Type.MISS) {
                return heightAdjusted;
            } else {
                return result.getLocation();
            }
        }

        public Vec3 groundPosition(Vec3 airPosition) {
            BlockPos.MutableBlockPos ground = new BlockPos.MutableBlockPos();
            ground.set(airPosition.x, airPosition.y, airPosition.z);
            boolean flag = false;
            while (ground.getY() < pterodactylus.level().getMaxBuildHeight() && !pterodactylus.level().getBlockState(ground).isSolid() && pterodactylus.level().getFluidState(ground).isEmpty()){
                ground.move(0, 1, 0);
                flag = true;
            }
            ground.move(0, -1, 0);
            while (ground.getY() > pterodactylus.level().getMinBuildHeight() && !pterodactylus.level().getBlockState(ground).isSolid() && pterodactylus.level().getFluidState(ground).isEmpty()) {
                ground.move(0, -1, 0);
            }
            return Vec3.atCenterOf(flag ? ground.above() : ground.below());
        }


    }
}