package main.model;

import java.util.List;
import main.model.gameObjects.Ball;
import main.model.gameObjects.Brick;
import main.controllers.state.event.WorldEventListener;

public interface World {

    void setEventListener(final WorldEventListener listener);

    void updateGame(final int elapsed);

    void checkCollision();

    void checkRespawn();

    void checkBoundary();

    List<Brick> getBricks();

    List<Ball> getBalls();
}
