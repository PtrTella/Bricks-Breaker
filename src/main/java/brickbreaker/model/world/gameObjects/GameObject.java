package brickbreaker.model.world.gameObjects;

import brickbreaker.common.TypeObj;
import brickbreaker.common.Vector2D;

/**
 * An interface to model the Game Objects. It implements the common methods
 * for each game object: type, life, position, speed and bounding box.
 * 
 * @param <T> the type of bounding box
 */
public interface GameObject<T> {

    /**
     * @return the object's lives
     */
    Integer getLife();

    /**
     * Sets the lifes of the current game object.
     * @param lifes the lifes to set
     */
    void setLife(Integer lifes);

    /**
     * decrease lives by 1.
     */
    void decLife();

    /**
     * increase lives by 1.
     */
    void incLife();

    /**
     * @return the object's type
     */
    TypeObj getType();

    /**
     * @return the object's position
     */
    Vector2D getPosition();

    /**
     * @param newPosition the position to set
     */
    void setPosition(Vector2D newPosition);

    /**
     * @return the object's speed
     */
    Vector2D getSpeed();

    /**
     * @param speed the speed to set
     */
    void setSpeed(Vector2D speed);

    /**
     * @return the object's bounding box
     */
    T getBBox();
}
