package main.model.gameObjects.bounding;

import main.common.geometry.Rectangle2D;

public interface BoundingBox {

    public Rectangle2D getCollider();

    public boolean isCollidingWith(final BoundingBox boxToCheck);
}