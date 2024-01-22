package brickbreaker.model.world.gameObjects.collision.powerUpApplicator;

import brickbreaker.model.world.World;
import brickbreaker.model.world.gameObjects.Bar;

/**
 * Class to apply lenght powerUp to Bar.
 * Implements the {@link PowerUpApplicator} interface.
 */
public class BarLengthApplicator implements PowerUpApplicator {

    private static final Double DELTA = Bar.BAR_WIDTH / 3;
    private boolean bonus;

    /**
     * Bar length constructor.
     * 
     * @param bonusToSet if increase or decrease the Bar length
     */
    public BarLengthApplicator(final boolean bonusToSet) {
        this.bonus = bonusToSet;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void applyPowerUp(final World world) {
        Double delta = bonus ? DELTA : -DELTA;

        Double barWidth = world.getBar().getWidth();
        while (barWidth < delta) {
            delta = delta / 2;
        }
        world.getBar().setWidth(barWidth + delta);
    }
}
