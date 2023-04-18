package main.model.gameObjects;

import main.common.*;
import main.model.WorldImpl;
import main.model.gameObjects.bounding.CircleBoundingBox;

public class Ball extends GameObjectImpl<CircleBoundingBox> {

    private static final Double RADIUS = 1.0;

	public Ball(final P2d center, final V2d vel){
		super(1,vel, WorldImpl.TypeObj.BALL, new CircleBoundingBox(center, RADIUS));
	}
    
	public void flipVelOnY(){
		this.setSpeed(new V2d(this.getSpeed().getX(), -this.getSpeed().getY()));
	}
	public void flipVelOnX(){
		this.setSpeed(new V2d(-this.getSpeed().getX(), this.getSpeed().getY()));
	}
}
