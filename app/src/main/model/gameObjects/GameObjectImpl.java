package main.model.gameObjects;

import main.common.*;

public abstract class GameObjectImpl implements GameObject {

    private TypeObj type;
	private V2d vel;

    public GameObjectImpl(final V2d vel, final TypeObj typeToSet) {
		this.vel = vel;
		this.type = typeToSet;
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
