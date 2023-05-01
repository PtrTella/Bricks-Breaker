package main.controllers.input;

import main.model.gameObjects.Bar;

public class PlayerInput implements InputComponent{

    private final Integer MOVE = 1;

    @Override
    public void update(Bar bar, InputController c) {
        if(c.isMoveLeft()){
            bar.move(-MOVE);
            c.noMoveLeft();
        }else if(c.isMoveRight()){
            bar.move(MOVE);
            c.noMoveRight();
        }
    }
    
}
