package brickbreaker.model.factory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import brickbreaker.common.Difficulty;
import brickbreaker.common.Vector2D;
import brickbreaker.model.world.gameObjects.Ball;
import brickbreaker.model.world.gameObjects.Bar;
import brickbreaker.model.world.gameObjects.Brick;

/**
 * Factory class for creating game objects: Ball, Bar, Bricks.
 */
public class GameFactory {

    /** Life bar start. */
    public static final Integer LIFE_BAR = 1;
    private static GameFactory instance;

    /**
     * @return the instance of GameFactory if it not exists yet.
     */
    public static GameFactory getInstance() {
        if (instance == null) {
            instance = new GameFactory();
        }
        return instance;
    }

    /**
     * Method to create a ball object.
     * 
     * @param posToSet position
     * @param velToSet velocity
     * @return a new Ball object
     */
    public Ball createBall(final Vector2D posToSet, final Vector2D velToSet) {
        return new Ball(posToSet, velToSet);
    }

    /**
     * Method to create the bricks.
     * 
     * @param list of bricks life
     * @param col  columns
     * @param row  rows
     * @return a list of brick objects
     */
    public List<Brick> createBricks(final List<Integer> list, final Integer col, final Integer row) {
        List<Brick> result = new ArrayList<>();
        Integer life;
        for (int y = 0; y < row; y++) {
            for (int x = 0; x < col; x++) {
                life = list.get(x + y * col);
                if (life > 0) {
                    result.add(new Brick(
                            new Vector2D(x * Brick.BRICK_WIDTH + (Brick.BRICK_WIDTH / 2), y
                                    * Brick.BRICK_HEIGHT + (Brick.BRICK_HEIGHT / 2)),
                            life));
                }
            }
        }
        return result;
    }

    /**
     * Method to assign radom life to bricks.
     * 
     * @param d    difficulty
     * @param cols columns
     * @param rows rows
     * @return a list of random brick objects
     */
    public List<Brick> createRandomBricks(final Difficulty d, final Integer cols, final Integer rows) {
        Random r = new Random();
        List<Brick> bricks = new LinkedList<>();

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (r.nextInt(100) < d.getBrickPercentage()) {
                    bricks.add(new Brick(
                            new Vector2D(i * Brick.BRICK_WIDTH + Brick.BRICK_WIDTH / 2, j
                                    * Brick.BRICK_HEIGHT + Brick.BRICK_HEIGHT / 2),
                            r.nextInt(d.getMaxBrickLife()) + 1));
                }
            }
        }
        return bricks;
    }

    /**
     * Method to create a bar object.
     * 
     * @param posToSet position
     * @return a new Bar object
     */
    public Bar createBar(final Vector2D posToSet) {
        return new Bar(posToSet, LIFE_BAR);
    }
}
