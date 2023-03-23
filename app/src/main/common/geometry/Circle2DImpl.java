package main.common.geometry;

import java.util.ArrayList;
import main.common.P2d;

public class Circle2DImpl implements Circle2D {

    private double radius;
    private P2d center;

    
    @Override
    public boolean contains(double x, double y) {
        double xDelta = (x - this.center.getX());
        double yDelta = (y - this.center.getY());

        return (xDelta*xDelta + yDelta*yDelta) <= this.radius*this.radius;
    }

    @Override
    public boolean contains(P2d p) {
        return this.contains(p.getX(), p.getY());   
    }

    @Override
    public ArrayList<P2d> getContainedVertices(double x, double y, double w, double h) {

        ArrayList<P2d> containedVertices = new ArrayList<P2d>(4);
        P2d [] vertices = { new P2d(x, y), new P2d(x + w, y),
            new P2d(x, y + h), new P2d(x + w, y + h) };

        for (P2d current : vertices) {
            if (this.contains(current)) {
                containedVertices.add(current);
            }
        }

        return containedVertices;
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        return this.getContainedVertices(x, y, w, h).size() == 4;
    }

    @Override
    public boolean contains(Rectangle2D r) {
        P2d p = r.getPoint();
        return this.contains(p.getX(), p.getY(), r.getWidth(), r.getHeight());
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        return this.getContainedVertices(x, y, w, h).size() != 0;
    }

    @Override
    public boolean intersects(Rectangle2D r) {
        P2d p = r.getPoint();
        return this.intersects(p.getX(), p.getY(), r.getWidth(), r.getHeight());
    }
}
