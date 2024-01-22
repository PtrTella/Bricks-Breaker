package brickbreaker.model.map;

import java.util.List;

import brickbreaker.common.Difficulty;
import brickbreaker.common.GameImages;

/**
 * Class to model the map info.
 */
public class MapData {

    /** Map file format rows. */
    public static final int MAP_ROWS_FILE_FORMAT = 6;
    /** Map file format columns. */
    public static final int MAP_COLUMNS_FILE_FORMAT = 6;

    private int index;
    private String landscape;
    private List<Integer> map;
    private Integer difficulty;
    private String name;

    /**
     * Map info constructor.
     * 
     * @param i         the index
     * @param b         the map
     * @param d         the difficulty
     * @param name      the name
     * @param landscape the landscape path
     */
    public MapData(final Integer i, final List<Integer> b, final Integer d, final String name, final String landscape) {
        this.index = i;
        this.map = b;
        this.difficulty = d;
        this.name = name;
        this.landscape = landscape;
        return;
    }

    /**
     * Index getter.
     * 
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Index setter.
     * 
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * Landscape getter.
     * 
     * @return the landscape
     */
    public GameImages getLandscape() {
        return GameImages.valueOf(landscape);
    }

    /**
     * Landscape setter.
     * 
     * @param landscape the landscape to set
     */
    public void setLandscape(String landscape) {
        this.landscape = landscape;
    }

    /**
     * Map getter.
     * 
     * @return the map
     */
    public List<Integer> getMap() {
        return map;
    }

    /**
     * Map setter.
     * 
     * @param map the map to set
     */
    public void setMap(List<Integer> map) {
        this.map = map;
    }

    /**
     * Difficulty getter.
     * 
     * @return the difficulty
     */
    public Difficulty getDifficulty() {
        return Difficulty.values()[difficulty];
    }

    /**
     * Difficulty setter.
     * 
     * @param difficulty the difficulty to set
     */
    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty.ordinal();
    }

    /**
     * Name getter.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Name setter.
     * 
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
