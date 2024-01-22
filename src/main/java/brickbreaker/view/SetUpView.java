package brickbreaker.view;

import java.util.List;

import brickbreaker.common.GameImages;
import brickbreaker.model.user.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Implementation of {@link View} for the setup menu.
 */
public class SetUpView extends ViewImpl {

    @FXML
    private AnchorPane root;

    @FXML
    private VBox vBoxMainContainer;

    @FXML
    private HBox hBoxNicknameInsertion;

    @FXML
    private ImageView imgChoose;

    @FXML
    private ImageView imgNickname;

    @FXML
    private ComboBox<String> cbUsersList;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnRemove;

    private List<String> users;

    /**
     * {@inheritDoc}
     */
    @Override
    public void init() {

        this.imgChoose.setImage(GameImages.TYPE_YOUR_NAME_LABEL.getImage());
        this.imgNickname.setImage(GameImages.NICKNAME_LABEL.getImage());

        this.users = this.getController().getUserController().getUsersName();

        // Setting up the combo box.
        cbUsersList.getItems().addAll(this.users);
        cbUsersList.setPromptText("Type your nick");
        cbUsersList.setEditable(true);

        if (this.getController().getUserController().isMaxUser()){
            cbUsersList.getEditor().setEditable(false);
        }

        cbUsersList.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(final ActionEvent event) {
                btnRemove.setVisible(true);
            }

        });

        this.btnRemove.setVisible(false);
    }

    /**
     * Method to set the user playing and swithc to the home view.
     */
    @FXML
    public void switchToHome() {
        String nick = cbUsersList.getEditor().getText();

        if (this.getController().getUserController().isMaxUser()){
            cbUsersList.getEditor().setEditable(false);
        } else {
            cbUsersList.getEditor().setEditable(true);
        }

        if (nick.isEmpty()) {
            Dialog<String> d = new Dialog<>();
            d.setTitle("Empty user name.");
            d.setContentText("You cannot play without an user name!");
            d.getDialogPane().getButtonTypes().add(new ButtonType("Retry", ButtonData.BACK_PREVIOUS));
            d.showAndWait();
        } else {
            if (!this.users.contains(nick)) {
                User u = new User(nick);
                this.getController().getUserController().addUser(u);
                this.getController().setUser(nick);
            }
            this.getController().setUser(nick);
            ViewSwitcher.getInstance().switchView(getStage(), ViewType.HOME);
        }
    }

    /**
     * Method to delete the selected user.
     */
    public void deleteSelectedUser() {

        Dialog<String> d = new Dialog<>();

        this.getController().removePlayer(cbUsersList.getEditor().getText());

        d.setTitle("Success");
        d.setContentText("Player deleted.");
        d.getDialogPane().getButtonTypes().add(new ButtonType("OK", ButtonData.OK_DONE));
        d.showAndWait();

        cbUsersList.getItems().remove(cbUsersList.getEditor().getText());
        cbUsersList.getEditor().clear();

        btnRemove.setVisible(false);
    }
}
