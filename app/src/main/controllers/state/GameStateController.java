package main.controllers.state;

import main.controllers.Controller;

public interface GameStateController extends Controller {

    void processCommands();

    void processEvents();

    void render();

    void updateGame(final int elapsed);

    void quitGame();

    void pauseGame();
}
