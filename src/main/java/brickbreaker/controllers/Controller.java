package brickbreaker.controllers;

import brickbreaker.model.GameState;
import brickbreaker.view.View;

public interface Controller {

    void setModel(final GameState modelToAttach);

    GameState getModel();

    void setView(final View viewToAttach);

    View getView();

    void init();
}