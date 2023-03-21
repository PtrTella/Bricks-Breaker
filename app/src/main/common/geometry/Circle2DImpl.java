package main.common.geometry;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import main.common.P2d;

public class Circle2DImpl implements Shape {

    private double radius;
    private P2d center;

    
    @Override
    public boolean contains(double x, double y) {
        double xDelta = (x - this.center.getX());
        double yDelta = (y - this.center.getY());

        return (xDelta*xDelta + yDelta*yDelta) <= this.radius*this.radius;
    }

    @Override
    public boolean contains(Point2D p) {
        return this.contains(p.getX(), p.getY());   
    }

    public ArrayList<Point2D> getContainedVertices(double x, double y, double w, double h) {

        ArrayList<Point2D> containedVertices = new ArrayList<Point2D>(4);
        Point2D.Double [] corners = { new Point2D.Double(x, y), new Point2D.Double(x + w, y),
            new Point2D.Double(x, y + h), new Point2D.Double(x + w, y + h) };

        for (Point2D current : corners) {
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
        return this.contains(r.getX(), r.getY(), r.getWidth(), r.getHeight());
    }

    @Override
    public Rectangle getBounds() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBounds'");
    }

    @Override
    public Rectangle2D getBounds2D() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBounds2D'");
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPathIterator'");
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPathIterator'");
    }

    @Override
    public boolean intersects(Rectangle2D r) {
        return this.intersects(r.getX(), r.getY(), r.getWidth(), r.getHeight());
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        return this.getContainedVertices(x, y, w, h).size() != 0;
    }
    
}
