package main.controllers.state;

import main.controllers.ControllerImpl;
import main.controllers.input.InputController;
import main.controllers.state.event.WorldEventListener;
import main.controllers.state.event.WorldEventListenerImpl;
import main.model.GameStateImpl.State;

public class GameStateControllerImpl extends ControllerImpl implements GameStateController, Runnable {

    private static final double PERIOD = 16.6666;

    private WorldEventListener eventListener;
    private InputController inputController;
    private boolean pause;
    private boolean quit;
    private Thread game;

    public GameStateControllerImpl() {
        this.pause = false;
        this.quit = false;
        this.game = new Thread(this);
        this.game.setName("GameLoop");
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public void quitGame() {
        //this.getModel().setGameOver(true);
        this.getModel().getGameTimerThread().stopTimer();
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
        this.getModel().init(null, null);   // TODO Add argoments
        this.getModel().getWorld().setEventListener(this.eventListener);
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

        while(!quit){
            
            while(this.getModel().getState() == State.PLAYING && !this.pause) {
                long current = System.currentTimeMillis();
                int elapsed = (int) (current - last);
                this.processCommands();
                this.updateGame(elapsed);
                this.render();
                this.waitUntilNextFrame(current);
                last = current;
            }
    
            if(this.getModel().getState() == State.WIN){
                this.quitGame();
                //TODO: Add the user to a rank.
            }else if(this.getModel().getState() == State.LOST){
                this.quitGame();
                
            }else if(this.pause){
                // TODO when you need to stop the timer also in pause ??
    
                synchronized(game){
                    try {
                        System.out.println("Game in pause...");
                        this.game.wait();
                        System.out.println("Resume game event...");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                /*to restart the thread
                try {
                    Thread.sleep(5000);
        
                    synchronized(game) {
                        this.game.notify(); //invia la notifica al thread in attesa
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                */
            }

        }
        
        try {
            this.game.interrupt();
            throw new InterruptedException();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method processes all the commands triggered by the user.
     */
    private void processCommands() {
        this.getModel().getWorld().getBar().updateInput(inputController, this.getModel().getWorld().getMainBBox().getBRCorner().getX());
    }

    /**
     * This method updates the current Game.
     * @param elapsed
     */
    private void updateGame(final int elapsed) {
        this.getModel().updateGame(elapsed);
        this.processEvents();
        this.getModel().getWorld().checkCollision();
        this.processEvents();
        // PERCHE SI RICHIAMA DUE VOLTE IL PROCESSEVENT
    }

    /**
     * This method processes all the world events.
     */
    void processEvents(){
        this.eventListener.processAll();
    }

    /**
     * This method renders the attached view.
     */
    private void render() {}

    /**
     * This method wait end of the frame time before strting a new cicle.
     * @param currentFrame
     */
    private void waitUntilNextFrame(final long currentFrame) {
        long dt = System.currentTimeMillis() - currentFrame;
        if (dt < GameStateControllerImpl.PERIOD) {
            try {
                Thread.sleep((long) PERIOD - dt);
            } catch(Exception e) {

            }
        }
    }
    
}
