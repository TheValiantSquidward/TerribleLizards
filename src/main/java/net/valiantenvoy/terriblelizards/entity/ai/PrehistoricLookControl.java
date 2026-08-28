package net.valiantenvoy.terriblelizards.entity.ai;

import net.minecraft.world.entity.ai.control.LookControl;
import net.valiantenvoy.terriblelizards.entity.PrehistoricMob;

public class PrehistoricLookControl extends LookControl {

    protected final PrehistoricMob mob;
    protected final boolean resetXRotOnTick;

    public PrehistoricLookControl(PrehistoricMob mob) {
        this(mob, true);
    }

    public PrehistoricLookControl(PrehistoricMob mob, boolean resetXRotOnTick) {
        super(mob);
        this.mob = mob;
        this.resetXRotOnTick = resetXRotOnTick;
    }


    @Override
    protected boolean resetXRotOnTick() {
            return resetXRotOnTick;
        }
    }