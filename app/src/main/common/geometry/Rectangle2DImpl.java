package main.common.geometry;

import main.common.P2d;

public class Rectangle2DImpl implements Rectangle2D {

    private int width;
    private int height;
    private P2d bottomLeft;

    @Override
    public void setPoint(P2d point) {
        this.bottomLeft = point;
    }

    @Override
    public P2d getPoint() {
        return this.bottomLeft;
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
    public boolean contains(double x, double y) {
        P2d rPoint = this.getPoint();

        boolean xA = x >= rPoint.getX() && x <= rPoint.getX() + this.getWidth();
        boolean yA = y >= rPoint.getY() && y <= rPoint.getY() + this.getHeight();

        return xA && yA;
    }

    @Override
    public boolean contains(final P2d p) {
        return this.contains(p.getX(), p.getY());
    }

    @Override
    public boolean contains(Rectangle2D p) {
        P2d r = p.getPoint();
        return this.contains(r.getX(), r.getY(), r.getX() + p.getWidth(), r.getY() + p.getHeight());
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        return this.contains(x, y) && this.contains(x + w, y + h);
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'intersects'");
    }

    @Override
    public boolean intersects(Rectangle2D r) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'intersects'");
    }
    
}
