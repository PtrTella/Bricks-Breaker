package brickbreaker.model.gameObjects;

import brickbreaker.common.P2d;
import brickbreaker.common.TypeObj;
import brickbreaker.common.V2d;
import brickbreaker.model.gameObjects.bounding.BoundingBox;

/**
 *  Abstract base class for all objects
 */
public abstract class GameObjectImpl<T extends BoundingBox> implements GameObject<T> {

    private Integer lifes;
    private TypeObj type;
	private V2d vel;
    private T bbox;

    public GameObjectImpl(final Integer lifesToSet, final V2d vel, final TypeObj typeToSet, final T bboxToSet) {
		this.vel = vel;
		this.type = typeToSet;
        this.lifes = lifesToSet;
        this.bbox = bboxToSet;
	}

    @Override
    public int getLife() {
        return this.lifes;
    }

    @Override
    public void decLife() {
        this.lifes--;
    }

    @Override
    public void incLife() {
        this.lifes++;
    }
    
    @Override
    public TypeObj getType() {
        return type;
    }

    
    @Override
    public P2d getPosition() {
        return this.bbox.getP2d();
    }

    @Override
    public void setPosition(P2d newPosition) {
        this.bbox.setP2d(newPosition);
    }

    @Override
    public V2d getSpeed() {
        return vel;
    }

    @Override
	public void setSpeed(final V2d vel){
		this.vel = vel;
	}
    
    @Override
    public T getBBox() {
        return this.bbox;
    }

}
