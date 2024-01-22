package brickbreaker.model.world.gameObjects;

import brickbreaker.common.TypeObj;
import brickbreaker.common.Vector2D;
import brickbreaker.model.world.gameObjects.bounding.CircleBoundingBox;

/**
 * Class to model the game object Ball.
 * Extends {@link GameObjectImpl}.
 */
public class Ball extends GameObjectImpl<CircleBoundingBox> {

    /**
     * Radius of the Ball.
     */
    public static final Double RADIUS = 15.0;

    /**
     * Ball constructor.
     * @param center the center of the Ball
     * @param vel the velocity of the Ball
     */
    public Ball(final Vector2D center, final Vector2D vel) {
        super(1, vel, TypeObj.BALL, new CircleBoundingBox(center, RADIUS));
    }

    /**
     * @return the radius of the Ball
     */
    public Double getRadius() {
        return this.getBBox().getRad();
    }

    /**
     * Method to set the radius of the Ball.
     * @param radius the radius to set
     */
    public void setRadius(final Double radius) {
        this.getBBox().setRadius(radius);
    }

    /**
     * Method to invert the speed of the ball vertically.
     */
    public void flipVelOnY() {
        this.setSpeed(new Vector2D(this.getSpeed().getX(), -this.getSpeed().getY()));
    }

    /**
     * Method to invert the speed of the ball horizontally.
     */
    public void flipVelOnX() {
        this.setSpeed(new Vector2D(-this.getSpeed().getX(), this.getSpeed().getY()));
    }
}
