package main.common.geometry;

import main.common.P2d;

public interface Rectangle2D {

    void setPoint(final P2d point);

    P2d getPoint();

    void setWidth(final int widthToSet);

    int getWidth();

    void setHeight(final int heightToSet);

    int getHeight();

    boolean intersects(final Rectangle2D rectToCheck);
}
