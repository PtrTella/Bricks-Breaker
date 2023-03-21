package main.common.geometry;

import java.awt.Shape;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public interface Circle2D extends Shape {

    @Override
    public boolean contains(double x, double y);

    @Override
    public boolean contains(Point2D p);

    public ArrayList<Point2D> getContainedVertices(double x, double y, double w, double h);

    @Override
    public boolean contains(double x, double y, double w, double h);

    @Override
    boolean intersects(double x, double y, double w, double h);
}
