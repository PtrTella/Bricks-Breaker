package main.controllers;

import main.model.GameState;
import main.view.View;

public interface Controller {

    void setModel(final GameState modelToAttach);

    GameState getModel();

    void setView(final View viewToAttach);

    View getView();

    void init();
}