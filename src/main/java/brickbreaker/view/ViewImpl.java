package brickbreaker.view;

import brickbreaker.controllers.Controller;

public abstract class ViewImpl implements View {

    private Controller currentController;

    public ViewImpl(final Controller controllerToAttach) {
        this.setController(controllerToAttach);
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void setController(final Controller controllerToAttach) {
        this.currentController = controllerToAttach;
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public Controller getController() {
        return this.currentController;
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public abstract void init();
}
