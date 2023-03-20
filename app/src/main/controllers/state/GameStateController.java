package main.controllers.state;

import main.controllers.Controller;

/**
 * This interface defines the game state controller.
 */
public interface GameStateController extends Controller {

    /**
     * This method processes all the commands triggered by the user.
     */
    void processCommands();

    /**
     * This method processes all the world events.
     */
    void processEvents();

    /**
     * This method renders the attached view.
     */
    void render();

    /**
     * This method updates the current Game.
     * @param elapsed
     */
    void updateGame(final int elapsed);

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
