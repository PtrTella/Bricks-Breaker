package brickbreaker.model.world.gameObjects.collision.powerUpApplicator;

import brickbreaker.model.world.World;

/**
 * Class to apply indestructible Brick powerUp to Brick.
 * Implements the {@link PowerUpApplicator} interface.
 */
public class DestructibleBrickApplicator implements PowerUpApplicator {

    private boolean bonus;

    /**
     * IndestructibleBrickApplicator constructor.
     * @param bonusToSet if set destructible bricks
     */
    public DestructibleBrickApplicator(final boolean bonusToSet) {
        this.bonus = bonusToSet;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyPowerUp(final World world) {
        world.setDestructibleBrick(bonus);
    }
}
