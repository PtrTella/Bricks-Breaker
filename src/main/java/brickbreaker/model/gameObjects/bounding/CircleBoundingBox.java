package brickbreaker.model.gameObjects.bounding;

import brickbreaker.common.P2d;

public class CircleBoundingBox implements BoundingBox{

    private P2d pos;
    private Double radius;

    public CircleBoundingBox(P2d pos, Double radius){
        this.pos = pos;
        this.radius = radius;
    }

    @Override
    public P2d getP2d() {
        return this.pos;
    }

    @Override
    public void setP2d(P2d pos) {
        this.pos = pos;
    }

    public Double getRad() {
        return this.radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public boolean isCollidingWith(BoundingBox obj) {
        return false;
    }
    
}
