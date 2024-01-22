package brickbreaker.model;

import brickbreaker.common.State;
import brickbreaker.common.Vector2D;
import brickbreaker.model.factory.GameFactory;
import brickbreaker.model.factory.WorldFactory;
import brickbreaker.model.world.World;
import brickbreaker.model.world.gameObjects.Ball;

/**
 * Class representing a single level.
 */
public class Level {

    private final Integer id;
    private World world;
    private State state;

    /**
     * Level constructor.
     * 
     * @param id the level number
     * @param w  the world of the level
     */
    public Level(final Integer id, final World w) {
        this.id = id;
        this.world = w;
        this.state = State.WAIT;
    }

    /**
     * @return the level number
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * This method returns the current game world.
     * 
     * @return A World object
     */
    public World getWorld() {
        return this.world;
    }

    /**
     * This method updates all world objects of a frame.
     * 
     * @param elapsed the elapsed time
     */
    public void updateGame(final Integer elapsed) {
        this.world.updateGame(elapsed);
    }

    /**
     * This method returns the current state.
     * 
     * @return A State enum object
     */
    public State getState() {
        if (this.world.getBar().getLife() <= 0) {
            this.state = State.LOST;
        } else if (this.world.getBalls().size() <= 0) {
            // set the new ball il the center of bar
            Double h = this.world.getBar().getHeight() / 2 + Ball.RADIUS;
            Vector2D barPos = this.world.getBar().getPosition();
            this.world.addBall(GameFactory.getInstance().createBall(
                    new Vector2D(barPos.getX(), barPos.getY() - h),
                    new Vector2D(WorldFactory.X_SPEED, WorldFactory.Y_SPEED)));
            this.state = State.WAIT;
        } else if (this.getWorld().getBricks().size() == 0) {
            this.state = State.WIN;
        }
        return this.state;
    }

    /**
     * This method sets the state passed.
     * 
     * @param s the new state
     */
    public void setState(final State s) {
        this.state = s;
    }
}
