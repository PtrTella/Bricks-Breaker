package brickbreaker.world;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import brickbreaker.common.TypePower;
import brickbreaker.common.Vector2D;
import brickbreaker.controllers.LevelController;
import brickbreaker.model.factory.ApplicatorFactory;
import brickbreaker.model.factory.WorldFactory;
import brickbreaker.model.world.World;
import brickbreaker.model.world.gameObjects.Ball;
import brickbreaker.model.world.gameObjects.PowerUp;

/**
 * World test.
 */
public class WorldTest {

    private static final int VALUES100 = 100;
    private static final int VALUES120 = 120;
    private static final int VALUES0 = 0;

    private World world;
    private ApplicatorFactory factory;
    private Ball ball;

    /**
     * Set up the test.
     */
    @BeforeEach
    void setUp() {
        LevelController controller = new LevelController();
        world = WorldFactory.getInstance().getWorld(controller.getMapInfo(1));
        ball = new Ball(new Vector2D(VALUES0, VALUES0), new Vector2D(1, 1));
        ball.setPosition(new Vector2D(VALUES100, VALUES120));
        factory = new ApplicatorFactory();
    }

    /**
     * Test the {@link World} class.
     */
    @Test
    void testIncrementScore() {
        world.addBall(ball);
        int sizeBricks = world.getBricks().size();
        world.checkCollision();
        assertEquals(VALUES100, world.getScore());
        assertEquals(sizeBricks - 1, world.getBricks().size());
    }

    /**
     * Test the {@link World} class.
     */
    @Test
    void testLossBall() {
        world.addBall(ball);
        assertEquals(2, world.getBalls().size());
        world.getBalls().get(0)
                .setPosition(new Vector2D(WorldFactory.BOUNDARIES_SIZE / 2, WorldFactory.BOUNDARIES_SIZE - 1));
        world.checkCollision();
        assertEquals(1, world.getBalls().size());
    }

    /**
     * Test the {@link World} class.
     */
    @Test
    void testLossLife() {
        Integer life = world.getBar().getLife();
        world.getBalls().get(0)
                .setPosition(new Vector2D(WorldFactory.BOUNDARIES_SIZE / 2, WorldFactory.BOUNDARIES_SIZE - 1));
        world.checkCollision();
        assertEquals(life - 1, world.getBar().getLife());
    }

    /**
     * Test the {@link World} class.
     */
    @Test
    void testBigBallPowerUp() {
        assertEquals(Ball.RADIUS, world.getBalls().get(0).getRadius());
        PowerUp p = new PowerUp(new Vector2D(0, 0), TypePower.BIGBALL);
        this.factory.createApplicator(p.getPowerUp(), true).applyPowerUp(world);
        assertEquals(Ball.RADIUS + (Ball.RADIUS / 3), world.getBalls().get(0).getRadius());
    }
}
