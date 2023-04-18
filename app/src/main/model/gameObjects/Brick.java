package main.model.gameObjects;

import main.common.P2d;
import main.common.V2d;
import main.model.WorldImpl;
import main.model.gameObjects.bounding.RectBoundingBox;

public class Brick extends GameObjectImpl<RectBoundingBox>{

    private final static Double BRICK_WIDTH = 2.0;
    private final static Double BRICK_HEIGHT = 1.0;
    private TypePower powerUp;

    public Brick(final P2d pos, final int lifeToSet) {
        super(lifeToSet, new V2d(0, 0), WorldImpl.TypeObj.BRICK, new RectBoundingBox(pos, BRICK_WIDTH, BRICK_HEIGHT));
        this.powerUp = TypePower.NULL;
    }

    public void setPowerUp(TypePower powerUpToSet) {
        this.powerUp = powerUpToSet;
    }

    public TypePower getPowerUp(){
        return this.powerUp;
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
