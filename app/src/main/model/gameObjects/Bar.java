package main.model.gameObjects;

import main.common.*;
import main.model.gameObjects.bounding.RectBoundingBox;

public class Bar extends GameObjectImpl{

    private RectBoundingBox bbox;

    public Bar(P2d pos, final Double widthToSet, final Double heightToSet, V2d vel) {
        super(vel, TypeObj.BAR);  // TODO change vel of bar
        this.bbox = new RectBoundingBox(pos, widthToSet, heightToSet);
    }

    @Override
    public P2d getPosition() {
        return bbox.getP2d();
    }
    
    @Override
    public void setPosition(P2d newPosition) {
        bbox.setP2d(newPosition);
    }
    
    @Override
    public RectBoundingBox getBBox() {
        return this.bbox;
    }
    
}
