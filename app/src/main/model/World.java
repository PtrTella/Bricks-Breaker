package main.model;

import java.util.List;

import main.model.gameObjects.Ball;
import main.model.gameObjects.Bar;
import main.model.gameObjects.Brick;
import main.model.gameObjects.PowerUp;
import main.controllers.state.event.WorldEventListener;

public interface World {

    void setEventListener(final WorldEventListener listener);

    void addBall(Ball ball);
    void removeBall(Ball ball);
    List<Ball> getBalls();

    void setBar(Bar barToSet);
    Bar getBar();

    void setBricks(List<Brick> brickToSet);
    void removeBrick(Brick brick);
    List<Brick> getBricks();

    void setPowerUps(List<PowerUp> powerUpToSet);
    void removePowerUp(PowerUp powerUp);
    List<PowerUp> getPowerUps();

    void updateGame(final int elapsed);

    void checkCollision();

    void checkBoundary();
}
