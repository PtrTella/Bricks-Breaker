package main.model;

import main.common.P2d;
import main.common.V2d;

public class Brick extends GameObject {

    private int life;
    private int powerUp;    // contiene il valore del powerup nella enum (0 se assente)

    public Brick(Type type, P2d pos, V2d vel, BoundingBox box, int life, int powerUp) {
        super(type, pos, vel, box);
        this.life = life;
        this.powerUp = powerUp;
    }
    
}
