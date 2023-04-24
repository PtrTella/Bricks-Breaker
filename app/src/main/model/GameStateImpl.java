package main.model;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import main.common.P2d;
import main.model.factory.GameFactory;
import main.model.gameObjects.Brick;
import main.model.gameObjects.bounding.RectBoundingBox;
import main.model.gameObjects.power.TypePower;
import main.model.map.GameMap;
import main.model.map.GameMapImpl;
import main.model.timer.Timer;
import main.model.timer.TimerImpl;
import main.model.timer.TimerThread;

/**
 * This is the implementation of a game state.
 * For further informations, see the GameState interface documentation.
*/
public class GameStateImpl implements GameState {

    private static final Integer TIME = 300;
    private static final Integer MAPCOL = 20;
    private static final Integer MAPLINE = 10;
    public static enum State { PLAYING, WIN, LOST}

    private World currentWorld;
    private Integer score;
    private State state;
    private Timer gameTimer;
    private TimerThread gameTimerThread;

    /**
     * {@inheritDoc}}
     */
    @Override
    public final void init(String nameMap, Integer level) {

        GameFactory f = GameFactory.getInstance();
        GameMap map = GameMapImpl.getInstance();
		score = 0;

        this.currentWorld = new WorldImpl(new RectBoundingBox(new P2d(4, 3), 8.0, 6.0));
        currentWorld.setBar(f.createBar(null, null));
        currentWorld.addBall(f.createBall(null, null));
        currentWorld.addBricks(f.createBricks(map.LoadMap(nameMap),MAPCOL,MAPLINE));
        randomPowerUpAssignament(currentWorld.getBricks(), getWorldPowerUp(level));
        this.gameTimer = new TimerImpl(GameStateImpl.TIME);
        this.gameTimerThread = new TimerThread(this.gameTimer);
        this.state = State.PLAYING;
    }

    // adding TypePower randomly to bricks
    private void randomPowerUpAssignament(List<Brick> b, List<TypePower> p){
        Integer diff = b.size() - p.size();
        Random random = new Random();
        if(diff > 0){
            p.addAll(Collections.nCopies(diff, TypePower.NULL));
        }
        for(Brick brick : b){
            brick.setPowerUp(p.remove(random.nextInt(p.size())));
        }
    }

    // TODO implement method
    private List<TypePower> getWorldPowerUp(Integer level){
        return null;
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

    @Override
    public TimerThread getGameTimerThread() {
        return this.gameTimerThread;
    }

    @Override
    public Timer getGameTimer() {
        return this.gameTimer;
    }
     
}
