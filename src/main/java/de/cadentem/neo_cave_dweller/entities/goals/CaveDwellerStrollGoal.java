package de.cadentem.neo_cave_dweller.entities.goals;

import de.cadentem.neo_cave_dweller.config.ServerConfig;
import de.cadentem.neo_cave_dweller.entities.CaveDwellerEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;

public class CaveDwellerStrollGoal extends WaterAvoidingRandomStrollGoal {
    public CaveDwellerStrollGoal(final CaveDwellerEntity mob, double speedModifier) {
        super(mob, speedModifier);
    }

    @Override
    public void start() {
        ((CaveDwellerEntity)this.mob).setAttribute(this.mob.getAttribute(Attributes.MOVEMENT_SPEED), ServerConfig.MOVEMENT_SPEED.get() * this.speedModifier);
        super.start();
    }

    @Override
    public void stop() {
        ((CaveDwellerEntity)this.mob).setAttribute(this.mob.getAttribute(Attributes.MOVEMENT_SPEED), ServerConfig.MOVEMENT_SPEED.get());
        super.stop();
    }

    @Override
    public boolean canUse() {
        return ((CaveDwellerEntity) mob).currentRoll == Roll.STROLL && super.canUse();
    }

    @Override
    public boolean canContinueToUse() {
        return ((CaveDwellerEntity) mob).currentRoll == Roll.STROLL && super.canContinueToUse();
    }
}
