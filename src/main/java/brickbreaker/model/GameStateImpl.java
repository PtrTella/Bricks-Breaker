package brickbreaker.model;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import brickbreaker.model.timer.Timer;
import brickbreaker.model.timer.TimerImpl;
import brickbreaker.model.timer.TimerThread;

/**
 * This is the implementation of a game state.
 * For further informations, see the GameState interface documentation.
*/
public class GameStateImpl implements GameState {

    private static final Integer TIME = 300;
    public static enum State { PLAYING, WIN, LOST}

    private World currentWorld;
    private GameMap map = new GameMap();
    private Integer score;
    private State state;
    private Timer gameTimer;
    private TimerThread gameTimerThread;

    /**
     * {@inheritDoc}}
     */
    @Override
    public final void init(String nameMap, Integer level) {
        
		score = 0;
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
        } else if (this.getWorld().getBricks().size() == 0) {
            this.state = State.WIN;
        }
        return this.state;
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public TimerThread getGameTimerThread() {
        return this.gameTimerThread;
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public Timer getGameTimer() {
        return this.gameTimer;
    }

    /**
     * {@inheritDoc}}
     */
    @Override
    public List<String> getNamesMap() {
        return Arrays.asList(new File(map.getPathMapFile()).list());
    }
     
}
