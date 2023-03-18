package main.controllers;

import main.model.GameState;

public interface Controller {

    void setModel(final GameState modelToAttach);

    GameState getState();

    void setView(final View viewToAttach);

    View getView();

    void init();
}