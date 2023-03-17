package main.model;

import main.common.*;

public abstract class GameObject {
    
    public static enum Type { BALL, BRICK, BAR, POWERUP }

    private Type type;
	//private Color color;
	private P2d pos;
	private V2d vel;
	private BoundingBox bbox;

    public GameObject(Type type, P2d pos, V2d vel, BoundingBox box){
		this.type = type;
		this.pos = pos;
		this.vel = vel;
		this.bbox = box;
	}

    public Type getType() {
        return type;
    }

    public P2d getPos() {
        return pos;
    }

    public V2d getVel() {
        return vel;
    }

    public BoundingBox getBBox(){
		return bbox;
	}

    public void setPos(P2d pos){
		this.pos = pos;
	}

	public void setVel(V2d vel){
		this.vel = vel;
	}

	public void flipVelOnY(){
		this.vel = new V2d(vel.x, -vel.y);
	}

	public void flipVelOnX(){
		this.vel = new V2d(-vel.x, vel.y);
	}
}
