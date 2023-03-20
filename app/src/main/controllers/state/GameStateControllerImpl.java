package main.controllers.state;

import main.controllers.ControllerImpl;
import main.controllers.state.event.WorldEventListener;
import main.controllers.state.event.WorldEventListenerImpl;

public class GameStateControllerImpl extends ControllerImpl implements GameStateController {

    private WorldEventListener eventListener;
    private boolean pause;
    private boolean quit;

    public GameStateControllerImpl() {
        super();
        this.pause = false;
        this.quit = false;
    }
    
    @Override
    public void processCommands() {

    }

    @Override
    public void processEvents() {
        this.eventListener.processAll();
    }

    @Override
    public void render() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'render'");
    }

    @Override
    public void updateGame(final int elapsed) {
        this.getModel().updateGame(elapsed);
        this.getModel().getWorld().checkBoundary();
        this.processEvents();
        this.getModel().getWorld().checkCollision();
        this.processEvents();
    }

    @Override
    public void quitGame() {
        this.getModel().setGameOver(true);
        this.quit = true;
    }

    @Override
    public void pauseGame() {
        this.pause = !this.pause;
    }

    @Override
    public void init() {
        this.eventListener = new WorldEventListenerImpl();
        this.eventListener.setGameState(getModel());
    }
    
}
