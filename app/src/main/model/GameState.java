package main.model;

public interface GameState {

    void init();

    World getWorld();

    void setWorld(final World newGameWorld);

    int getScore();

    void incScore(final int increment);

    void decScore(final int decrement);

    void updateGame(final int elapsed);

    void setGameOver(final boolean gameOver);

    boolean getGameOver();

    void checkGameOver();
}
