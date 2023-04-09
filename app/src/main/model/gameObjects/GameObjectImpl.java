package main.model.gameObjects;

import main.common.*;
import main.model.gameObjects.bounding.BoundingBox;

public abstract class GameObjectImpl implements GameObject {

    private int lifes;
    private TypeObj type;
	private V2d vel;
    private BoundingBox box;

    public GameObjectImpl(final int lifesToSet, final TypeObj typeToSet, final BoundingBox box) {
        this.vel = new V2d(0, 0);
		this.type = typeToSet;
        this.lifes = lifesToSet;
        this.box = box;
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

    public P2d getPosition() {
        return this.box.getP2d();
    }

    public void setPosition(final P2d newPosition) {
        this.box.setP2d(newPosition);
    }
    
    public BoundingBox getBBox() {
        return this.box;
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

    public abstract void update(final long elapsed);
}
