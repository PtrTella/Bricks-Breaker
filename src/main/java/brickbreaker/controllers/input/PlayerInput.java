package brickbreaker.controllers.input;

import brickbreaker.model.gameObjects.Bar;

public class PlayerInput implements InputComponent{

    private final Integer MOVE = 1;

    @Override
    public void update(Bar bar, Double rb, InputController c) {
        if(c.isMoveLeft()){
            if(bar.getBBox().getULCorner().getX() > 0){
                bar.move(-MOVE);
            }
            c.noMoveLeft();
        }else if(c.isMoveRight()){
            if(bar.getBBox().getBRCorner().getX() < rb){
                bar.move(MOVE);
            }
            c.noMoveRight();
        }
    }
    
}
