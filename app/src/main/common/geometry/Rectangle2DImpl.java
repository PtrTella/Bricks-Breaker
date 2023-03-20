package main.common.geometry;

import main.common.P2d;

public class Rectangle2DImpl implements Rectangle2D {

    private P2d topLeftCorner;
    private int width;
    private int height;

    @Override
    public void setPoint(P2d point) {
        this.topLeftCorner = point;
    }

    @Override
    public P2d getPoint() {
        return this.topLeftCorner;
    }

    @Override
    public void setWidth(final int widthToSet) {
        this.width = widthToSet;
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public void setHeight(final int heightToSet) {
        this.height = heightToSet;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public boolean intersects(Rectangle2D rectToCheck) {
        return false;
    }
    
}
