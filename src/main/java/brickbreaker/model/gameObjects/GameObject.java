package brickbreaker.model.gameObjects;

import brickbreaker.common.P2d;
import brickbreaker.common.TypeObj;
import brickbreaker.common.V2d;

public interface GameObject<T> {

    int getLife();
    
    void decLife();

    void incLife();

    TypeObj getType();

    P2d getPosition();

    void setPosition(final P2d newPosition);

    V2d getSpeed();

    void setSpeed(final V2d speed);

    T getBBox();
}