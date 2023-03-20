package main.controllers.state;

import main.controllers.ControllerImpl;
import main.controllers.state.event.WorldEventListener;
import main.controllers.state.event.WorldEventListenerImpl;

public class GameStateControllerImpl extends ControllerImpl implements GameStateController {

    private WorldEventListener eventListener;
    
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateGame'");
    }

    @Override
    public void quitGame() {
        this.getModel().setGameOver(true);
    }

    @Override
    public void pauseGame() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pauseGame'");
    }

    @Override
    public void init() {
        this.eventListener = new WorldEventListenerImpl();
        this.eventListener.setGameState(getModel());
    }
    
}
