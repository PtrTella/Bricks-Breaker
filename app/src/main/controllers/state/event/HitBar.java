package main.controllers.state.event;

import main.model.GameState;
import main.model.gameObjects.Ball;

public class HitBar implements HitObjects {

    private Ball ball;

    public HitBar(Ball ball){
        this.ball = ball;
    }

    @Override
    public void process(GameState currentGame) {
        // TODO invert vel y of ball and set a new vel x in proportion to the distance between the two centres
    }
    
}
