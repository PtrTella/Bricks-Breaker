package brickbreaker.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.reflect.TypeToken;

import brickbreaker.common.JsonUtils;
import brickbreaker.model.user.User;

/**
 * The controller of the user.
 */
public class UserController {

    private static final int MAX_PLAYER = 5;
    private static final String USER_FILE = "user.json";
    private final List<User> users;

    /**
     * Empy UserController constructor.
     */
    public UserController() {
        this.users = JsonUtils.loadData(new TypeToken<List<User>>() {
        }.getType(), USER_FILE);
    }

    /**
     * Method to save the users.
     */
    public void saveUsers() {
        JsonUtils.saveData(this.users, USER_FILE);
    }

    /**
     * Methdo to get all the name of the user saved.
     * 
     * @return the List of name
     */
    public List<String> getUsersName() {
        return this.users.stream().map(User::getName).collect(Collectors.toList());
    }

    /**
     * Method to get a user passing the name.
     * 
     * @param username the name of the user
     * @return a User
     */
    public User getUser(final String username) {
        return this.users.stream().filter(u -> u.getName().equals(username)).findFirst().orElse(null);
    }

    /**
     * Method to add a new user to json file.
     * 
     * @param newUser the user to add
     */
    public void addUser(final User newUser) {
        if (!this.isMaxUser()) {
            this.users.add(newUser);
        }
    }

    /**
     * Method to remove user and his ranks from json file.
     * 
     * @param username the name of the user to remove
     */
    public void removeUser(final String username) {
        this.users.removeIf(u -> u.getName().equals(username));
    }

    /**
     * Method to chek the number of user.
     * 
     * @return true if less than MAX_PLAYER
     */
    public boolean isMaxUser() {
        return this.users.size() >= MAX_PLAYER;
    }
}
