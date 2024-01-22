package brickbreaker.model.world.gameObjects.collision.powerUpApplicator;

import brickbreaker.model.world.World;

/**
 * Interface for all powerUp to modify the world.
 */
public interface PowerUpApplicator {

    /**
     * Method to modify the world objects with active powerUps.
     * 
     * @param world the world to modify
     */
    void applyPowerUp(World world);
}
