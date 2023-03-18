package main.model.gameObjects;

import main.common.*;
import main.model.BoundingBox;

public interface GameObject {

    public Type getType();

    public void setType(final Type typeToSet);

    public P2d getPosition();

    public void setPosition(final P2d newPosition);

    public V2d getSpeed();

    public void setSpeed(final V2d speed);

    public BoundingBox getBoundingBox();

    public void setBoundingBox(final BoundingBox bbox);
}