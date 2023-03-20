package main.common.geometry;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import main.common.P2d;

public class Circle2DImpl implements Shape {

    private double radius;
    private P2d center;

    
    @Override
    public boolean contains(double x, double y) {
        double xDelta = (x - this.center.x);
        double yDelta = (y - this.center.y);

        return (xDelta*xDelta + yDelta*yDelta) <= this.radius*this.radius;
    }
    
    @Override
    public boolean contains(Point2D p) {
        return this.contains(p.getX(), p.getY());   
    }

    @Override
    public boolean contains(Rectangle2D r) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'intersects'");
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'intersects'");
    }
    
}
