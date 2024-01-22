package brickbreaker.controllers;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.reflect.TypeToken;

import brickbreaker.common.Difficulty;
import brickbreaker.common.JsonUtils;
import brickbreaker.model.rank.Rank;

/**
 * The controller of the ranks.
 */
public class RankController {

    private static final String ENDLESS_RANKS_FILE = "endless.json";
    private static final String LEVEL_RANKS_FILE = "levels.json";

    private List<Rank> endlessRanks;
    private List<Rank> levelsRanks;

    /**
     * RankController constructor.
     */
    public RankController() {
        this.endlessRanks = new ArrayList<>();
        this.levelsRanks = new ArrayList<>();
        this.endlessRanks = JsonUtils.loadData(new TypeToken<List<Rank>>() {
        }.getType(), ENDLESS_RANKS_FILE);
        this.levelsRanks = JsonUtils.loadData(new TypeToken<List<Rank>>() {
        }.getType(), LEVEL_RANKS_FILE);
    }

    /**
     * Method to save the ranks.
     */
    public void saveRanks() {
        JsonUtils.saveData(this.endlessRanks, ENDLESS_RANKS_FILE);
        JsonUtils.saveData(this.levelsRanks, LEVEL_RANKS_FILE);
    }

    /**
     * Method to get all the endless mode ranks.
     * 
     * @return a List of Rank of the endless
     */
    public List<Rank> getEndlessRanks() {
        return this.endlessRanks;
    }

    /**
     * Method to get all the levels mode ranks.
     * 
     * @return a List of Rank of the levels
     */
    public List<Rank> getLevelsRanks() {
        return this.levelsRanks;
    }

    /**
     * Method to add a new score to the endless rank.
     * The method add the score in the rank of the difficulty passed.
     * 
     * @param difficulty the difficulty of the rank
     * @param username   the username of the player
     * @param newScore   the new score
     */
    public void addScoreInEndlessRank(Difficulty difficulty, String username, Integer newScore) {
        this.endlessRanks.stream().filter(r -> r.getIndex().equals(difficulty.ordinal()))
                .findFirst().orElse(null).addScore(username, newScore);
    }

    /**
     * Method to add a new score to the levels rank.
     * The method add the score in the rank of the difficulty passed.
     * 
     * @param level    the level of the rank
     * @param username the username of the player
     * @param newScore the new score
     */
    public void addScoreInLevelsRank(Integer level, String username, Integer newScore) {
        this.levelsRanks.stream().filter(r -> r.getIndex().equals(level))
                .findFirst().orElse(null).addScore(username, newScore);
    }

    /**
     * Method to remove a score in all the ranks.
     * 
     * @param username the username of the player
     */
    public void removeScoreInAllRanks(String username) {
        this.endlessRanks.forEach(r -> r.getRank().remove(username));
        this.levelsRanks.forEach(r -> r.getRank().remove(username));
    }

    /**
     * Method to get the EndlessRank.
     * 
     * @param difficulty the difficulty of the rank
     * @return a Rank
     */
    public Rank getEndlessRank(final Difficulty difficulty) {
        return this.endlessRanks.stream().filter(r -> r.getIndex().equals(difficulty.ordinal())).findFirst()
                .orElse(null);
    }

    /**
     * Method to get the size of endless rank.
     * 
     * @return an integer size
     */
    public Integer getEndlessRankQuantity() {
        return this.endlessRanks.size();
    }

    /**
     * Method to get the LevelsRank.
     * 
     * @param level the level of the rank
     * @return a Rank
     */
    public Rank getLevelsRank(final Integer level) {
        return this.levelsRanks.stream().filter(r -> r.getIndex().equals(level)).findFirst().orElse(null);
    }

    /**
     * Method to get the size of levels rank.
     * 
     * @return an integer size
     */
    public Integer getLevelsRankQuantity() {
        return this.levelsRanks.size();
    }
}
