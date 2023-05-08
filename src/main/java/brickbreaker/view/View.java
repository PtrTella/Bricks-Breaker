package brickbreaker.view;

import brickbreaker.controllers.Controller;
import javafx.stage.Stage;

/**
 * This is a generic view implementation.
 */
public interface View {

    /**
     * This method initializes the view.
     */
    void init();

    /**
     * This method gets the current attached controller.
     * @return the current attached Controller object.
     */
    Controller getController();

    /**
     * This method sets the view's controller to the one passed as parameter.
     * @param controllerToAttach a Controller object which will be attached to
     * the current view.
     */
    void setController(final Controller controllerToAttach);

    Stage getStage();

    void setStage(final Stage stageToSet);
}