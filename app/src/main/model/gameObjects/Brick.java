package main.model.gameObjects;

import main.common.P2d;
import main.model.gameObjects.bounding.RectBoundingBox;

public class Brick extends GameObjectImpl{

    private final TypePower powerUp;

    public Brick(final int lifes, final P2d pos, final Double width, final Double height, final TypePower powerToSet) {
        super(lifes, TypeObj.BRICK, new RectBoundingBox(pos, width, height));
        this.powerUp = powerToSet;
    }

    public TypePower getPowerUp(){
        return this.powerUp;
    }

    @Override
    public void update(long elapsed) {

    }
}
