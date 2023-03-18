package main.controllers.state.event;

import main.model.GameState;

public interface WorldEvent {
    void process(GameState currentGame);    
}
