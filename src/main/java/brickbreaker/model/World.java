package brickbreaker.model;

import java.util.List;

import brickbreaker.controllers.state.event.WorldEventListener;
import brickbreaker.model.gameObjects.Ball;
import brickbreaker.model.gameObjects.Bar;
import brickbreaker.model.gameObjects.Brick;
import brickbreaker.model.gameObjects.bounding.RectBoundingBox;

public interface World {

    void setEventListener(final WorldEventListener listener);

    void addBall(Ball ball);    // in addition to the first one created in the constructor
    void removeBall(Ball ball);
    List<Ball> getBalls();

    Bar getBar();
    void setBar(Bar bar);

    void addBricks(List<Brick> bricks);
    void removeBrick(Brick brick);   // create a power Up in its place
    List<Brick> getBricks(); // returns a list of bricks

    RectBoundingBox getMainBBox();

    void updateGame(final int elapsed);

    void checkCollision();
}
