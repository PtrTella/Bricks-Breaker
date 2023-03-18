package main.model;

/**
 * This is the definition of a game state, which is
 * the current game match state.
 */
public interface GameState {

    /**
     * Initialize the game world and data.
     */
    void init();

    /**
     * This method returns the current game world.
     * @return A World object.
     */
    World getWorld();

    /**
     * This method sets the current game state world.
     * @param newGameWorld A World object which will be the new game world.
     */
    void setWorld(final World newGameWorld);

    /**
     * This method gets the current points scored by the user.
     * @return An integer value.
     */
    int getScore();

    /**
     * This method increments the current score by the value
     * specified by the increment parameter.
     * @param increment an integer value which is the increment.
     */
    void incScore(final int increment);

    /**
     * This method decrements the current score by the value
     * specified by the decrement parameter.
     * @param decrement an integer value which is the decrement value.
     */
    void decScore(final int decrement);

    /**
     * {@inheritDoc}}
     */
    void updateGame(final int elapsed);

    /**
     * This method checks if the current game is over.
     * @return true, if it's game over, otherwise false.
     */
    boolean isGameOver();

    /**
     * This method checks if is gamer over.
     * Basically, it checks if the player ran out of time, or
     * if the player does not have any 'life' to use.
     */
    void checkGameOver();
}
