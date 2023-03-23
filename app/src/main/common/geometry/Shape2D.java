package main.common.geometry;

import main.common.P2d;

public interface Shape2D {

    void setPoint(final P2d p);

    P2d getPoint();

    boolean contains(final P2d p);

    boolean contains(final Rectangle2D p);

    boolean contains(final double x, final double y);

    boolean contains(final double x, final double y, final double w, final double h);

    boolean intersects(final double x, final double y, final double w, final double h);
    
    boolean intersects(final Rectangle2D r);
}
