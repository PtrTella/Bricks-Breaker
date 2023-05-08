package brickbreaker.common;

public enum Difficulty {
    EASY(70),
    MEDIUM(50),
    HARD(30);

    private final Integer percentage;

    private Difficulty(final Integer value) {
        this.percentage = value;
    }

    public Integer getBonusPercentage() {
        return this.percentage;
    }
}
