package brickbreaker.controllers.state.event;

import brickbreaker.common.V2d;
import brickbreaker.model.GameState;
import brickbreaker.model.gameObjects.Ball;
import brickbreaker.model.gameObjects.Bar;

public class HitBar implements HitObjects {

    private Ball ball;

    public HitBar(Ball ball) {
        this.ball = ball;
    }

    @Override
    public void process(GameState currentGame) {
        Bar bar = currentGame.getWorld().getBar();
        
        if(bar.getBBox().getULCorner().getY() > ball.getPosition().getY()){
            ball.flipVelOnY();
            ball.setSpeed(new V2d(bar.getPosition().orizDist(ball.getPosition()), ball.getSpeed().getY()));
        }
        
    }
    
}
