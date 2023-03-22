package main.model.gameObjects;

import main.common.P2d;
import main.common.V2d;

public class PowerUp extends GameObjectImpl{
    
    private final TypePower powerUp;

    public PowerUp(P2d pos, TypePower powerToSet) {
        super(pos, new V2d(0, 5), TypeObj.POWERUP);     //TODO: adapt falling speed
        this.powerUp = powerToSet;
    }

    @Override
    public void update(long dt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
}
