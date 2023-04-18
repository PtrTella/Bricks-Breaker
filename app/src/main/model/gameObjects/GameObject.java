package main.model.gameObjects;

import main.common.*;
import main.model.WorldImpl.TypeObj;

public interface GameObject<T> {

    int getLife();
    
    void decLife();

    void incLife();

    TypeObj getType();

    V2d getSpeed();

    void setSpeed(final V2d speed);

    T getBBox();
}