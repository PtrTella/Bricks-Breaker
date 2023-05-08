package brickbreaker.controllers.state.event;

import brickbreaker.model.GameState;
import brickbreaker.model.gameObjects.power.PowerUp;
import brickbreaker.model.gameObjects.power.applicator.PowerUpApplicator;

public class HitPowerUp implements HitObjects{

    private PowerUpApplicator applicator;
    private PowerUp picked;

    public HitPowerUp(final PowerUp p, final PowerUpApplicator a) {
        this.picked = p;
        this.applicator = a;
    }

    public PowerUp getPickedPowerUp() {
        return this.picked;
    }

    @Override
    public void process(final GameState currentGame) {
        this.applicator.applyPowerUp(currentGame.getWorld());
    }
    
}
