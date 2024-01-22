package brickbreaker.controllers;

/**
 * Controller calls which keeps track of input events.
 */
public class InputController {

    private boolean moveLeft;
    private boolean moveRight;

    /**
     * @return true if object must be moved left
     */
    public boolean isMoveLeft() {
        return moveLeft;
    }

    /**
     * @return true if object must be moved right
     */
    public boolean isMoveRight() {
        return moveRight;
    }

    /** Set move left to true. */
    public void notifyMoveLeft() {
        moveLeft = true;
    }

    /** Set move left to false. */
    public void noMoveLeft() {
        moveLeft = false;
    }

    /** Set move right to true. */
    public void notifyMoveRight() {
        moveRight = true;
    }

    /** Set move right to false. */
    public void noMoveRight() {
        moveRight = false;
    }

}
