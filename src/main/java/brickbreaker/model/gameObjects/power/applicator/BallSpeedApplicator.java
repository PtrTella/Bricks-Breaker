package brickbreaker.model.gameObjects.power.applicator;

import brickbreaker.common.V2d;
import brickbreaker.model.World;

public final class BallSpeedApplicator implements PowerUpApplicator {

    private final static Double DELTA = 2.0;
    private boolean bonus;

    public BallSpeedApplicator(final boolean bonusToSet) {
        this.bonus = bonusToSet;
    }

    @Override
    public void applyPowerUp(final World gameWorld) {
        V2d acceleration = bonus ? new V2d(DELTA, DELTA) : new V2d(-DELTA, -DELTA);
        gameWorld.getBalls().stream().forEach(b -> b.setSpeed(b.getSpeed().sum(acceleration)));
    }
}
