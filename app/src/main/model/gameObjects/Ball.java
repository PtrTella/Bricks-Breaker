package main.model.gameObjects;

import main.common.*;
import main.model.gameObjects.bounding.CircleBoundingBox;

public class Ball extends GameObjectImpl {

    private static final int DEFAULT_BALL_LIFE = 1;
	private static final double RADIUS = 10;

	public Ball(final P2d center, final Double radius, final V2d vel){
		super(Ball.DEFAULT_BALL_LIFE, TypeObj.BALL, new CircleBoundingBox(center, RADIUS));
	}
    
	public void flipVelOnY(){
		this.setSpeed(new V2d(this.getSpeed().getX(), -this.getSpeed().getY()));
	}

	public void flipVelOnX(){
		this.setSpeed(new V2d(-this.getSpeed().getX(), this.getSpeed().getY()));
	}

	@Override
	public void update(long elapsed) {
		V2d speed = this.getSpeed();
		P2d position = this.getPosition();


		position.setX(position.getX() + speed.getX());
		position.setY(position.getY() + speed.getY());

		this.setPosition(position);
	}
}
