package main.model.gameObjects;

import main.common.*;
import main.model.gameObjects.bounding.BoundingBox;

public interface GameObject {

    int getLifes();

    void setLifes(final int lifesToSet);

    Type getType();

    void setType(final Type typeToSet);

    P2d getPosition();

    void setPosition(final P2d newPosition);

    V2d getSpeed();

    void setSpeed(final V2d speed);

    BoundingBox getBoundingBox();

    void setBoundingBox(final BoundingBox bbox);
}