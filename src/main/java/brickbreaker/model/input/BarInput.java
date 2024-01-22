package brickbreaker.model.input;

import brickbreaker.controllers.InputController;
import brickbreaker.model.world.gameObjects.Bar;
/**
 * Class to elaborate the player input and update the position of the respective object.
 */
public class BarInput implements InputComponent {

    private final Double move = 150.0;
    private final Integer scale = 5000;

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(final Bar bar, final Double rb, final InputController c, final Double elapsed) {

        Long value = Math.round(move * (elapsed / scale));

        if (c.isMoveLeft()) {
            if (bar.getBBox().getULCorner().getX() >= value) {
                bar.move(-value);
            }
            c.noMoveLeft();
        } else if (c.isMoveRight()) {
            if (bar.getBBox().getBRCorner().getX() <= (rb - value)) {
                bar.move(value);
            }
            c.noMoveRight();
        }
    }

}
