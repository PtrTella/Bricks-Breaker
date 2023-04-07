package main.model.gameObjects.bounding;

import main.common.P2d;
import java.lang.Math;

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
    
    public P2d getULCorner(){
        return new P2d(pos.getX() - width/2, pos.getY() - height/2);
    }
    
    public P2d getBRCorner(){
        return new P2d(pos.getX() + width/2, pos.getY() + height/2);
    }

    /* collison between two rectangles */
    public boolean isCollidingWith(RectBoundingBox rect) {
        P2d ul = getULCorner();
        P2d br = getBRCorner();
        P2d pul = new P2d(rect.pos.getX() - rect.width/2, rect.pos.getY() - rect.height/2);
        P2d pbr = new P2d(rect.pos.getX() + rect.width/2, rect.pos.getY() + rect.height/2);
        
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

    /* collision between circle and rectangle */
    public boolean isCollidingWith(CircleBoundingBox circ){
        Double circDistX = Math.abs(circ.getP2d().getX() - pos.getX());
        Double circDistY = Math.abs(circ.getP2d().getY() - pos.getY());
 
        if(circDistX > (width/2 + circ.getRad()) || circDistY > (height/2 + circ.getRad())){
            return false;
        }

        if(circDistX <= (width/2) || circDistY <= (height/2)){
            return true;
        }

        Double dx = circDistX - width/2;
        Double dy = circDistY - height/2;
        
        return ((dx*dx + dy*dy) <= (circ.getRad() * circ.getRad()));

    }

}
