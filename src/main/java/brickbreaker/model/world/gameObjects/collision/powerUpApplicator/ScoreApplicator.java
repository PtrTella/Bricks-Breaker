package brickbreaker.model.world.gameObjects.collision.powerUpApplicator;

import brickbreaker.model.world.World;

/**
 * Class to apply increment or decreement powerUp to the score.
 * Implements the {@link PowerUpApplicator} interface.
 */
public class ScoreApplicator implements PowerUpApplicator {

    private Integer delta;

    /**
     * Score applicator constructor.
     * 
     * @param val the value to add or subtract to the score
     */
    public ScoreApplicator(final Integer val) {
        this.delta = val;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyPowerUp(final World world) {
        world.addToScore(delta);
    }
}
