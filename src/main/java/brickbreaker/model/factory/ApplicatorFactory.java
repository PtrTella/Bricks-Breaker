package brickbreaker.model.factory;

import brickbreaker.common.TypePower;
import brickbreaker.model.world.gameObjects.collision.powerUpApplicator.BallDimApplicator;
import brickbreaker.model.world.gameObjects.collision.powerUpApplicator.BallSpeedApplicator;
import brickbreaker.model.world.gameObjects.collision.powerUpApplicator.BarLengthApplicator;
import brickbreaker.model.world.gameObjects.collision.powerUpApplicator.DestructibleBrickApplicator;
import brickbreaker.model.world.gameObjects.collision.powerUpApplicator.MultiBallApplicator;
import brickbreaker.model.world.gameObjects.collision.powerUpApplicator.PowerUpApplicator;
import brickbreaker.model.world.gameObjects.collision.powerUpApplicator.ScoreApplicator;
import brickbreaker.model.world.gameObjects.collision.powerUpApplicator.LifeIncApplicator;
import brickbreaker.model.world.gameObjects.collision.powerUpApplicator.NullApplicator;

/**
 * Class to apply powerUp.
 */
public class ApplicatorFactory {

    private static final Integer SCORE_50 = 50;
    private static final Integer SCORE_100 = 100;
    private static final Integer SCORE_250 = 250;
    private static final Integer SCORE_500 = 500;

    /**
     * Applicator factory constructor.
     */
    public ApplicatorFactory() {
    }

    /**
     * Method to apply powerUp that collides with bar. Create a specific class but
     * return the interface.
     * 
     * @param power powerUp type
     * @param type  true if powerUp is positive, false if powerUp is negative
     * @return a PowerUpApplicator
     */
    public PowerUpApplicator createApplicator(final TypePower power, final boolean type) {

        switch (power) {
            case FASTBALL:
            case SLOWBALL:
                return new BallSpeedApplicator(type);
            case SMALLBALL:
            case BIGBALL:
                return new BallDimApplicator(type);
            case MULTIBALL:
                return new MultiBallApplicator();
            case LONGBAR:
            case SHORTBAR:
                return new BarLengthApplicator(type);
            case INDBRICK:
                return new DestructibleBrickApplicator(type);
            case INC_50:
                return new ScoreApplicator(SCORE_50);
            case INC_100:
                return new ScoreApplicator(SCORE_100);
            case INC_250:
                return new ScoreApplicator(SCORE_250);
            case INC_500:
                return new ScoreApplicator(SCORE_500);
            case DEC_50:
                return new ScoreApplicator(-SCORE_50);
            case DEC_100:
                return new ScoreApplicator(-SCORE_100);
            case LIFE_INC:
                return new LifeIncApplicator();
            default:
                return new NullApplicator();
        }
    }
}
