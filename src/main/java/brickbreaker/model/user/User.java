package brickbreaker.model.user;

/**
 * Class representing a user.
 */
public class User {

    private String name;
    private Integer levelReached;

    /**
     * User constructor.
     * 
     * @param userName the name of the user
     */
    public User(String userName) {
        this.name = userName;
        this.levelReached = 1;
    }

    /**
     * Method to get the name of the user.
     * 
     * @return the name of the user
     */
    public String getName() {
        return this.name;
    }

    /**
     * Method to get the level reached by the user.
     * 
     * @return the level reached
     */
    public Integer getLevelReached() {
        return this.levelReached;
    }
}
