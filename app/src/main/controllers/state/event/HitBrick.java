package main.controllers.state.event;

import main.model.GameState;
import main.model.gameObjects.Brick;

public class HitBrick implements HitObjects {

    private Brick hittedBrick;

    public HitBrick(Brick hitted) {
        this.hittedBrick = hitted;
    }

    @Override
    public void process(GameState currentGame) {
        this.hittedBrick.decLife();

        if (this.hittedBrick.getLife() <= 0) {
            currentGame.getWorld().removeBrick(this.hittedBrick);
        }
    }
    
}
