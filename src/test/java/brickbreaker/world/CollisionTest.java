package brickbreaker.world;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import brickbreaker.common.TypePower;
import brickbreaker.common.Vector2D;
import brickbreaker.model.factory.WorldFactory;
import brickbreaker.model.world.gameObjects.Ball;
import brickbreaker.model.world.gameObjects.Bar;
import brickbreaker.model.world.gameObjects.Brick;
import brickbreaker.model.world.gameObjects.PowerUp;
import brickbreaker.model.world.gameObjects.collision.WorldEvent;

/**
 * Collision test.
 */
public class CollisionTest {

    private Brick brick;
    private Ball ball;
    private Bar bar;
    private PowerUp powerUp;
    private WorldEvent event;

    private static final int VALUES6 = 6;
    private static final int VALUES5 = 5;
    private static final int VALUES4 = 4;
    private static final int VALUES3 = 3;
    private static final int VALUES2 = 2;
    private static final int VALUES1 = 1;
    private static final int VALUES0 = 0;
    private static final Double VALUES2D7 = 2.7;
    private static final Double VALUES3D1 = 3.1;
    private static final Double VALUES1D6 = 1.6;

    /**
     * Set up the test.
     */
    @BeforeEach
    void setUp() {
        brick = new Brick(new Vector2D(VALUES2, VALUES2), VALUES3);
        ball = new Ball(new Vector2D(VALUES0, VALUES0), new Vector2D(VALUES1, VALUES1));
        bar = new Bar(new Vector2D(VALUES5, VALUES5), VALUES3);
        powerUp = new PowerUp(new Vector2D(VALUES0, VALUES0), TypePower.NULL);
        event = new WorldEvent();
    }

    /**
     * Test the {@link WorldEvent} class.
     */
    @Test
    void testCollisionWithBrick() {
        ball.setPosition(new Vector2D(VALUES2, VALUES2D7));
        assertTrue(brick.getBBox().isCollidingWith(ball.getBBox()));
        ball.setPosition(new Vector2D(VALUES3D1, VALUES1D6));
        assertTrue(brick.getBBox().isCollidingWith(ball.getBBox()));
        Double xSpeed = ball.getSpeed().getX();
        event.process(ball, brick);
        assertEquals(-xSpeed, ball.getSpeed().getX());
        assertEquals(1, ball.getSpeed().getY());

    }

    /**
     * Test the {@link WorldEvent} class.
     */
    @Test
    void testCollisionWithBar() {
        ball.setPosition(new Vector2D(VALUES6, VALUES4));
        assertTrue(bar.getBBox().isCollidingWith(ball.getBBox()));
        Double ySpeed = ball.getSpeed().getY();
        event.process(ball, bar);
        assertEquals(-ySpeed, ball.getSpeed().getY());
        ball.setPosition(new Vector2D(WorldFactory.BOUNDARIES_SIZE - 100, WorldFactory.BOUNDARIES_SIZE - 100));
        assertFalse(bar.getBBox().isCollidingWith(ball.getBBox()));
    }

    /**
     * Test the {@link WorldEvent} class.
     */
    @Test
    void testCollisionWithPowerUp() {
        powerUp.setPosition(new Vector2D(VALUES6, VALUES4));
        assertTrue(powerUp.getBBox().isCollidingWith(bar.getBBox()));
        powerUp.setPosition(new Vector2D(WorldFactory.BOUNDARIES_SIZE - 100, WorldFactory.BOUNDARIES_SIZE - 100));
        assertFalse(powerUp.getBBox().isCollidingWith(bar.getBBox()));
    }
}
