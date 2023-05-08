package brickbreaker.controllers.state.event;

import brickbreaker.common.P2d;
import brickbreaker.model.GameState;
import brickbreaker.model.World;
import brickbreaker.model.WorldImpl.SideCollision;
import brickbreaker.model.gameObjects.Ball;

public class HitBorder implements HitObjects {

    private Ball ball;
    private SideCollision side;
    private Double newPos;

    public HitBorder(Ball ball, SideCollision side, Double pos) {
        this.ball = ball;
        this.side = side;
        this.newPos = pos;
    }

    @Override
    public void process(GameState currentGame) {
        
        switch(this.side){
            case TOP:
                ball.setPosition(new P2d(ball.getPosition().getX(), newPos + ball.getRadius()));
                ball.flipVelOnY();
                break;
            case BOTTOM:
                World w = currentGame.getWorld();
                w.removeBall(ball);
                if(w.getBalls().size() <= 0){
                    w.getBar().decLife();
                }
                break;
            case LEFT:
                ball.setPosition(new P2d(newPos + ball.getRadius(), ball.getPosition().getY()));
                ball.flipVelOnX();
                break;
            case RIGHT:
                ball.setPosition(new P2d(newPos - ball.getRadius(), ball.getPosition().getY()));
                ball.flipVelOnX();
                break;
        }
    }
    
}
