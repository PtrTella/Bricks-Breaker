package main.model.gameObjects.bounding;

import main.common.P2d;

public class RectBoundingBox implements BoundingBox{

    private P2d pos;
    private Double width, height;

    public RectBoundingBox(final P2d p, final Double width, final Double height){
		this.pos = p;
        this.width = width;
        this.height = height;
	}

    @Override
    public P2d getP2d() {
        return this.pos;
    }

    @Override
    public void setP2d(P2d pos) {
        this.pos = pos;
    }

    public Double getWidth(){
        return this.width;
    }

    public Double getHeight(){
        return this.height;
    }

    /* collison between two rectangles */
    public boolean isCollidingWith(RectBoundingBox rect) {
        P2d ul = getULCorner(pos, width, height);
        P2d br = getBRCorner(pos, width, height);
        P2d pul = getULCorner(rect.pos, rect.width, rect.height);
        P2d pbr = getBRCorner(rect.pos, rect.width, rect.height);
        
        return (ul.getX() <= pul.getX() &&
                ul.getY() <= pul.getY() &&
                br.getX() >= pul.getX() &&
                br.getY() >= pul.getY()
                ) || (
                ul.getX() <= pbr.getX() &&
                ul.getY() <= pbr.getY() &&
                br.getX() >= pbr.getX() &&
                br.getY() >= pbr.getY());
    }

    public P2d getULCorner(P2d p, Double w, Double h){
		return new P2d(p.getX() - w/2, p.getY() - h/2);
	}
	
	public P2d getBRCorner(P2d p, Double w, Double h){
		return new P2d(p.getX() + w/2, p.getY() + h/2);
    }

    /* collision between circle and rectangle */
    public boolean isCollidingWith(CircleBoundingBox circ){
        // TODO implement method collision
        return false;
    }

}
