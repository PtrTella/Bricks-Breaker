package main.model.gameObjects.bounding;

import main.common.P2d;

public interface BoundingBox {
    
    P2d getPos();

	void setPos(final P2d pos);

    <T> boolean isCollidingWith(BoundingBox obj);

}
