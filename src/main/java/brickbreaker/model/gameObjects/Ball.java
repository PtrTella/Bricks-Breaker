package brickbreaker.model.gameObjects;

import brickbreaker.common.P2d;
import brickbreaker.common.TypeObj;
import brickbreaker.common.V2d;
import brickbreaker.model.gameObjects.bounding.CircleBoundingBox;

public class Ball extends GameObjectImpl<CircleBoundingBox> {

    private static final Double RADIUS = 1.0;

	public Ball(final P2d center, final V2d vel){
		super(1,vel, TypeObj.BALL, new CircleBoundingBox(center, RADIUS));
	}

    public Double getRadius() {
        return this.getBBox().getRad();
    }

	public void setRadius(final Double radius) {
		this.getBBox().setRadius(radius);
	}
    
	public void flipVelOnY(){
		this.setSpeed(new V2d(this.getSpeed().getX(), -this.getSpeed().getY()));
	}
	public void flipVelOnX(){
		this.setSpeed(new V2d(-this.getSpeed().getX(), this.getSpeed().getY()));
	}
}
