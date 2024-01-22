package brickbreaker.model.rank;

import java.util.HashMap;
import java.util.Map;

/**
 * Class representing a rank.
 */
public class Rank {

    private Integer level;
    private Map<String, Integer> scores;

    /**
     * GameRank constructor.
     * 
     * @param l the level of the rank
     */
    public Rank(final Integer l) {
        this.level = l;
        this.scores = new HashMap<>();
    }

    /**
     * Method to get the rank.
     * 
     * @return a map with the name of the player and the score rapresenting the rank
     */
    public Map<String, Integer> getRank() {
        return this.scores;
    }

    /**
     * Method to get the level of the rank.
     * 
     * @return the level of the rank
     */
    public Integer getIndex() {
        return this.level;
    }

    /**
     * Method to add a new score to the rank only if better.
     * 
     * @param name  the name of the score
     * @param score the score
     */
    public void addScore(final String name, final Integer score) {
        if (score > this.scores.getOrDefault(name, -1)) {
            this.scores.put(name, score);
        }
    }
}
