package net.valiantenvoy.terriblelizards.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.valiantenvoy.terriblelizards.entity.FlyingMob;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class NyctoEntity extends FlyingMob {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public NyctoEntity(EntityType<? extends FlyingMob> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new NyctoFlyGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {

        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 10d)
                .add(Attributes.MOVEMENT_SPEED, 0.25d)
                .add(Attributes.FLYING_SPEED, 0.25d)
                .add(Attributes.FOLLOW_RANGE, 24d);
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return false;
    }

    private void setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 0;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }


    private static class NyctoFlyGoal extends Goal {

        private final NyctoEntity nyctosaurus;
        private double x;
        private double y;
        private double z;

        public NyctoFlyGoal(NyctoEntity nyctosaurus) {
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
            this.nyctosaurus = nyctosaurus;
        }

        @Override
        public boolean canUse() {
            if (nyctosaurus.isVehicle() || (nyctosaurus.getTarget() != null && nyctosaurus.getTarget().isAlive()) || nyctosaurus.isPassenger()) {
                return false;
            }
            if (!nyctosaurus.isFlying() && nyctosaurus.getRandom().nextInt(70) != 0) {
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
            this.nyctosaurus.setFlying(true);
            this.nyctosaurus.getNavigation().moveTo(this.x, this.y, this.z, 0.9F);
        }

        @Override
        public void tick() {
            if (nyctosaurus.isFlying() && nyctosaurus.onGround() && nyctosaurus.flightTicks > 40) {
                this.nyctosaurus.setFlying(false);
            }
        }

        @Override
        public boolean canContinueToUse()
        {
                return nyctosaurus.isFlying() && !nyctosaurus.getNavigation().isDone();
        }

        @Override
        public void stop() {
                this.nyctosaurus.getNavigation().stop();
        }

        private Vec3 findFlightPos() {
            int range = 13;
            Vec3 heightAdjusted = nyctosaurus.position().add(nyctosaurus.getRandom().nextInt(range * 2) - range, 0, nyctosaurus.getRandom().nextInt(range * 2) - range);
            if (nyctosaurus.level().canSeeSky(BlockPos.containing(heightAdjusted))) {
                Vec3 ground = groundPosition(heightAdjusted);
                heightAdjusted = new Vec3(heightAdjusted.x, ground.y + 4 + nyctosaurus.getRandom().nextInt(3), heightAdjusted.z);
            } else {
                Vec3 ground = groundPosition(heightAdjusted);
                BlockPos ceiling = BlockPos.containing(ground).above(2);
                while (ceiling.getY() < nyctosaurus.level().getMaxBuildHeight() && !nyctosaurus.level().getBlockState(ceiling).isSolid()) {
                    ceiling = ceiling.above();
                }
                float randCeilVal = 0.3F + nyctosaurus.getRandom().nextFloat() * 0.5F;
                heightAdjusted = new Vec3(heightAdjusted.x, ground.y + (ceiling.getY() - ground.y) * randCeilVal, heightAdjusted.z);
            }

            var result = nyctosaurus.level().clip(new ClipContext(nyctosaurus.getEyePosition(), heightAdjusted, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, nyctosaurus));
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
            while (ground.getY() < nyctosaurus.level().getMaxBuildHeight() && !nyctosaurus.level().getBlockState(ground).isSolid() && nyctosaurus.level().getFluidState(ground).isEmpty()){
                ground.move(0, 1, 0);
                flag = true;
            }
            ground.move(0, -1, 0);
            while (ground.getY() > nyctosaurus.level().getMinBuildHeight() && !nyctosaurus.level().getBlockState(ground).isSolid() && nyctosaurus.level().getFluidState(ground).isEmpty()) {
                ground.move(0, -1, 0);
            }
            return Vec3.atCenterOf(flag ? ground.above() : ground.below());
        }


    }
    
}
