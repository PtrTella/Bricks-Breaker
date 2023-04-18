package main.model.gameObjects;

import main.common.*;
import main.model.WorldImpl;
import main.model.gameObjects.bounding.RectBoundingBox;

public class Bar extends GameObjectImpl<RectBoundingBox>{

    private static final Double BAR_WIDTH = 5.0;
    private static final Double BAR_HEIGHT = 1.0;

    public Bar(P2d pos, V2d vel, final Integer lifeToset) {
        super(lifeToset, vel, WorldImpl.TypeObj.BAR, new RectBoundingBox(pos, BAR_WIDTH, BAR_HEIGHT));  // TODO change vel of bar
    }

    @Override
    public P2d getPosition() {
        return this.getBBox().getP2d();
    }
    
    @Override
    public void setPosition(P2d newPosition) {
        this.getBBox().setP2d(newPosition);
    }
    
}
