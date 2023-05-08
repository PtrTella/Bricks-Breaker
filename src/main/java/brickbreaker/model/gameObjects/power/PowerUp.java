package brickbreaker.model.gameObjects.power;

import brickbreaker.common.P2d;
import brickbreaker.common.TypeObj;
import brickbreaker.common.V2d;
import brickbreaker.model.gameObjects.GameObjectImpl;
import brickbreaker.model.gameObjects.bounding.RectBoundingBox;

public class PowerUp extends GameObjectImpl<RectBoundingBox>{
    
    private final static Double POWERUP_WIDTH = 1.5;
    private final static Double POWERUP_HEIGHT = 0.8;
    private final static Double POWERUP_FALLING = -5.0; //TODO: adapt falling speed
    private final TypePower powerUp;

    public PowerUp(final P2d pos, final TypePower powerToSet) {
        super(1,new V2d(0, POWERUP_FALLING), TypeObj.POWERUP, new RectBoundingBox(pos,POWERUP_WIDTH,POWERUP_HEIGHT));
        this.powerUp = powerToSet;
    }

    public TypePower getPowerUp() {
        return this.powerUp;
    }

    public Double getHeight(){
        return this.getBBox().getHeight();
    }
}
