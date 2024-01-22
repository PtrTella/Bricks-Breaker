package brickbreaker.controllers;

import brickbreaker.controllers.listener.ErrorListener;
import javafx.animation.AnimationTimer;

/**
 * The abstract controller to relater with the other controllers.
 */
public abstract class AbstractController extends AnimationTimer {

    private UserController userController;
    private ErrorListener errListener;
    private InputController inputController;
    private LevelController levelController;
    private RankController rankController;

    /**
     * Abstract constructor.
     */
    public AbstractController() {
        this.userController = new UserController();
        this.errListener = new ErrorListener();
        this.inputController = new InputController();
        this.levelController = new LevelController();
        this.rankController = new RankController();
    }

    /**
     * @return a UserController
     */
    public UserController getUserController() {
        return this.userController; 
    }

    /**
     * @return an InputController
     */
    public InputController getInputController() {
        return this.inputController;
    }

    /**
     * @return an ErrorListener
     */
    public ErrorListener getErrorListener() {
        return this.errListener;
    }

    /**
     * @return a LevelController
     */
    public LevelController getLevelController() {
        return this.levelController;
    }

    /**
     * @return a RankController
     */
    public RankController getRankController() {
        return this.rankController;
    }

}
