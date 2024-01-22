package brickbreaker.model.world.gameObjects.collision.powerUpApplicator;

import brickbreaker.model.world.World;
import brickbreaker.model.world.gameObjects.Ball;

/**
 * Class to apply ball dimension powerUp to Ball.
 * Implements the {@link PowerUpApplicator} interface.
 */
public class BallDimApplicator implements PowerUpApplicator {

    private static final Double DELTA = Ball.RADIUS / 3;
    private boolean bonus;

    /**
     * Ball Dimension constructor.
     * 
     * @param bonusToSet if increase or decrease the Ball dimension
     */
    public BallDimApplicator(final boolean bonusToSet) {
        this.bonus = bonusToSet;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyPowerUp(final World world) {
        Double d = bonus ? DELTA : -DELTA;
        world.getBalls().stream().forEach(b -> {
            if (b.getRadius() > d && b.getRadius() < Ball.RADIUS * 2) {
                b.setRadius(b.getRadius() + d);
            }
        });
    }
}
