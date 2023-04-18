package main.model.gameObjects;

import main.common.*;
import main.model.WorldImpl.TypeObj;
import main.model.gameObjects.bounding.BoundingBox;

public interface GameObject {

    void decLife();

    void incLife();

    int getLife();

    TypeObj getType();

    P2d getPosition();

    void setPosition(final P2d newPosition);

    V2d getSpeed();

    void setSpeed(final V2d speed);

    BoundingBox getBBox();
}