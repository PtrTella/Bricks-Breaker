package main.model.gameObjects.bounding;

import main.common.P2d;

public class CircleBoundingBox implements BoundingBox{

    private P2d pos;
    private Double radius;

    @Override
    public P2d getP2d() {
        return this.pos;
    }

    @Override
    public void setP2d(P2d pos) {
        this.pos = pos;
    }

    public Double getRadius() {
        return this.radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }
    
}
