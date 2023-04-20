package main.model;

import main.model.gameObjects.Ball;
import main.model.gameObjects.Bar;
import main.model.gameObjects.Brick;

import java.util.List;

import main.controllers.state.event.WorldEventListener;

public interface World {

    void setEventListener(final WorldEventListener listener);

    void addBall(Ball ball);    // in addition to the first one created in the constructor
    void removeBall(Ball ball);
    Integer getNumBalls(); // returns the number of balls
    List<Ball> getBalls();

    Bar getBar();
    void setBar(Bar bar);

    void addBricks(List<Brick> bricks);
    void removeBrick(Brick brick);   // create a power Up in its place
    List<Brick> getBricks(); // returns a list of bricks

    void updateGame(final int elapsed);

    void checkCollision();
}
