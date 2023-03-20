package main.model;

import main.controllers.state.event.WorldEventListener;

public interface World {

    void setEventListener(final WorldEventListener listener);

    void updateGame(final int elapsed);

    void checkCollision();

    void checkRespawn();

    void checkBoundary();
}
