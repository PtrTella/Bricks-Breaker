package main.model.gameObjects;

import main.common.*;
import main.controllers.input.InputComponent;
import main.controllers.input.InputController;
import main.model.WorldImpl;
import main.model.gameObjects.bounding.RectBoundingBox;

public class Bar extends GameObjectImpl<RectBoundingBox>{

    private static final Double BAR_WIDTH = 5.0;
    private static final Double BAR_HEIGHT = 1.0;
    private InputComponent input;

    public Bar(final P2d pos, final Integer lifeToset) {
        super(lifeToset, new V2d(0, 0), WorldImpl.TypeObj.BAR, new RectBoundingBox(pos, BAR_WIDTH, BAR_HEIGHT));
    }

    public Double getWidth() {
        return this.getBBox().getWidth();
    }

    public void setWidth(final Double widthToSet) {
        this.getBBox().setWidth(widthToSet);
    }

    public void move(Integer m){
        this.setPosition(new P2d(this.getPosition().getX()+m, this.getPosition().getY()));
    }

    public void updateInput(InputController c){
		input.update(this, c);
	}
}
