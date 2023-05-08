package brickbreaker.controllers.state.event;

import java.util.LinkedList;
import java.util.List;

import brickbreaker.model.GameState;

public class WorldEventListenerImpl implements WorldEventListener {

    private GameState state;
    private List<HitObjects> worldEvents;

    public WorldEventListenerImpl() {
        this.worldEvents = new LinkedList<HitObjects>();
    }

    @Override
    public void notifyEvent(HitObjects event) {
        this.worldEvents.add(event);
    }

    @Override
    public List<HitObjects> getWorldEventsList() {
        return this.worldEvents;
    }

    @Override
    public void processAll() {
        this.worldEvents.stream().forEach(event -> event.process(state));
        this.worldEvents.clear();
    }

    @Override
    public void setGameState(GameState currentState) {
        this.state = currentState;
    }

    @Override
    public GameState getGameState() {
        return this.state;
    }
    
}
