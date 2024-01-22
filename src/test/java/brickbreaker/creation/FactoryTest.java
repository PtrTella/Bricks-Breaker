package brickbreaker.creation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import brickbreaker.common.Vector2D;
import brickbreaker.controllers.LevelController;
import brickbreaker.model.factory.GameFactory;
import brickbreaker.model.factory.WorldFactory;
import brickbreaker.model.world.World;
import brickbreaker.model.world.WorldImpl;
import brickbreaker.model.world.gameObjects.Brick;
import brickbreaker.model.world.gameObjects.bounding.RectBoundingBox;

/**
 * Factory test for the {@link WorldFactory} class.
 */
public class FactoryTest {

    private GameFactory g;
    private WorldFactory w;
    private World world;
    private World wo;

    /**
     * Set up the test.
     */
    @BeforeEach
    void setUp() {
        LevelController controller = new LevelController();
        g = GameFactory.getInstance();
        w = WorldFactory.getInstance();
        world = new WorldImpl(new RectBoundingBox(new Vector2D(0, 0), 0.0, 0.0));
        world.addBall(g.createBall(new Vector2D(0, 0), new Vector2D(0, 0)));
        world.setBar(g.createBar(new Vector2D(0, 0)));
        wo = (w.getWorld(controller.getMapInfo(1)));
    }

    /**
     * Test the {@link WorldFactory} class.
     */
    @Test
    void testCreateBall() {
        assertEquals(1, world.getBalls().size());
    }

    /**
     * Test the {@link WorldFactory} class.
     */
    @Test
    void testCreateBricks() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(1);
        list.add(1);
        List<Brick> b = g.createBricks(list, 1, 3);
        assertEquals(3, b.size());
    }

    /**
     * Test the {@link WorldFactory} class.
     */
    @Test
    void testCreateBar() {
        assertTrue(world.getBar() != null);
    }

    /**
     * Test the {@link WorldFactory} class.
     */
    @Test
    void testCreateWorld() {
        assertEquals(1, wo.getBalls().size());
        assertEquals(1, wo.getBar().getLife());
        assertEquals(16, wo.getBricks().size());
    }
}
