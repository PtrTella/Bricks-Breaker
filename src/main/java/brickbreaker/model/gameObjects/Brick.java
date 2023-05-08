package brickbreaker.model.gameObjects;

import brickbreaker.common.P2d;
import brickbreaker.common.TypeObj;
import brickbreaker.common.V2d;
import brickbreaker.model.gameObjects.bounding.RectBoundingBox;
import brickbreaker.model.gameObjects.power.TypePower;

public class Brick extends GameObjectImpl<RectBoundingBox>{

    private final static Double BRICK_WIDTH = 2.0;
    private final static Double BRICK_HEIGHT = 1.0;
    private TypePower powerUp;

    public Brick(final P2d pos, final int lifeToSet) {
        super(lifeToSet, new V2d(0, 0), TypeObj.BRICK, new RectBoundingBox(pos, BRICK_WIDTH, BRICK_HEIGHT));
        this.powerUp = TypePower.NULL;
    }

    public void setPowerUp(TypePower powerUpToSet) {
        this.powerUp = powerUpToSet;
    }

    public TypePower getPowerUp(){
        return this.powerUp;
    }

}
