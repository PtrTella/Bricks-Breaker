package main.model.gameObjects;

import main.common.*;
import main.model.BoundingBox;

public abstract class GameObjectImpl implements GameObject {

    private Type type;
	private P2d pos;
	private V2d vel;
	private BoundingBox bbox;
	private int lifes;

    public GameObjectImpl(final P2d pos, final V2d vel, final int lifesToSet){
		this.pos = pos;
		this.vel = vel;
		this.lifes = lifesToSet;
	}

	public int getLifes() {
		return this.lifes;
	}

	public void setLifes(final int lifesToSet) {
		this.lifes = lifesToSet;
	}

    public Type getType() {
        return type;
    }

	public void setType(final Type typeToSet) {
		this.type = typeToSet;
	}

    public P2d getPosition() {
        return pos;
    }

	public void setPosition(final P2d pos){
		this.pos = pos;
	}

    public V2d getSpeed() {
        return vel;
    }

	public void setSpeed(final V2d vel){
		this.vel = vel;
	}

    public BoundingBox getBoundingBox(){
		return bbox;
	}

	public void setBoundingBox(final BoundingBox boxToSet) {
		this.bbox = boxToSet;
	}

	public void flipVelOnY(){
		this.vel = new V2d(vel.x, -vel.y);
	}

	public void flipVelOnX(){
		this.vel = new V2d(-vel.x, vel.y);
	}

	public abstract void update(final long dt);
}
