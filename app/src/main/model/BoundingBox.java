package main.model;

import main.common.P2d;

public interface BoundingBox {
    
    boolean isCollidingWith(P2d p, double radius);
}
