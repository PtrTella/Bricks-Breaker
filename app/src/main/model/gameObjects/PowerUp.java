package main.model.gameObjects;

import main.common.P2d;
import main.common.V2d;
import main.model.WorldImpl;
import main.model.gameObjects.bounding.RectBoundingBox;

public class PowerUp extends GameObjectImpl<RectBoundingBox>{
    
    private final static Double POWERUP_WIDTH = 1.5;
    private final static Double POWERUP_HEIGHT = 0.8;
    private final TypePower powerUp;

    public PowerUp(final P2d pos, final TypePower powerToSet) {
        super(1,new V2d(0, -5), WorldImpl.TypeObj.POWERUP, new RectBoundingBox(pos,POWERUP_WIDTH,POWERUP_HEIGHT));     //TODO: adapt falling speed
        this.powerUp = powerToSet;
    }

    public TypePower getPowerUp() {
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
