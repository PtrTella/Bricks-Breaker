package main.controllers.state.event;

import main.model.GameState;
import main.model.gameObjects.PowerUp;

public class HitPowerUp implements HitObjects{

    private PowerUp picked;

    public HitPowerUp(final PowerUp p) {
        this.picked = p;
    }

    public PowerUp getPickedPowerUp() {
        return this.picked;
    }

    @Override
    public void process(final GameState currentGame) {
        //TODO: applyPowerUp() method in GameState(?) -> need a timer check
    }
    
}
