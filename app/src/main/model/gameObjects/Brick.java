package main.model.gameObjects;

import main.common.P2d;
import main.common.V2d;
import main.model.gameObjects.bounding.RectBoundingBox;

public class Brick extends GameObjectImpl{
    
    private int life;
    private final TypePower powerUp;
	private RectBoundingBox bbox;

    public Brick(final P2d pos, final Double widthToSet, final Double heightToSet, final Integer lifeToSet, final TypePower powerToSet) {
        super(new V2d(0, 0), TypeObj.BRICK);
        this.life = lifeToSet;
        this.powerUp = powerToSet;
        this.bbox = new RectBoundingBox(pos, widthToSet, heightToSet);

    }

    public int decLife(){
        return life-1;
    }

    public TypePower getPowerUp(){
        return this.powerUp;
    }

    @Override
    public P2d getPosition() {
        return bbox.getP2d();
    }
    
    @Override
    public void setPosition(P2d newPosition) {
        bbox.setP2d(newPosition);
    }
    
    @Override
    public RectBoundingBox getBBox() {
        return this.bbox;
    }

}
