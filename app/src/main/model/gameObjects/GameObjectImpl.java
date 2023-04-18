package main.model.gameObjects;

import main.common.*;
import main.model.WorldImpl.TypeObj;

public abstract class GameObjectImpl<T> implements GameObject<T> {

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

    public V2d getSpeed() {
        return vel;
    }

	public void setSpeed(final V2d vel){
		this.vel = vel;
	}
    
    @Override
    public T getBBox() {
        return this.bbox;
    }

}
