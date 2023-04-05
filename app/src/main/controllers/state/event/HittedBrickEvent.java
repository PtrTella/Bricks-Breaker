package main.controllers.state.event;

import main.model.GameState;
import main.model.gameObjects.Brick;

public class HittedBrickEvent implements WorldEvent {

    private Brick hittedBrick;

    public HittedBrickEvent(Brick hitted) {
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
