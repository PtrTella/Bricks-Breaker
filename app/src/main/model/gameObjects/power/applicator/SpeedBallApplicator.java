package main.model.gameObjects.power.applicator;

import main.common.V2d;
import main.model.World;

public final class SpeedBallApplicator implements PowerUpApplicator {

    private final static Double DELTA = 2.0;
    private boolean bonus;

    public SpeedBallApplicator(final boolean bonusToSet) {
        this.bonus = bonusToSet;
    }

    @Override
    public void applyPowerUp(final World gameWorld) {
        V2d acceleration = bonus ? new V2d(DELTA, DELTA) : new V2d(-DELTA, -DELTA);
        gameWorld.getBalls().stream().forEach(b -> b.setSpeed(b.getSpeed().sum(acceleration)));
    }
}
