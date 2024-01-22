package brickbreaker.common;

import javafx.scene.image.Image;

/**
 * Game Images enum with name files.
 */
public enum GameImages {

    /** Forest landscape. */
    FOREST_LANDSCAPE("forest.png"),

    /** Space landscape. */
    SPACE_LANDSCAPE("background.jpg"),

    /** Night sky. */
    NIGHT_SKY("night-sky.jpg"),

    /** Sea landscape. */
    SEA_LANDSCAPE("nickname.png"),

    /** City landscape. */
    CITY_LANDSCAPE("City.png"),

    /** Game icon. */
    GAME_ICON("gameIcon.png"),

    /** Difficulty */
    DIFFICULTY("difficulty.png"),

    /** Easy difficulty. */
    EASY_DIFFICULTY("easy.png"),

    /** Medium difficulty. */
    MEDIUM_DIFFICULTY("medium.png"),

    /** Hard difficulty. */
    HARD_DIFFICULTY("hard.png"),

    /** Mix difficulty. */
    MIX_DIFFICULTY("mix.png"),

    /** Nickname label. */
    NICKNAME_LABEL("nickname.png"),

    /** Type your name label. */
    TYPE_YOUR_NAME_LABEL("typeYourName.png"),

    /** Pick a level. */
    PICK_A_LEVEL("pickALevel.png"),

    /** Next. */
    NEXT("next.png"),

    /** Previous. */
    PREVIOUS("previous.png"),

    /** Not loaded item. */
    NOT_LOADED_ITEM("notLoaded.png"),

    /** Title. */
    TITLE("Title.png"),

    /** Endless mode choice. */
    ENDLESS_MODE_CHOICE("endless.png"),

    /** Endless mode title. */
    ENDLESS_MODE_TITLE("endlessModeTitle.png"),

    /** Leevls label. */
    LEVELS_LABEL("levels.png"),

    /** Levels mode choice. */
    LEVELS_MODE_CHOICE("start.png"),

    /** Leaderboard choice. */
    LEADERBOARD_CHOICE("leaderboards.png"),

    /** Ready to play image. */
    READY_TO_PLAY("ready.png"),

    /** Up arrow. */
    UP_ARROW("upArrow.png"),

    /** Down arrow. */
    DOWN_ARROW("downArrow.png"),

    /** Right arrow. */
    RIGHT_ARROW("rightArrow.png"),

    /** Left arrow. */
    LEFT_ARROW("leftArrow.png"),

    /** Back arrow. */
    BACK_ARROW("backArrow.png"),

    /** Player lost label. */
    PLAYER_LOST("youLost.png"),
    /** Player win label. */
    PLAYER_WIN("youWin.png"),

    /** Quit label. */
    QUIT("quit.png"),

    /** Continue label. */
    CONTINUE("continue.png");

    private static final String RES_PATH = "images/";
    private String fileName;
    private Image image;

    /**
     * Constructor of the enum.
     * 
     * @param fileName the name of the file
     */
    GameImages(final String fileName) {
        this.fileName = fileName;
    }

    /**
     * Mathod to set the file Image.
     * 
     * @param image the image
     */
    public void setImage(final Image image) {
        this.image = image;
    }

    /**
     * Method to get the Image.
     * 
     * @return the image
     */
    public Image getImage() {
        return this.image;
    }

    /**
     * Method to get the absolute path.
     * 
     * @return path
     */
    public String getFilePath() {
        return RES_PATH + this.fileName;
    }
}
