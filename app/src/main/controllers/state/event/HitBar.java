package main.controllers.state.event;

import main.common.V2d;
import main.model.GameState;
import main.model.gameObjects.Ball;
import main.model.gameObjects.Bar;

public class HitBar implements HitObjects {

    private Ball ball;

    public HitBar(Ball ball){
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
