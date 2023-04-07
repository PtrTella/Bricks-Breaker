package main.controllers.state.event;

import main.model.GameState;
import java.util.LinkedList;
import java.util.List;

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
