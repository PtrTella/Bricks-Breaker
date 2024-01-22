package brickbreaker.state;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import brickbreaker.common.State;
import brickbreaker.common.Vector2D;
import brickbreaker.controllers.LevelController;
import brickbreaker.model.Level;
import brickbreaker.model.factory.WorldFactory;

/**
 * State test for the {@link Level} change state.
 */
public class StateTest {

    private Level level;

    /**
     * Set up the test.
     */
    @BeforeEach
    void setUp() {
        LevelController controller = new LevelController();
        level = new Level(1, WorldFactory.getInstance().getWorld(controller.getMapInfo(1)));
    }

    /**
     * Test the {@link Level} class.
     */
    @Test
    void testWin() {
        assertEquals(State.WAIT, level.getState());
        level.getWorld().getBricks().clear();
        assertEquals(State.WIN, level.getState());
    }

    /**
     * Test the {@link Level} class.
     */
    @Test
    void testLost() {
        assertEquals(State.WAIT, level.getState());
        assertEquals(1, level.getWorld().getBar().getLife());
        level.getWorld().getBar().decLife();
        assertEquals(State.LOST, level.getState());
    }

    /**
     * Test the {@link Level} class.
     */
    @Test
    void testWait() {
        assertEquals(State.WAIT, level.getState());
        level.setState(State.PLAYING);
        assertEquals(State.PLAYING, level.getState());
        assertEquals(1, level.getWorld().getBar().getLife());
        level.getWorld().getBar().incLife();
        assertEquals(2, level.getWorld().getBar().getLife());
        level.getWorld().getBalls().get(0).setPosition(
                new Vector2D(WorldFactory.BOUNDARIES_SIZE / 2, WorldFactory.BOUNDARIES_SIZE - 1));
        level.getWorld().checkCollision();
        assertEquals(0, level.getWorld().getBalls().size());
        assertEquals(State.WAIT, level.getState());
    }
}
