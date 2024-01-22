package brickbreaker.view;

import brickbreaker.common.GameImages;
import brickbreaker.common.Mode;
import brickbreaker.common.State;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * Implementation of {@link View} for the end game menu.
 */
public class EndGameView extends ViewImpl {

    @FXML
    private AnchorPane root;

    @FXML
    private VBox vbContainer;

    @FXML
    private ImageView imgStatus;

    @FXML
    private ImageView btnContinue;

    @FXML
    private ImageView btnQuit;

    /**
     * {@inheritDoc}
     */
    @Override
    public void init() {
        Image[] status = { GameImages.PLAYER_LOST.getImage(), GameImages.PLAYER_WIN.getImage() };

        Integer index;
        if (this.getController().getModel().getState() == State.LOST) {
            index = 0;
            this.btnContinue.setVisible(false);
        } else {
            index = 1;
        }

        this.imgStatus.setImage(status[index]);
        this.btnContinue.setImage(GameImages.CONTINUE.getImage());
        this.btnQuit.setImage(GameImages.QUIT.getImage());
    }

    /**
     * Listener for the continue button.
     * Redirects to the home menu if the game mode is endless, otherwise
     * it redirects to the next level if the player won, or to the same level
     * if the player lost.
     */
    public void clickContinue() {
        Mode m = this.getController().getMode();

        if (m.equals(Mode.ENDLESS)) {
            ViewSwitcher.getInstance().switchView(getStage(), ViewType.HOME);
        } else {
            if (this.getController().getModel().getState() == State.WIN) {
                if (this.getController().getLevelController().hasNextLevel()) {
                    // Next level
                    this.getController().getLevelController().nextLevel();
                    this.getController().setModel();
                    ViewSwitcher.getInstance().switchView(getStage(), ViewType.MATCH);
                } else {
                    // Lvels are over
                    ViewSwitcher.getInstance().switchView(getStage(), ViewType.HOME);
                }
            } else {
                // Lost
                this.getController().setModel();
                ViewSwitcher.getInstance().switchView(getStage(), ViewType.MATCH);
            }
        }
    }

    /**
     * Listener for the quit button.
     * Redirects to the home menu.
     */
    public void clickQuit() {
        ViewSwitcher.getInstance().switchView(getStage(), ViewType.HOME);
    }
}
