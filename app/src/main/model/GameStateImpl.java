package main.model;

public class GameStateImpl implements GameState {

    private World currentWorld;
    private int score = 0;
    private boolean gameOver = false;

    @Override
    public void init() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'init'");
    }

    @Override
    public World getWorld() {
        return this.currentWorld;
    }

    @Override
    public void setWorld(World newGameWorld) {
        this.currentWorld = newGameWorld;
    }

    @Override
    public int getScore() {
        return this.score;
    }

    @Override
    public void incScore(final int increment) {
        this.score += increment;
    }

    @Override
    public void decScore(final int decrement) {
        this.score -= decrement;
    }

    @Override
    public void updateGame(int elapsed) {
        this.currentWorld.updateState(elapsed);
        this.checkGameOver();
    }

    @Override
    public void setGameOver(boolean gameOverState) {
        this.gameOver = gameOverState;
    }

    @Override
    public boolean getGameOver() {
        return this.gameOver;
    }

    @Override
    public void checkGameOver() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkGameOver'");
    }
     
}
