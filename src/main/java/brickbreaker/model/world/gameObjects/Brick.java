package brickbreaker.model.world.gameObjects;

import brickbreaker.common.TypeObj;
import brickbreaker.common.TypePower;
import brickbreaker.common.Vector2D;
import brickbreaker.model.factory.WorldFactory;
import brickbreaker.model.map.MapData;
import brickbreaker.model.world.gameObjects.bounding.RectBoundingBox;

/**
 * Class to model the game object Brick.
 * Extends {@link GameObjectImpl}.
 */
public class Brick extends GameObjectImpl<RectBoundingBox> {

    /** number of bricks coluns. */
    public static final Integer BRICKS_COL = MapData.MAP_COLUMNS_FILE_FORMAT;
    /** number of bricks rows. */
    public static final Integer BRICKS_ROW = MapData.MAP_ROWS_FILE_FORMAT;

    /** Width of the brick. */
    public static final Double BRICK_WIDTH = WorldFactory.BOUNDARIES_SIZE / BRICKS_COL;
    /** Height of the brick. */
    public static final Double BRICK_HEIGHT = WorldFactory.BOUNDARIES_SIZE / (BRICKS_ROW * 2);
    private TypePower powerUp;

    /**
     * Brick constructor.
     * 
     * @param pos       the position of the Brick
     * @param lifeToSet the life to set
     */
    public Brick(final Vector2D pos, final int lifeToSet) {
        super(lifeToSet, new Vector2D(0, 0), TypeObj.BRICK, new RectBoundingBox(pos, BRICK_WIDTH, BRICK_HEIGHT));
        this.powerUp = TypePower.NULL;
    }

    /**
     * @return the type of powerUp
     */
    public TypePower getPowerUp() {
        return this.powerUp;
    }

    /**
     * @param powerUpToSet the powerUp to set
     */
    public void setPowerUp(final TypePower powerUpToSet) {
        this.powerUp = powerUpToSet;
    }
}
