package main.controllers.state.event;

import java.util.List;

import main.model.GameState;

public interface WorldEventListener {

    void notifyEvent(HitObjects event);

    List<HitObjects> getWorldEventsList();

    void processAll();

    void setGameState(GameState currentState);

    GameState getGameState();
}
