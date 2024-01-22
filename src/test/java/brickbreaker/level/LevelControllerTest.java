package brickbreaker.level;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import brickbreaker.controllers.LevelController;

public class LevelControllerTest {

    private final String FIRST_MAP = "frenzyJungle";
    private final String SECOND_MAP = "blurryNight";

    private final Integer FIRST_MAP_INDEX = 0;
    private final Integer SECOND_MAP_INDEX = 1;

    private LevelController l;
    
    @BeforeEach
    void setUp() {
        l = new LevelController();
    }

    @Test
    void testName() {
        assertEquals(FIRST_MAP_INDEX, l.getMapIndex(FIRST_MAP));
        assertEquals(SECOND_MAP_INDEX, l.getMapIndex(SECOND_MAP));
        assertEquals(FIRST_MAP, l.getLevelName(FIRST_MAP_INDEX));
        assertEquals(SECOND_MAP, l.getLevelName(SECOND_MAP_INDEX));
    }

    @Test
    void testLevel() {
        l.setLevel(Optional.empty());
        assertEquals(false, l.hasNextLevel());
    }
}
