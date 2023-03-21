package main.model.gameObjects;

import main.common.*;
import main.model.gameObjects.bounding.BoundingBox;

public interface GameObject {

    TypeObj getType();

    void setType(final TypeObj typeToSet);

    P2d getPosition();

    void setPosition(final P2d newPosition);

    V2d getSpeed();

    void setSpeed(final V2d speed);

    BoundingBox getBoundingBox();

    void setBoundingBox(final BoundingBox bbox);
}