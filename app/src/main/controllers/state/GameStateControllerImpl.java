package main.controllers.state;

import main.controllers.ControllerImpl;
import main.controllers.state.event.WorldEventListener;
import main.controllers.state.event.WorldEventListenerImpl;

public class GameStateControllerImpl extends ControllerImpl implements GameStateController, Runnable {

    private static final double PERIOD = 16.6666;

    private WorldEventListener eventListener;
    private boolean pause;
    private boolean quit;
    private Thread game;

    public GameStateControllerImpl() {
        super();
        this.pause = false;
        this.quit = false;
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void processCommands() {

    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void processEvents() {
        this.eventListener.processAll();
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void render() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'render'");
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void updateGame(final int elapsed) {
        this.getModel().updateGame(elapsed);
        this.processEvents();
        this.getModel().getWorld().checkCollision();
        this.processEvents();
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void quitGame() {
        this.getModel().setGameOver(true);
        this.quit = true;
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void pauseGame() {
        this.pause = !this.pause;
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void init() {
        this.eventListener = new WorldEventListenerImpl();
        this.eventListener.setGameState(getModel());
        this.getModel().init();
        this.getModel().getWorld().setEventListener(this.eventListener);
        this.game = new Thread(this);
        this.game.setName("GameLoop");
        this.game.start();
        this.getModel().getGameTimerThread().start();
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public int getScore() {
        return this.getModel().getScore();
    }

    @Override
    public void run() {
        long last = System.currentTimeMillis();

        while(!this.getModel().isGameOver()) {
            long current = System.currentTimeMillis();
            int elapsed = (int) (current - last);
            this.processCommands();
            this.updateGame(elapsed);
            this.render();
            this.waitUntilNextFrame(current);
            last = current;
        }

        this.getModel().getGameTimerThread().stopTimer();
        //TODO: Add the user to a rank.
    }

    public void waitUntilNextFrame(final long currentFrame) {
        long dt = System.currentTimeMillis() - currentFrame;
        if (dt < GameStateControllerImpl.PERIOD) {
            try {
                Thread.sleep((long) PERIOD - dt);
            } catch(Exception e) {

            }
        }
    }
    
}
