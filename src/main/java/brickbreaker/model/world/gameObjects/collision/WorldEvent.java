package brickbreaker.model.world.gameObjects.collision;

import brickbreaker.common.Vector2D;
import brickbreaker.model.world.WorldImpl.SideCollision;
import brickbreaker.model.world.gameObjects.Ball;
import brickbreaker.model.world.gameObjects.Bar;
import brickbreaker.model.world.gameObjects.Brick;

/**
 * Interface to executed the collision events of the world.
 */
public class WorldEvent {

    /**
     * The speed of the ball when it hits the bar.
     */
    public static final Integer SCALE_SPEED = 15;

    /**
     * Process the collision of the ball with the border side.
     * 
     * @param ball   the ball to process
     * @param side   the side of the collision
     * @param newPos the new position of the ball
     */
    public void process(final Ball ball, final SideCollision side, final Double newPos) {

        switch (side) {
            case TOP:
                ball.setPosition(new Vector2D(ball.getPosition().getX(), newPos + ball.getRadius()));
                ball.flipVelOnY();
                break;
            case LEFT:
                ball.setPosition(new Vector2D(newPos + ball.getRadius(), ball.getPosition().getY()));
                ball.flipVelOnX();
                break;
            case RIGHT:
                ball.setPosition(new Vector2D(newPos - ball.getRadius(), ball.getPosition().getY()));
                ball.flipVelOnX();
                break;
            default:
                break;
        }
    }

    /**
     * Process the ball collision with the bar.
     * 
     * @param ball the ball to process
     * @param bar  the bar to process
     */
    public void process(final Ball ball, final Bar bar) {
        Vector2D oldPos = ball.getPosition();
        ball.setPosition(new Vector2D(oldPos.getX(), oldPos.getY() - bar.getHeight() / 2));
        ball.flipVelOnY();
        Double distX = ball.getPosition().orizDist(bar.getPosition()) / (bar.getWidth() / 2);
        Vector2D oldSpeed = ball.getSpeed();
        ball.setSpeed(new Vector2D(distX * SCALE_SPEED, oldSpeed.getY()));
    }

    /**
     * Process the ball collision with and object [brick, bar].
     * Flip the speed of the ball.
     * 
     * @param ball  the ball to process
     * @param brick the brick to process
     */
    public void process(final Ball ball, final Brick brick) {
        Double distY = ball.getPosition().vertDist(brick.getPosition());
        Vector2D oldPos = ball.getPosition();
        if (Math.abs(distY) > brick.getBBox().getHeight() / 2) {
            if (distY > 0) {
                ball.setPosition(new Vector2D(oldPos.getX(), oldPos.getY() + ball.getRadius() / 2));
            } else {
                ball.setPosition(new Vector2D(oldPos.getX(), oldPos.getY() - ball.getRadius() / 2));
            }
            ball.flipVelOnY();
        } else {
            Double distX = ball.getPosition().orizDist(brick.getPosition());
            if (distX > 0) {
                ball.setPosition(new Vector2D(oldPos.getX() + ball.getRadius() / 2, oldPos.getY()));
            } else {
                ball.setPosition(new Vector2D(oldPos.getX() - ball.getRadius() / 2, oldPos.getY()));
            }
            ball.flipVelOnX();
        }
    }
}
