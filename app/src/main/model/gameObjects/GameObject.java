package main.model.gameObjects;

import main.common.*;
import main.model.WorldImpl.TypeObj;

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