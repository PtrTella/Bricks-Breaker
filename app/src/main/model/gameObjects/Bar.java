package main.model.gameObjects;

import main.common.*;
import main.model.gameObjects.bounding.RectBoundingBox;

public class Bar extends GameObjectImpl{

    public Bar(final P2d p, final Double w, final Double h, final V2d s) {
        super(1, TypeObj.BAR, new RectBoundingBox(p, w, h));  // TODO change vel of bar
    }

    @Override
    public void update(long elapsed) {
        
    }
    
}
