package brickbreaker.model.world;

import java.util.List;

import brickbreaker.model.world.gameObjects.Ball;
import brickbreaker.model.world.gameObjects.Bar;
import brickbreaker.model.world.gameObjects.Brick;
import brickbreaker.model.world.gameObjects.PowerUp;
import brickbreaker.model.world.gameObjects.bounding.RectBoundingBox;

/**
 * Interface to model the Game World. It defines the Object tha belongs to it:
 * Balls, Bar, Bricks, PowerUps and the main Bounding Box on the edge of the
 * World.
 * It also defines the Object movement and their collision.
 */
public interface World {

    /**
     * Method to add a ball to the world.
     * 
     * @param ball the ball to add
     */
    void addBall(Ball ball);

    /**
     * Method to get the list of ball in play.
     * 
     * @return the list of ball in play
     */
    List<Ball> getBalls();

    /**
     * Method to get the bar.
     * 
     * @return the bar
     */
    Bar getBar();

    /**
     * Method to set the bar.
     * 
     * @param bar the bar to set
     */
    void setBar(Bar bar);

    /**
     * Method to add a brick to the world.
     * 
     * @param bricks the list of bricks to add
     */
    void addBricks(List<Brick> bricks);

    /**
     * Method to get the list of bricks.
     * 
     * @return the list of live bricks
     */
    List<Brick> getBricks();

    /**
     * Method to get the list of falling powerUps.
     * 
     * @return the list of falling powerUps
     */
    List<PowerUp> getPowerUp();

    /**
     * Method to get the main Bounding Box.
     * 
     * @return the main Bounding Box
     */
    RectBoundingBox getMainBBox();

    /**
     * Move object in the world at each frame.
     * 
     * @param elapsed the time elapsed since the last frame
     */
    void updateGame(int elapsed);

    /**
     * Comunicate to the Wolrd listener if a collision occurs between two objects.
     */
    void checkCollision();

    /**
     * This method gets the current points scored by the user.
     * 
     * @return An integer value.
     */
    Integer getScore();

    /**
     * This method add the value to the score.
     * 
     * @param val an integer value
     */
    void addToScore(Integer val);

    /**
     * This method change states of indestructible brick.
     * 
     * @param b a boolean value for indestructible brick
     */
    void setDestructibleBrick(boolean b);

}
