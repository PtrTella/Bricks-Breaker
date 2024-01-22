package brickbreaker.view;

import java.util.Optional;

import brickbreaker.common.Difficulty;
import brickbreaker.common.GameImages;
import brickbreaker.common.Mode;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Implementation of {@link View} for the difficulty menu.
 */
public class DifficultyMenuView extends ViewImpl {

    @FXML
    private AnchorPane root;

    @FXML
    private VBox vbLayout;

    @FXML
    private ImageView imgModeTitle;

    @FXML
    private HBox hbDifficulty;

    @FXML
    private ImageView imgDifficulty;

    @FXML
    private ImageView imgSelectedDifficulty;

    @FXML
    private VBox vbDifficultySelection;

    @FXML
    private ImageView imgUpArrow;

    @FXML
    private ImageView imgDownArrow;

    @FXML
    private ImageView imgReady;

    @FXML
    private ImageView imgBack;

    private Image[] imgDifficulties;
    private Integer difficultyIndex;

    /**
     * {@inheritDoc}
     */
    @Override
    public void init() {
        this.difficultyIndex = 0;
        this.imgDifficulties = new Image[4];

        this.imgDifficulty.setImage(GameImages.DIFFICULTY.getImage());
        this.imgModeTitle.setImage(GameImages.ENDLESS_MODE_TITLE.getImage());
        this.imgReady.setImage(GameImages.READY_TO_PLAY.getImage());
        this.imgUpArrow.setImage(GameImages.UP_ARROW.getImage());
        this.imgDownArrow.setImage(GameImages.DOWN_ARROW.getImage());
        this.imgBack.setImage(GameImages.BACK_ARROW.getImage());

        this.imgDifficulties[3] = GameImages.MIX_DIFFICULTY.getImage();
        this.imgDifficulties[0] = GameImages.EASY_DIFFICULTY.getImage();
        this.imgDifficulties[1] = GameImages.MEDIUM_DIFFICULTY.getImage();
        this.imgDifficulties[2] = GameImages.HARD_DIFFICULTY.getImage();

        this.imgSelectedDifficulty.setImage(this.imgDifficulties[0]);
    }

    /**
     * Choose the difficulty level.
     * 
     * @param up true if the difficulty level has to be increased, false otherwise
     */
    public void chooseDifficulty(final boolean up) {
        Integer d = up ? 1 : (difficultyIndex == 0 ? Difficulty.values().length - 1 : -1);
        this.difficultyIndex = (this.difficultyIndex + d) % Difficulty.values().length;
        this.imgSelectedDifficulty.setImage(this.imgDifficulties[this.difficultyIndex]);
    }

    /**
     * Listener for the up arrow to choose the difficulty level.
     */
    public void clickUpArrow() {
        chooseDifficulty(false);
    }

    /**
     * Listener for the down arrow to choose the difficulty level.
     */
    public void clickDownArrow() {
        chooseDifficulty(true);
    }

    /**
     * Listener for the play button to start the game.
     */
    public void clickPlayButton() {
        this.getController().getLevelController().setLevel(Optional.empty());
        this.getController().getLevelController().setDifficultyLevel(Difficulty.values()[this.difficultyIndex]);
        this.getController().setMode(Mode.ENDLESS);
        this.getController().setModel();
        ViewSwitcher.getInstance().switchView(getStage(), ViewType.MATCH);
    }

    /**
     * Listener for the back button to go back to the home menu.
     */
    public void clickBack() {
        ViewSwitcher.getInstance().switchView(getStage(), ViewType.HOME);
    }
}
