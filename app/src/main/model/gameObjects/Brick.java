package main.model.gameObjects;

import main.common.P2d;
import main.common.V2d;

public class Brick extends GameObjectImpl{
    
    private int life;
    private TypePower powerUp;

    public Brick(P2d pos, int lifeToSet, TypePower powerToSet) {
        super(pos, new V2d(0, 0), TypeObj.BRICK);
        this.life = lifeToSet;
        this.powerUp = powerToSet;
    }

    public int decLife(){
        return life-1;
    }

    public TypePower getPower(){
        return this.powerUp;
    }

    @Override
    public void update(long dt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
