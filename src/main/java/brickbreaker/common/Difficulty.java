package brickbreaker.common;

/**
 * Enum representing the level difficulty of the game.
 */
public enum Difficulty {

    /** Easy. */
    EASY(30, 70, 5),
    /** Medium. */
    MEDIUM(50, 50, 7),
    /** Hard. */
    HARD(70, 30, 10),
    /** Random. */
    RANDOM(0, 0, 0);

    private final Integer brickP;
    private final Integer bP;
    private final Integer mlP;

    /**
     * Constructor of the enum.
     * @param brickP
     * @param bonusPercentage
     * @param maxBrickLife
     */
    Difficulty(final int brickP, final int bonusPercentage, final int maxBrickLife) {
        this.brickP = brickP;
        this.bP = bonusPercentage;
        this.mlP = maxBrickLife;
    }

    /**
     * This method returns the bonus percentage that every brick could have
     * in this difficulty category.
     * @return the bonus percentage
     */
    public Integer getBonusPercentage() {
        return this.bP; 
    }

    /**
     * This method returns the maximum life value that every brick could have
     * in this difficulty category.
     * 
     * @return the maximum life value
     */
    public Integer getMaxBrickLife() {
        return this.mlP;
    }

    /**
     * This method returns the percentage of bricks that will be present in the game
     * in this difficulty category.
     * 
     * @return the percentage of bricks
     */
    public Integer getBrickPercentage() {
        return this.brickP;
    }
}
