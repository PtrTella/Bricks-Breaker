package main.controllers.state.event;

import main.common.P2d;
import main.model.GameState;
import main.model.World;
import main.model.WorldImpl.SideCollision;
import main.model.gameObjects.Ball;

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
                ball.setPosition(new P2d(ball.getPosition().getX(), newPos - ball.getRadius()));
                ball.flipVelOnY();
                break;
            case BOTTOM:
                World w = currentGame.getWorld();
                w.removeBall(ball);
                if(w.getNumBalls() <= 0){
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
