package brickbreaker.view;

import javafx.stage.Stage;
import brickbreaker.controllers.Controller;

/**
 * Implements the {@link View} interface.
 */
public abstract class ViewImpl implements View {

    private Stage currentStage;
    private Controller controller;

    /**
     * Method to get the current stage.
     * 
     * @return the current stage
     */
    public Stage getStage() {
        return this.currentStage;
    }

    /**
     * Method to set the current stage.
     * 
     * @param stageToSet the stage to set
     */
    public void setStage(final Stage stageToSet) {
        stageToSet.setOnCloseRequest(event -> {
            this.controller.getUserController().saveUsers();
            this.controller.getRankController().saveRanks();
            System.exit(0);
        });
        this.currentStage = stageToSet;
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void setController(final Controller controllerToAttach) {
        this.controller = controllerToAttach;
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public Controller getController() {
        return this.controller;
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public abstract void init();
}
