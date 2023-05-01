package main.controllers.state;

import main.controllers.Controller;

/**
 * This interface defines the game state controller.
 */
public interface GameStateController extends Controller {

    /**
     * This method closes the game.
     */
    void quitGame();

    /**
     * This method pauses the current game.
     */
    void pauseGame();

    /**
     * This method gets the current game score.
     * @return an integer value that represents the score.
     */
    int getScore();
}
