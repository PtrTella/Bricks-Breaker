package main.common.geometry;

import main.common.P2d;
import java.util.ArrayList;

public interface Circle2D {

    boolean contains(final double x, final double y);

    boolean contains(final P2d p);

    ArrayList<P2d> getContainedVertices(final double x, final double y, final double w, final double h);

    boolean contains(final double x, final double y, final double w, final double h);

    boolean contains(final Rectangle2D r);

    boolean intersects(final double x, final double y, final double w, final double h);

    boolean intersects(final Rectangle2D r);
}
