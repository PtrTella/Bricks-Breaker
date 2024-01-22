package brickbreaker.model.world.gameObjects;

import brickbreaker.common.TypeObj;
import brickbreaker.common.TypePower;
import brickbreaker.common.Vector2D;
import brickbreaker.model.world.gameObjects.bounding.RectBoundingBox;

/**
 * Class to model the game object PowerUp.
 * Extends {@link GameObjectImpl}.
 */
public class PowerUp extends GameObjectImpl<RectBoundingBox> {

    /** Power-up width. */
    public static final Double POWERUP_WIDTH = Brick.BRICK_WIDTH / 2;
    /** Power-up height. */
    public static final Double POWERUP_HEIGHT = Brick.BRICK_HEIGHT / 2;
    /** Power-up falling speed. */
    public static final Double POWERUP_FALLING = 10.0;
    private final TypePower powerUp;

    /**
     * PowerUp constructor.
     * 
     * @param pos        the position of the PowerUp
     * @param powerToSet the power to set
     */
    public PowerUp(final Vector2D pos, final TypePower powerToSet) {
        super(1, new Vector2D(0, POWERUP_FALLING), TypeObj.POWERUP,
                new RectBoundingBox(pos, POWERUP_WIDTH, POWERUP_HEIGHT));
        this.powerUp = powerToSet;
    }

    /**
     * @return the type of PowerUp
     */
    public TypePower getPowerUp() {
        return this.powerUp;
    }

    /**
     * @return the height of powerUp objects
     */
    public Double getHeight() {
        return this.getBBox().getHeight();
    }
}
