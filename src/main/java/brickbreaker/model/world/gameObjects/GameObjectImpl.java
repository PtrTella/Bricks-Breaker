package brickbreaker.model.world.gameObjects;

import brickbreaker.common.TypeObj;
import brickbreaker.common.Vector2D;
import brickbreaker.model.world.gameObjects.bounding.BoundingBox;

/**
 * {@inheritDoc}
 * Implements the {@link GameObject} interface. Abstract base class for all
 * objects.
 * 
 * @param <T> the type of bounding box
 */
public abstract class GameObjectImpl<T extends BoundingBox> implements GameObject<T> {

    private Integer lifes;
    private TypeObj type;
    private Vector2D vel;
    private T bbox;

    /**
     * GameObject constructor.
     * 
     * @param lifesToSet the lifes to set
     * @param vel       the velocity to set
     * @param typeToSet the type to set
     * @param bboxToSet the bounding box to set
     */
    public GameObjectImpl(final Integer lifesToSet, final Vector2D vel, final TypeObj typeToSet, final T bboxToSet) {
        this.vel = vel;
        this.type = typeToSet;
        this.lifes = lifesToSet;
        this.bbox = bboxToSet;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getLife() {
        return this.lifes;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLife(final Integer lifes) {
        this.lifes = lifes;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void decLife() {
        this.lifes--;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void incLife() {
        this.lifes++;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TypeObj getType() {
        return type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Vector2D getPosition() {
        return this.bbox.getP2d();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setPosition(final Vector2D newPosition) {
        this.bbox.setP2d(newPosition);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Vector2D getSpeed() {
        return vel;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setSpeed(final Vector2D vel) {
        this.vel = vel;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T getBBox() {
        return this.bbox;
    }

}
