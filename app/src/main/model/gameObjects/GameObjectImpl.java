package main.model.gameObjects;

import main.common.*;

public abstract class GameObjectImpl implements GameObject{
    
    public static enum Type { BALL, BRICK, BAR, POWERUP }

    private Type type;
	private Image skin;
	private P2d pos;
	private V2d vel;
	private BoundingBox bbox;

    public GameObject(final Type type, final P2d pos, final V2d vel, final BoundingBox box){
		this.type = type;
		this.pos = pos;
		this.vel = vel;
		this.bbox = box;
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

	public void update(final long dt) {

	}
}
