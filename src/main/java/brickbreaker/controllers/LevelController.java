package brickbreaker.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import com.google.gson.reflect.TypeToken;

import brickbreaker.common.Difficulty;
import brickbreaker.common.JsonUtils;
import brickbreaker.model.Level;
import brickbreaker.model.factory.WorldFactory;
import brickbreaker.model.map.MapData;

/**
 * The controller of the levels generation.
 */
public class LevelController {

    private static final String MAPS_FILE = "mapsFile/levels.json";

    private List<MapData> mapList;
    private Difficulty defaultDifficulty = Difficulty.RANDOM;
    private Optional<Integer> level = Optional.empty();
    private Random randomDiff = new Random();

    /**
     * LevelController constructor.
     */
    public LevelController() {
        this.mapList = JsonUtils.load(new TypeToken<List<MapData>>() {
        }.getType(), MAPS_FILE);
    }

    private Difficulty getRandomDifficulty() {
        return Difficulty.values()[randomDiff.nextInt(Difficulty.values().length)];
    }

    private Difficulty getDifficulty() {
        if (defaultDifficulty.equals(Difficulty.RANDOM)) {
            return this.getRandomDifficulty();
        } else {
            return defaultDifficulty;
        }
    }

    /**
     * Method to get the setted difficulty at the beginning.
     * 
     * @return the setted difficulty
     */
    protected Difficulty getSettedDifficulty() {
        return this.defaultDifficulty;
    }

    /**
     * Method to get a level.
     * 
     * @return the level generated
     */
    protected Level getLevel() {
        if (this.level.isPresent() && level.get() < this.mapList.size()) {
            return new Level(level.get(), WorldFactory.getInstance().getWorld(this.mapList.get(level.get())));
        }
        return new Level(0, WorldFactory.getInstance().getRandomWorld(this.getDifficulty()));
    }

    /**
     * Method to set the level.
     * 
     * @param level the level to set
     */
    public void setLevel(final Optional<Integer> level) {
        this.level = level;
    }

    /**
     * @return true if have another level
     */
    public boolean hasNextLevel() {
        return this.level.isPresent() && this.level.get() < this.mapList.size() - 1;
    }

    /**
     * Assign the new level.
     */
    public void nextLevel() {
        if (this.level.isPresent()) {
            this.level = Optional.of(this.level.get() + 1);
        } else {
            this.level = Optional.empty();
        }
    }

    /**
     * Method to the the map level information.
     * 
     * @param i the index of the map
     * @return a MapInfo
     */
    public MapData getMapInfo(final Integer i) {
        return this.mapList.get(i);
    }

    /**
     * Method to get the map index.
     * 
     * @param name the name of the map
     * @return the index of the map
     */
    public Integer getMapIndex(final String name) {
        Optional<MapData> m = this.mapList.stream().filter(map -> map.getName().equals(name)).findFirst();
        return m.get().getIndex();
    }

    /**
     * Method to get the map list lenght.
     * 
     * @return the map list lenght
     */
    public Integer getListMapLenght() {
        return this.mapList.size();
    }

    /**
     * Method to set the level difficulty.
     * 
     * @param diff the difficulty
     */
    public void setDifficultyLevel(final Difficulty diff) {
        this.defaultDifficulty = diff;
    }

    /**
     * Method to get the level name.
     * 
     * @param i the level index
     * @return the level name
     */
    public String getLevelName(final Integer i) {
        return this.mapList.get(i).getName();
    }

    /**
     * Method to get all the map info.
     * 
     * @return the List of MapInfo
     */
    public List<MapData> getMapList() {
        return this.mapList;
    }
}
