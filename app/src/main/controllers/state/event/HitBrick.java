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
            Double uly = Math.abs(ul.vertDist(bpoint));
            if( (ul.getX() > bpoint.getX() && uly < Math.abs(ul.orizDist(bpoint))) ||
                (br.getX() < bpoint.getX() && uly < Math.abs(br.orizDist(bpoint)))
            ){
                ball.flipVelOnX();
            }else{
                ball.flipVelOnY();
            }
        }else if( br.getY() < bpoint.getY() ){
            Double bry = Math.abs(br.vertDist(bpoint));
            if( (ul.getX() > bpoint.getX() && bry < Math.abs(ul.orizDist(bpoint))) ||
                (br.getX() < bpoint.getX() && bry < Math.abs(br.orizDist(bpoint)))
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
