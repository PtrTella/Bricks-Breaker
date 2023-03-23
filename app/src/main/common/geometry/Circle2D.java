package main.common.geometry;

import main.common.P2d;
import java.util.ArrayList;

public interface Circle2D extends Shape2D {

    ArrayList<P2d> getContainedVertices(final Rectangle2D r);
    
    ArrayList<P2d> getContainedVertices(final double x, final double y, final double w, final double h);
}
