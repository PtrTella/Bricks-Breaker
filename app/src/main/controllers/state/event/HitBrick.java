package main.controllers.state.event;

import main.model.GameState;
import main.model.gameObjects.Ball;
import main.model.gameObjects.Brick;

public class HitBrick implements HitObjects {

    private Brick hittedBrick;
    private Ball ball;

    public HitBrick(Brick hitted, Ball ball) {
        this.hittedBrick = hitted;
        this.ball = ball;
    }

    @Override
    public void process(GameState currentGame) {
        this.hittedBrick.decLife();

        if (this.hittedBrick.getLife() <= 0) {
            currentGame.getWorld().removeBrick(this.hittedBrick);
        }

        if( hittedBrick.getBBox().getULCorner().getY() > ball.getPosition().getY() && 
            hittedBrick.getBBox().getBRCorner().getY() < ball.getPosition().getY() ){
            ball.flipVelOnX();
        }else{
            ball.flipVelOnY();
        }
    }
    
}
