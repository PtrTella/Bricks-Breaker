package brickbreaker.common;

/**
 * Class representing a two-dimensional vector.
 */
public class Vector2D {

    private Double x;
    private Double y;

    /**
     * P2d constructor.
     * 
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Vector2D(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x coordinate
     */
    public Double getX() {
        return this.x;
    }

    /**
     * @return the y coordinate
     */
    public Double getY() {
        return this.y;
    }

    /**
     * Method to sum a vector to another.
     * 
     * @param v the vector to sum
     * @return a new position
     */
    public Vector2D sum(final Vector2D v) {
        return new Vector2D(x + v.getX(), y + v.getY());
    }

    /**
     * Method to multiply a vector by a value.
     * 
     * @param value the value to multiply
     * @return a new vector
     */
    public Vector2D mul(final double value) {
        return new Vector2D(value * this.x, value * this.y);
    }

    /**
     * Method to calculate the distance between two points.
     * 
     * @param xp the second point
     * @return the horizontal distance between two point
     */
    public Double orizDist(final Vector2D xp) {
        return this.x - xp.getX();
    }

    /**
     * Method to calculate the distance between two points.
     * 
     * @param yp the second point
     * @return the vertical distance between two point
     */
    public Double vertDist(final Vector2D yp) {
        return this.y - yp.getY();
    }
}
