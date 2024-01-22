package brickbreaker.input;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import brickbreaker.common.Vector2D;
import brickbreaker.controllers.InputController;
import brickbreaker.controllers.LevelController;
import brickbreaker.model.factory.WorldFactory;
import brickbreaker.model.world.World;

/**
 * Bar input test for the {@link BarInput} class.
 */
public class BarInputTest {

    private World world;
    private InputController controller;
    private static final Double ELAPSED = 200.0;

    /**
     * Set up the test.
     */
    @BeforeEach
    void setUp() {
        LevelController controll = new LevelController();
        world = WorldFactory.getInstance().getWorld(controll.getMapInfo(1));
        controller = new InputController();
    }

    /**
     * Test the {@link BarInput} class.
     */
    @Test
    void testMove() {
        Vector2D pos = world.getBar().getPosition();
        controller.notifyMoveLeft();
        world.getBar().updateInput(ELAPSED, controller, world.getMainBBox().getBRCorner().getX());
        assertNotEquals(pos.getX(), world.getBar().getPosition().getX());
        assertEquals(pos.getY(), world.getBar().getPosition().getY());
    }
}
