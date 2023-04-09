package main.model.gameObjects.bounding;

import main.common.P2d;

/*togliere BoundingBox e BoundingBoxImpl */
/*mettere la creazione del bounding box nel costruttore del Brick... */

public class RectBoundingBox implements BoundingBox{

    private P2d pos;     /*upper-left - bottom-right */
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
    public boolean isCollidingWith(P2d p, Double w, Double h) {
        P2d ul = getULCorner(pos, width, height);
        P2d br = getBRCorner(pos, width, height);
        P2d pul = getULCorner(p, w, h);
        P2d pbr = getBRCorner(pul, w, h);
        
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

    public P2d getULCorner(P2d p, Double width, Double height){
		return new P2d(p.getX() - width/2, p.getY() - height/2);
	}
	
	public P2d getBRCorner(P2d p, Double w, Double h){
		return new P2d(p.getX() + w/2, p.getY() + h/2);
    }

    // TODO implement method collision
    /* collision between circle and rectangle */
    public boolean isCollidingWith(P2d center, Double radius){
        return false;
    }

    /**
     * First method : create a contains(P2d) method and check if every angle of the current box
     *                is contained in the box passed as argument.
     * 
     * Second method : create directly the specific method in BoundingBox.
     * 
     * In the multiball point of view, the balls has to collide with each other, maybe.
     */
    @Override
    public boolean isCollidingWith(BoundingBox boxToCheck) {
        
    }

}
