package brickbreaker.rank;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import brickbreaker.model.rank.Rank;

public class RankTest {

    private final Integer RANK_TEST_VALUE = 1;
    private final String NAME_PLACEHOLDER = "Richard";
    private final Integer SCORE_TEST = 100;

    private Rank r;

    @BeforeEach
    void setUp() {
        r = new Rank(RANK_TEST_VALUE);
    }

    @Test
    void levelTest() {
        assertEquals(true, r.getIndex() == RANK_TEST_VALUE);
    }

    @Test
    void populatingTest() {
        r.addScore(NAME_PLACEHOLDER, SCORE_TEST);
        assertEquals(SCORE_TEST, r.getRank().get(NAME_PLACEHOLDER));
        assertEquals(true, r.getRank().containsKey(NAME_PLACEHOLDER));
    }
}