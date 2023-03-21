package main.model.gameObjects;

import main.common.P2d;
import main.common.V2d;

public class Brick extends GameObjectImpl{
    
    private int life;
    private TypePower powerUp;

    public Brick(P2d pos, V2d vel, int lifeToSet, TypePower powerToSet) {
        super(pos, vel, TypeObj.BRICK);
        this.life = lifeToSet;
        this.powerUp = powerToSet;
    }

    public int decLife(){
        return life-1;
    }

    public TypePower getPower(){
        return this.powerUp;
    }

}
