package brickbreaker.view;

/**
 * This enum contains all the possible views.
 */
public enum ViewType {

    /** The home view. */
    HOME("HomeView"),
    /** The levels menu view. */
    LEVEL("LevelsMenuView"),
    /** The difficulty menu view for endless mode. */
    DIFFICULTY("DifficultyMenuView"),
    /** The Leaderboard view. */
    RANK("RankView"),
    /** The game view. */
    MATCH("GameView"),
    /** The selection user view. */
    SETUP("SetUpView"),
    /** The end game view. */
    GAMEOVER("EndGameView");

    private static final String DIRECTORY = "viewStyle/";
    private static final String FORMAT = ".fxml";

    private String fileName;

    /**
     * Constructor of the enum.
     * 
     * @param s the name of the file
     */
    ViewType(final String s) {
        this.fileName = s;
    }

    /**
     * This method is used to get the path of the view.
     * 
     * @return the path of the view
     */
    public String getPath() {
        return DIRECTORY + this.fileName + FORMAT;
    }
}
