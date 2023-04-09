package main.model.gameObjects.bounding;

import main.common.P2d;

public interface BoundingBox {
    
    P2d getP2d();
    
    void setP2d(final P2d pos);

    boolean isCollidingWith(final BoundingBox boxToCheck);
}
