package main.model.gameObjects.power.applicator;

import main.model.World;

public class BarLengthApplicator implements PowerUpApplicator {

    private final static Double DELTA_BAR_LENGTH = 3.0;
    private boolean bonus;

    public BarLengthApplicator(final boolean bonusToSet) {
        this.bonus = bonusToSet;
    }

    @Override
    public void applyPowerUp(final World gameWorld) {
        Double delta = bonus ? DELTA_BAR_LENGTH : -DELTA_BAR_LENGTH;

        Double barWidth = gameWorld.getBar().getWidth();
        gameWorld.getBar().setWidth(barWidth + delta);
    }
    
}
