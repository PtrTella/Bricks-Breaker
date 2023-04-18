package main.controllers.state.event;

import main.common.P2d;
import main.model.GameState;
import main.model.WorldImpl.SideCollision;
import main.model.gameObjects.Ball;
import main.model.gameObjects.bounding.CircleBoundingBox;

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
        
        CircleBoundingBox b = ball.getBBox();

        switch(this.side){
            case TOP:
                b.setPos(new P2d(b.getPos().getX(), newPos - b.getRadius()));
                ball.flipVelOnY();
                break;
            case BOTTOM:
                currentGame.getWorld().removeBall(ball);
                break;
            case LEFT:
                b.setPos(new P2d(newPos + b.getRadius(), b.getPos().getY()));
                ball.flipVelOnX();
                break;
            case RIGHT:
                b.setPos(new P2d(newPos - b.getRadius(), b.getPos().getY()));
                ball.flipVelOnX();
                break;
        }
    }
    
}
