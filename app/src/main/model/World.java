package main.model;

import java.util.List;
import main.model.gameObjects.Brick;
import main.controllers.state.event.WorldEventListener;

//TODO: Implement multiball.

public interface World {

    void setEventListener(final WorldEventListener listener);

    void updateGame(final int elapsed);

    void checkCollision();

    void checkBoundary();

    List<Brick> getBricks();
}
