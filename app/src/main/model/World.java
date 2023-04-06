package main.model;

import main.model.gameObjects.Ball;
import main.model.gameObjects.Bar;
import main.model.gameObjects.Brick;
import main.controllers.state.event.WorldEventListener;

public interface World {

    void setEventListener(final WorldEventListener listener);

    void addBall(Ball ball);    // in addition to the first one created in the constructor
    void removeBall(Ball ball);
    Integer getNumBalls(); // returns the number of balls

    Bar getBar();   // only get because set in constructor

    void removeBrick(Brick brick);   // create a power Up in its place
    Integer getNumBricks(); // returns the number of bricks

    void updateGame(final int elapsed);

    void checkCollision();
}
