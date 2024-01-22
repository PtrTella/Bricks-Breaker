package brickbreaker.controllers;

import brickbreaker.common.Error;
import brickbreaker.common.ImageUtils;
import brickbreaker.controllers.listener.ErrorListener;
import brickbreaker.view.ViewSwitcher;
import brickbreaker.view.ViewType;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * Main project class.
 */
public class Setup extends Application {

    private static final Double POSITION_X = 3.5;
    private static final Integer POSITION_Y = 20;

    /**
     * Entry point.
     * 
     * @param primaryStage the primary stage
     */
    @Override
    public void start(final Stage primaryStage) throws Exception {
        try {
            ImageUtils.LoadImagers();
        } catch (Exception e) {
            ErrorListener.notifyError(Error.LOAD_IMAGE_ERROR);
        }

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        double centerX = bounds.getMaxX() / POSITION_X;
        double centerY = bounds.getMinY() + POSITION_Y;

        primaryStage.setResizable(true);
        primaryStage.setX(centerX);
        primaryStage.setY(centerY);

        primaryStage.setOnCloseRequest(event -> {
            System.exit(0);
        });

        ViewSwitcher.getInstance().switchView(primaryStage, ViewType.SETUP);

        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
