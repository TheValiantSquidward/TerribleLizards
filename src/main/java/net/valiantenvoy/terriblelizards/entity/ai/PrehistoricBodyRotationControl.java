package net.valiantenvoy.terriblelizards.entity.ai;

import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.valiantenvoy.terriblelizards.entity.PrehistoricMob;

public class PrehistoricBodyRotationControl extends BodyRotationControl {

    protected final PrehistoricMob mob;

    public PrehistoricBodyRotationControl(PrehistoricMob mob) {
        super(mob);
        this.mob = mob;
    }

    @Override
    public void clientTick() {
        super.clientTick();
    }
}