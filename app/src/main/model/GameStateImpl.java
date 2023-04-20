package main.model;

import main.model.timer.Timer;
import main.model.timer.TimerImpl;
import main.model.timer.TimerThread;

/**
 * This is the implementation of a game state.
 * For further informations, see the GameState interface documentation.
*/
public class GameStateImpl implements GameState {

    private static final int TIME = 300;
    public static enum State { PLAYING, WIN, LOST}

    private World currentWorld;
    private int score = 0;
    private State state;
    private Timer gameTimer;
    private TimerThread gameTimerThread;

    /**
     * {@inheritDoc}}
     */
    @Override
    public final void init() {

        //TODO: Add creation of the world. this.currentWorld = new WorldImpl( pass the map );
        this.gameTimer = new TimerImpl(GameStateImpl.TIME);
        this.gameTimerThread = new TimerThread(this.gameTimer);
        this.state = State.PLAYING;
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public final World getWorld() {
        return this.currentWorld;
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public final void setWorld(final World newGameWorld) {
        this.currentWorld = newGameWorld;
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public final int getScore() {
        return this.score;
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public final void incScore(final int increment) {
        this.score += increment;
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public final void decScore(final int decrement) {
        this.score -= decrement;
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public final void updateGame(final int elapsed) {
        this.currentWorld.updateGame(elapsed);
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public State getState() {
        if (gameTimer.getTime().getTotal() == 0 || this.getWorld().getBar().getLife() <= 0) {
            this.state = State.LOST;
        } else if (this.getWorld().getNumBricks() == 0) {
            this.state = State.WIN;
        }
        return this.state;
    }

    @Override
    public TimerThread getGameTimerThread() {
        return this.gameTimerThread;
    }

    @Override
    public Timer getGameTimer() {
        return this.gameTimer;
    }
     
}
