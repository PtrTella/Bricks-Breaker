package main.model.gameObjects.bounding;

import javafx.geometry.Rectangle2D;

public abstract class BoundingBoxImpl implements BoundingBox {
    
    private Rectangle2D collider;

    public Rectangle2D getCollider() {
        return this.collider;
    }

    public boolean isCollidingWith(final BoundingBoxImpl boxToCheck) {
        Rectangle2D colliderToCheck = boxToCheck.getCollider();
        return this.collider.intersects(colliderToCheck);
    }
}