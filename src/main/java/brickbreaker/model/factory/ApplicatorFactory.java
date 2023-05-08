package brickbreaker.model.factory;

import brickbreaker.model.gameObjects.power.TypePower;
import brickbreaker.model.gameObjects.power.applicator.*;

public class ApplicatorFactory {

    static private ApplicatorFactory instance;

    static public ApplicatorFactory getInstance() {
        if (instance == null) {
            instance = new ApplicatorFactory();
        }

        return instance;
    }

    //TODO: Remove the last else statement, it's only a temporary placeholder for clarity purposes.
    public PowerUpApplicator createApplicator(final TypePower type) {
        if (type == TypePower.FASTBALL || type == TypePower.SLOWBALL) {
            return new BallSpeedApplicator(type == TypePower.FASTBALL);
        }else if (type == TypePower.LONGBAR || type == TypePower.SHORTBAR) {
            return new BarLengthApplicator(type == TypePower.LONGBAR);
        } else {
            return null;
        }
    }
}
