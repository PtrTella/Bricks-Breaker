package main.model.gameObjects.bounding;

public interface BoundingBox {
    
    public boolean isCollidingWith(final BoundingBox boxToCheck);
}