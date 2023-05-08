package brickbreaker.controllers.input;

import brickbreaker.model.gameObjects.Bar;

public interface InputComponent {
    void update(Bar bar, Double rb,  InputController c);
}
