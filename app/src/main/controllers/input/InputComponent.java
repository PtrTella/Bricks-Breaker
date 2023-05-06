package main.controllers.input;

import main.model.gameObjects.Bar;

public interface InputComponent {
    void update(Bar bar, Double rb,  InputController c);
}
