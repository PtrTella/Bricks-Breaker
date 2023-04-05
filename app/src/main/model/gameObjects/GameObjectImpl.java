package main.model.gameObjects;

import main.common.*;

public abstract class GameObjectImpl implements GameObject {

    private Integer lifes;
    private TypeObj type;
	private V2d vel;

    public GameObjectImpl(final Integer lifesToSet, final V2d vel, final TypeObj typeToSet) {
		this.vel = vel;
		this.type = typeToSet;
        this.lifes = lifesToSet;
	}

    public int getLife() {
        return this.lifes;
    }

    public void decLife() {
        this.lifes--;
    }

    public void incLife() {
        this.lifes++;
    }
    public TypeObj getType() {
        return type;
    }

    public V2d getSpeed() {
        return vel;
    }

	public void setSpeed(final V2d vel){
		this.vel = vel;
	}
}
