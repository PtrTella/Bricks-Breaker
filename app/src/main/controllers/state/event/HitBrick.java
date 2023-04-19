package main.controllers.state.event;

import main.common.P2d;
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

        P2d ul = hittedBrick.getBBox().getULCorner();
        P2d br = hittedBrick.getBBox().getBRCorner();
        P2d bpoint = ball.getPosition();

        if( ul.getY() > bpoint.getY() ){
            if( (ul.getX() > bpoint.getX() && ul.vertDist(bpoint.getY()) < ul.orizDist(bpoint.getX())) ||
                (br.getX() < bpoint.getX() && ul.vertDist(bpoint.getY()) < br.orizDist(bpoint.getX()))
            ){
                ball.flipVelOnX();
            }else{
                ball.flipVelOnY();
            }
        }else if( br.getY() < bpoint.getY() ){
            if( (ul.getX() > bpoint.getX() && br.vertDist(bpoint.getY()) < ul.orizDist(bpoint.getX())) ||
                (br.getX() < bpoint.getX() && br.vertDist(bpoint.getY()) < br.orizDist(bpoint.getX()))
            ){
                ball.flipVelOnX();
            }else{
                ball.flipVelOnY();
            }
        }else {
            ball.flipVelOnX();
        }
    }
    
}
