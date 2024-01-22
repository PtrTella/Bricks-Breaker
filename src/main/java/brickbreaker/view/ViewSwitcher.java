package brickbreaker.view;

import java.io.IOException;
import brickbreaker.common.GameImages;
import brickbreaker.controllers.Controller;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * This class is used to switch between views.
 */
public final class ViewSwitcher {

    private static ViewSwitcher instance;
    private View currentView;
    private Controller mainController = new Controller();

    /**
     * This method is used to get the current instance of the ViewSwitcher.
     * It use the singleton pattern.
     * 
     * @return the current instance of the ViewSwitcher
     */
    public static ViewSwitcher getInstance() {
        if (instance == null) {
            instance = new ViewSwitcher();
        }

        return instance;
    }

    /**
     * This method is used to load the style of the view.
     * It loads the fxml file and set the new scene.
     * 
     * @param stage    the stage to set the new scene
     * @param viewType the type of the view to switch to
     * @return the view loaded
     */
    private View loadStyle(final Stage stage, final ViewType viewType) {
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource(viewType.getPath()));
        Parent root = null;

        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene newScene = new Scene(root);

        stage.setScene(newScene);
        stage.getScene().getStylesheets().clear();
        View view = loader.getController();
        stage.setMinHeight(((AnchorPane) stage.getScene().getRoot()).getMinHeight());
        stage.setMinWidth(((AnchorPane) stage.getScene().getRoot()).getMinWidth());
        if (root != null) {
            root.scaleXProperty().bind(Bindings.min(stage.widthProperty().divide(stage.minWidthProperty()),
                    stage.heightProperty().divide(stage.minHeightProperty())));

            root.scaleYProperty().bind(root.scaleXProperty());
        }

        view.setStage(stage);
        stage.setScene(newScene);
        return view;
    }

    /**
     * This method is used to switch between views.
     * 
     * @param stage the stage to set the new scene
     * @param type  the type of the view to switch to
     */
    public void switchView(final Stage stage, final ViewType type) {
        currentView = this.loadStyle(stage, type);
        currentView.setController(this.mainController);
        currentView.setStage(stage);
        currentView.init();
        stage.getIcons().add(GameImages.GAME_ICON.getImage());
        stage.setTitle("Brick-Breaker");
        stage.show();
    }
}
