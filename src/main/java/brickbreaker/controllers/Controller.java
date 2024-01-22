package brickbreaker.controllers;

import brickbreaker.common.Chronometer;
import brickbreaker.common.Mode;
import brickbreaker.common.State;
import brickbreaker.model.Level;
import brickbreaker.model.user.User;
import brickbreaker.model.world.World;
import brickbreaker.view.GameView;

/**
 * The application controller.
 */
public class Controller extends AbstractController {

    private static final Double ELAPSED = 200.0;
    private static final Integer DEC_SCORE_TIMER = 2;

    private GameView gameView;
    private Level model;
    private Mode mode;
    private User user;

    private Chronometer chrono;
    private Integer oldScore;

    /**
     * Controller constructor.
     */
    public Controller() {
        super();
        this.chrono = new Chronometer();
        this.model = null;
        this.user = null;
        this.oldScore = 0;
    }

    /**
     * This method check the state after the update.
     */
    private void checkState() {
        State s = this.getModel().getState();
        if (s.equals(State.WAIT)) {
            this.pauseLoop();
            this.render();
        } else if (this.getModel().getState().equals(State.LOST)) {
            this.stopLoop();
            if (this.mode.equals(Mode.ENDLESS)) {
                this.getRankController().addScoreInEndlessRank(this.getLevelController().getSettedDifficulty(),
                        user.getName(), this.getScore());
            }
        } else if (this.getModel().getState().equals(State.WIN)) {
            if (this.mode.equals(Mode.ENDLESS)) {
                this.pauseLoop();
                Integer barLife = this.model.getWorld().getBar().getLife();
                this.oldScore = this.model.getWorld().getScore();
                this.model = this.getLevelController().getLevel();
                this.model.getWorld().addToScore(oldScore);
                this.model.getWorld().getBar().setLife(barLife);
                this.render();
            } else if (this.mode.equals(Mode.LEVELS)) {
                this.getRankController().addScoreInLevelsRank(this.model.getId(), user.getName(), this.getScore());
                this.stopLoop();
            }
        }
    }

    /**
     * Method to start or resume the game.
     */
    private void playLoop() {
        this.model.setState(State.PLAYING);
        chrono.startChrono();
        this.start();
    }

    /**
     * Method to pause the game.
     */
    private void pauseLoop() {
        this.model.setState(State.WAIT);
        chrono.pauseChrono();
        this.stop();
    }

    /**
     * Method to stop the game.
     */
    private void stopLoop() {
        chrono.stopChrono();
        this.chrono = new Chronometer();
        this.stop();
        this.gameView.isOver();
    }

    /**
     * This method processes all the commands triggered by the user.
     */
    protected void processCommands() {
        World w = this.model.getWorld();
        w.getBar().updateInput(ELAPSED, this.getInputController(), w.getMainBBox().getBRCorner().getX());
    }

    /**
     * This method updates the current Game.
     */
    protected void updateGame() {
        this.model.updateGame(ELAPSED.intValue());
        this.model.getWorld().checkCollision();
        this.checkState();
    }

    /**
     * Method to set the mode after the user input.
     * 
     * @param mode the mode to set
     */
    public void setMode(final Mode mode) {
        this.mode = mode;
    }

    /**
     * This method gets the current game mode.
     * 
     * @return a Mode enum value which represent the mode.
     */
    public Mode getMode() {
        return this.mode;
    }

    /**
     * Method to set the user.
     * 
     * @param username the username to set
     */
    public void setUser(final String username) {
        this.user = this.getUserController().getUser(username);
    }

    /**
     * Remove the user.
     * 
     * @param username the username to remove
     */
    public void removePlayer(final String username) {
        this.getRankController().removeScoreInAllRanks(username);
        this.getUserController().removeUser(username);
    }

    /**
     * Method to set the GameView.
     * 
     * @param gameView the gameView to set
     */
    public void setGameView(final GameView gameView) {
        this.gameView = gameView;
    }

    /**
     * Method to set the model.
     */
    public void setModel() {
        this.model = this.getLevelController().getLevel();
    }

    /**
     * Methdo to get the model.
     * 
     * @return an instance of the model.
     */
    public Level getModel() {
        return this.model;
    }

    /**
     * Method to get the score related to the time.
     * 
     * @return integer
     */
    public Integer getScore() {
        return Math.max(0, this.model.getWorld().getScore() - DEC_SCORE_TIMER * this.chrono.getElapsedTime());
    }

    /**
     * Method to start and pause the game.
     */
    public void toggle() {
        if (this.getModel().getState().equals(State.PLAYING)) {
            this.pauseLoop();
        } else {
            this.playLoop();
        }
    }

    /**
     * Method to render the world evrey frames.
     */
    public void render() {
        gameView.render(this.getScore().toString());
    }

    /**
     * Method to handle the game loop.
     * 
     * @param now the current time
     */
    @Override
    public void handle(final long now) {
        this.processCommands();
        this.updateGame();
        this.render();
    }
}
