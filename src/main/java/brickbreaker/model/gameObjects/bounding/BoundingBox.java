package brickbreaker.model.gameObjects.bounding;

import brickbreaker.common.P2d;

public interface BoundingBox {

    P2d getP2d();

	void setP2d(final P2d pos);

    boolean isCollidingWith(BoundingBox obj);

}
