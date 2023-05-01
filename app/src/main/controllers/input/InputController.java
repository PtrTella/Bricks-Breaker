package main.controllers.input;

public class InputController {
    
    private boolean moveLeft;
	private boolean moveRight;

	public boolean isMoveLeft() {
		return moveLeft;
	}

	public boolean isMoveRight() {
		return moveRight;
	}

    public void notifyMoveLeft() {
		moveLeft = true;
	}

    public void noMoveLeft() {
		moveLeft = false;
	}

    public void notifyMoveRight() {
		moveRight = true;
	}

    public void noMoveRight() {
		moveRight = false;
	}

}
