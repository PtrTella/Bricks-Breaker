package main.controllers;

import main.model.GameState;
import main.view.View;

public abstract class ControllerImpl implements Controller{

    private GameState model;
    private View view;

    public abstract void init();

    public void setModel(final GameState modelToAttach) {
        this.model = modelToAttach;
    }

    public GameState getModel() {
        return this.model;
    }

    public void setView(final View viewToAttach) {
        this.view = viewToAttach;
    }

    public View getView() {
        return this.view;
    }
}
