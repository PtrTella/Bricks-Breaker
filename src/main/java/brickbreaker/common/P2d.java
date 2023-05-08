package brickbreaker.common;

// TODO unify with V2d
/**
 * 2-dimensional point
 */
public class P2d {

    private double x;
    private double y;

    public P2d(final double x, final double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public P2d sum(V2d v) {
        return new P2d(x + v.getX(), y + v.getY());
    }

    public V2d sub(P2d v) {
        return new V2d(x - v.x, y - v.y);
    }

    public String toString() {
        return "P2d("+x+","+y+")";
    }
    
    public Double orizDist(P2d xp) {
        return x - xp.getX();
    }

    public Double vertDist(P2d yp) {
        return y - yp.getY();
    }

}
