package model.main.gameObjects.bounding;

//TODO Add a rectangle2D (javafx).

public abstract BoundingBoxImpl implements BoundingBox{

    public boolean isCollidingWith(final BoundingBoxImpl boxToCheck) {
        return false;
    }
}