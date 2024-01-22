package brickbreaker.model.world.gameObjects.bounding;

import brickbreaker.common.Vector2D;

/**
 * Class to model a rectangular shape.
 * Implements the {@link BoundingBox} interface.
 */
public class RectBoundingBox implements BoundingBox {

    private Vector2D pos;
    private Double width, height;

    /**
     * RectBoundingBox constructor.
     * 
     * @param pos    position
     * @param width  width
     * @param height height
     */
    public RectBoundingBox(final Vector2D pos, final Double width, final Double height) {
        this.pos = pos;
        this.width = width;
        this.height = height;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Vector2D getP2d() {
        return this.pos;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setP2d(final Vector2D pos) {
        this.pos = pos;
    }

    /**
     * @return the width
     */
    public Double getWidth() {
        return this.width;
    }

    /**
     * @param width
     *              Method to set the width
     */
    public void setWidth(final Double width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public Double getHeight() {
        return this.height;
    }

    /**
     * @return a Vector2D representing the upper-left corner
     */
    public Vector2D getULCorner() {
        return new Vector2D(pos.getX() - width / 2, pos.getY() - height / 2);
    }

    /**
     * @return a Vector2D representing the bottom-right corner
     */
    public Vector2D getBRCorner() {
        return new Vector2D(pos.getX() + width / 2, pos.getY() + height / 2);
    }

    /**
     * {@inheritDoc}
     * Detect the collision between a rectangle and another shape: rectangles or
     * circles
     */
    @Override
    public boolean isCollidingWith(final BoundingBox obj) {
        if (obj instanceof RectBoundingBox) {

            RectBoundingBox rect = (RectBoundingBox) obj;
            Vector2D ul = getULCorner();
            Vector2D br = getBRCorner();
            Vector2D pul = new Vector2D(rect.pos.getX() - rect.width / 2, rect.pos.getY() - rect.height / 2);
            Vector2D pbr = new Vector2D(rect.pos.getX() + rect.width / 2, rect.pos.getY() + rect.height / 2);

            return (ul.getX() <= pul.getX()
                    && ul.getY() <= pul.getY()
                    && br.getX() >= pbr.getX()
                    && br.getY() >= pbr.getY())
                    || (ul.getX() <= pbr.getX()
                            && ul.getY() <= pbr.getY()
                            && br.getX() >= pul.getX()
                            && br.getY() >= pul.getY());

        } else if (obj instanceof CircleBoundingBox) {

            CircleBoundingBox circ = (CircleBoundingBox) obj;
            Double circDistX = Math.abs(circ.getP2d().getX() - pos.getX());
            Double circDistY = Math.abs(circ.getP2d().getY() - pos.getY());

            if (circDistX > (width / 2 + circ.getRad()) || circDistY > (height / 2 + circ.getRad())) {
                return false;
            }

            if (circDistX <= (width / 2) || circDistY <= (height / 2)) {
                return true;
            }

            Double dx = circDistX - width / 2;
            Double dy = circDistY - height / 2;

            return ((dx * dx + dy * dy) <= (circ.getRad() * circ.getRad()));

        }
        return false;
    }

}
