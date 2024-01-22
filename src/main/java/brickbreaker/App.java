package brickbreaker;

import brickbreaker.controllers.Setup;
import javafx.application.Application;

/**
 * Launcher class.
 */
public final class App {

    private App() { }

    /**
     * Main method.
     * @param args Arguments.
     */
    public static void main(final String[] args) {
        Application.launch(Setup.class, args);
    }
}
