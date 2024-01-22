package brickbreaker.model.world.gameObjects.collision.powerUpApplicator;

import brickbreaker.model.world.World;

/**
 * Class to apply life increese powerUp to Bar.
 * Implements the {@link PowerUpApplicator} interface.
 */
public class LifeIncApplicator implements PowerUpApplicator {

    /**
     * Life increese constructor.
     */
    public LifeIncApplicator() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyPowerUp(final World world) {
        world.getBar().incLife();
    }

}
