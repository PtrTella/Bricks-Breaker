package brickbreaker.model.world.gameObjects.bounding;

import brickbreaker.common.Vector2D;

/**
 * An Interface to model the objects bounding.
 */
public interface BoundingBox {

    /**
     * @return a point 2D
     */
    Vector2D getP2d();

    /**
     * @param pos a point 2D
     */
    void setP2d(Vector2D pos);

    /**
     * @param obj bounding box object
     * @return if the two objects is colliding
     */
    boolean isCollidingWith(BoundingBox obj);

}
