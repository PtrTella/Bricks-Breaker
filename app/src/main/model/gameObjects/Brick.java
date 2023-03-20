package main.model.gameObjects;

import main.common.P2d;
import main.common.V2d;
import main.model.BoundingBox;

public class Brick extends GameObjectImpl {

    private int life;
    private int powerUp;    // contiene il valore del powerup nella enum (0 se assente)

    public Brick(Type type, P2d pos, V2d vel, BoundingBox box, int life, int powerUp) {
        super(type, pos, vel, box);
        this.life = life;
        this.powerUp = powerUp;
    }

    @Override
    public void update(long dt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
