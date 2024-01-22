package brickbreaker.view;

import brickbreaker.common.GameImages;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Implementation of {@link View} for the home menu.
 */
public class HomeView extends ViewImpl {

    @FXML
    private AnchorPane root;

    @FXML
    private VBox vbAnchor;

    @FXML
    private HBox hBTitle;

    @FXML
    private VBox vbButtons;

    @FXML
    private ImageView imgTitle;

    @FXML
    private ImageView imgLevel;

    @FXML
    private ImageView imgEndless;

    @FXML
    private ImageView imgLeaderboards;

    @FXML
    private ImageView imgBack;

    /**
     * {@inheritDoc}
     */
    @Override
    public void init() {

        this.imgTitle.setImage(GameImages.TITLE.getImage());
        this.imgLevel.setImage(GameImages.LEVELS_MODE_CHOICE.getImage());
        this.imgEndless.setImage(GameImages.ENDLESS_MODE_CHOICE.getImage());
        this.imgLeaderboards.setImage(GameImages.LEADERBOARD_CHOICE.getImage());
        this.imgBack.setImage(GameImages.BACK_ARROW.getImage());
    }

    /**
     * Listener for the level button.
     * Redirects to the level menu.
     */
    public void switchToLevel() {
        ViewSwitcher.getInstance().switchView(getStage(), ViewType.LEVEL);
    }

    /**
     * Listener for the endless button.
     * Redirects to the difficulty menu.
     */
    public void switchToEndless() {
        ViewSwitcher.getInstance().switchView(getStage(), ViewType.DIFFICULTY);
    }

    /**
     * Listener for the leaderboards button.
     * Redirects to the leaderboards menu.
     */
    public void switchToLeaderboards() {
        ViewSwitcher.getInstance().switchView(getStage(), ViewType.RANK);
    }

    /**
     * Listener for the back button.
     * Redirects to the setup menu.
     */
    public void clickBack() {
        ViewSwitcher.getInstance().switchView(getStage(), ViewType.SETUP);
    }
}
