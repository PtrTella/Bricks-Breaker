package main.controllers;

import main.model.GameState;

public interface Controller {

    void setModel(final GameState state);

    GameState getState();

    void init();
}