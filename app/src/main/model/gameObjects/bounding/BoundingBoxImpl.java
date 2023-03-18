package model.main.gameObjects.bounding;

import javafx.geometry.Rectangle2D;

public abstract BoundingBoxImpl implements BoundingBox {

    //TODO is this object better than the one provided by javafx ? Let's check. 
    private Rectangle2D collider;

    public Rectangle2D getCollider() {
        return this.collider;
    }

    public boolean isCollidingWith(final BoundingBoxImpl boxToCheck) {
        Rectangle2D colliderToCheck = boxToCheck.getCollider();
        return this.collider.intersects(colliderToCheck);
    }
}