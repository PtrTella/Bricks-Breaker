package brickbreaker.model.world.gameObjects.collision.powerUpApplicator;

import brickbreaker.common.Vector2D;
import brickbreaker.model.factory.GameFactory;
import brickbreaker.model.factory.WorldFactory;
import brickbreaker.model.world.World;

/**
 * Class to apply multi Ball powerUp.
 * Implements the {@link PowerUpApplicator} interface.
 */
public class MultiBallApplicator implements PowerUpApplicator {

    /**
     * Multi Ball constructor.
     */
    public MultiBallApplicator() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyPowerUp(final World world) {
        Double speed = WorldFactory.Y_SPEED;
        Vector2D pos = world.getBar().getPosition().sum(new Vector2D(0, -world.getBar().getWidth() / 2));
        world.addBall(GameFactory.getInstance().createBall(pos, new Vector2D(-speed, speed)));
        world.addBall(GameFactory.getInstance().createBall(pos, new Vector2D(speed, speed)));
    }
}
