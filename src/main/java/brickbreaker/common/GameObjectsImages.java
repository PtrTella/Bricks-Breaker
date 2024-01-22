package brickbreaker.common;

import javafx.scene.image.Image;

/**
 * Enum that stores all the images related to the game objects.
 */
public enum GameObjectsImages {

    /** Brick blue image name. */
    BLUE_BRICK("blueBrick.png"),

    /** Brick lime image name.*/
    LIME_BRICK("limeBrick.png"),

    /** Brick purple image name. */
    PURPLE_BRICK("purpleBrick.png"),

    /** Brick red image name. */
    RED_BRICK("redBrick.png"),

    /** Brick orange image name. */
    ORANGE_BRICK("orangeBrick.png"),

    /** Brick light blue image name. */
    BRIGHT_BLUE_BRICK("brightBlueBrick.png"),

    /** Brick yellow image name. */
    YELLOW_BRICK("yellowBrick.png"),

    /** Brick green image name. */
    GREEN_BRICK("greenBrick.png"),

    /** Brick grey image name. */
    GREY_BRICK("greyBrick.png"),

    /** Brick brown image name. */
    BROWN_BRICK("brownBrick.png"),

    /** Fast ball icon name. */
    FAST_BALL("fastBall.png"),

    /** Slow ball icon name. */
    SLOW_BALL("slowBallMalus.png"),

    /** Long bar icon name. */
    LONG_BAR("longBarBonus.png"),

    /** Short bar icon name. */
    SHORT_BAR("shortBarMalus.png"),

    /** Fifty score icon name. */
    FIFTY_SCORE_POWER_UP("fiftyScorePP.png"),

    /** One hundred score icon name. */
    ONE_HUNDRED_SCORE_POWER_UP("oneHundredScorePP.png"),

    /** Large score icon name. */
    LARGE_SCORE_POWER_UP("Large_Score_PP.png"),

    /** Mega score icon name. */
    MEGA_SCORE_POWER_UP("megaScorePP.png"),

    /** Fifty score malus icon name. */
    FIFTY_SCORE_MALUS("fiftyScoreMalus.png"),

    /** One hundred score malus icon name. */
    ONE_HUNDRED_SCORE_MALUS("oneHundredScoreMalus.png"),

    /** Life icon name. */
    LIFE_ICON("incLife.png"),

    /** Multi ball icon name. */
    MULTI_BALL("multiBall.png"),

    /** Ball image name. */
    BALL("ball.png"),

    /** Bar image name. */
    BAR_ANIMATION_1("bar.png"),

    /** Bar image name. */
    BAR_ANIMATION_2("barAnimation1.png"),

    /** Bar image name. */
    BAR_ANIMATION_3("barAnimation2.png");

    private static final String RES_PATH = "images/sprites/";
    private String fileName;
    private Image i;

    /**
     * Constructor of the enum.
     * 
     * @param fileName the name of the file
     */
    GameObjectsImages(final String fileName) {
        this.fileName = fileName;
    }

    /**
     * This method returns the file path of the image.
     * @return A String object which is the file path of the image.
     */
    public String getFilePath() {
        return RES_PATH + this.fileName;
    }

    /**
     * This method sets the Image object related to the current enum value.
     * @param image An Image object which will be binded with the current selected enum value.
     */
    public void setImage(final Image image) {
        this.i = image;
    }

    /**
     * This method gets the Image object related to the current enum value.
     * @return the Image object binded with the enum value.
     */
    public Image getImage() {
        return this.i;
    }
}
