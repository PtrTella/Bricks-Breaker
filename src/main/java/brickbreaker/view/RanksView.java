package brickbreaker.view;

import java.util.Map;
import java.util.Map.Entry;

import brickbreaker.common.Difficulty;
import brickbreaker.common.GameImages;
import brickbreaker.model.rank.Rank;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

/**
 * Implementation of {@link View} for the ranks menu.
 */
public class RanksView extends ViewImpl {

    @FXML
    private TableView<Map.Entry<String, Integer>> currentRank;

    @FXML
    private TableColumn<Map.Entry<String, Integer>, String> columnPlayers;

    @FXML
    private TableColumn<Map.Entry<String, Integer>, Integer> columnScores;

    @FXML
    private VBox vbContainer;

    @FXML
    private ImageView imgTitle;

    @FXML
    private Label lblTitle;

    @FXML
    private ImageView imgNext;

    @FXML
    private ImageView imgPrevious;

    @FXML
    private ImageView imgBack;

    @FXML
    private ImageView imgChange;

    private Image[] endlessLevels;
    private Integer endlessLevelsIndex;
    private Integer rankIndex;

    /**
     * {@inheritDoc}
     */
    @Override
    public void init() {

        this.endlessLevelsIndex = 0;
        this.endlessLevels = new Image[2];
        this.endlessLevels[0] = GameImages.ENDLESS_MODE_CHOICE.getImage();
        this.endlessLevels[1] = GameImages.LEVELS_LABEL.getImage();

        // this.imgBack.setImage(GameImages.PREVIOUS.getImage());
        this.imgNext.setImage(GameImages.RIGHT_ARROW.getImage());
        this.imgPrevious.setImage(GameImages.LEFT_ARROW.getImage());
        this.imgChange.setImage(GameImages.ENDLESS_MODE_CHOICE.getImage());
        this.imgTitle.setImage(GameImages.LEADERBOARD_CHOICE.getImage());
        this.imgBack.setImage(GameImages.BACK_ARROW.getImage());

        this.rankIndex = 0;
        this.tableViewInit();
        this.setRank();
    }

    /**
     * Method that sets the rank table.
     */
    private void tableViewInit() {
        this.currentRank.setEditable(false);
        this.columnPlayers.setEditable(false);
        this.columnScores.setEditable(false);
        this.columnPlayers.setSortable(false);
        this.columnScores.setSortable(false);

        this.columnPlayers.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Map.Entry<String, Integer>, String>, ObservableValue<String>>() {

                    @Override
                    public ObservableValue<String> call(final CellDataFeatures<Entry<String, Integer>, String> param) {
                        return new SimpleStringProperty(param.getValue().getKey());
                    }

                });

        this.columnScores.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Map.Entry<String, Integer>, Integer>, ObservableValue<Integer>>() {

                    @Override
                    public ObservableValue<Integer> call(
                            final CellDataFeatures<Entry<String, Integer>, Integer> param) {
                        return new SimpleIntegerProperty(param.getValue().getValue()).asObject();
                    }

                });

        // Loading an initial rank.
        this.bindData(this.getController().getRankController().getEndlessRank(Difficulty.EASY));

    }

    /**
     * Method that changes the rank mode between endless and levels.
     */
    public void changeMode() {
        this.endlessLevelsIndex = this.endlessLevelsIndex == 0 ? 1 : 0;
        this.imgChange.setImage(this.endlessLevels[this.endlessLevelsIndex]);
        this.imgChange.setImage(this.endlessLevels[this.endlessLevelsIndex]);
        this.rankIndex = 0;
        setRank();
    }

    /**
     * Method that returns the max index of the rank based on the current mode.
     * 
     * @return the max index of the rank.
     */
    private Integer getMaxIndex() {
        return this.endlessLevelsIndex == 0 ? this.getController().getRankController().getEndlessRankQuantity()
                : this.getController().getRankController().getLevelsRankQuantity();
    }

    /**
     * Method that sets the rank based on the current mode and the current index.
     */
    private void setRank() {
        if(endlessLevelsIndex == 0) {
            this.rankIndex %= this.getController().getRankController().getEndlessRankQuantity();
            this.bindData(this.getController().getRankController().getEndlessRank(Difficulty.values()[this.rankIndex]));
        } else {
            this.rankIndex %= this.getController().getRankController().getLevelsRankQuantity();
            this.bindData(this.getController().getRankController().getLevelsRank(this.rankIndex));
        }
        String s = this.endlessLevelsIndex == 0 ? Difficulty.values()[this.rankIndex].toString()
                    : this.getController().getLevelController().getLevelName(this.rankIndex);
            this.lblTitle.setText(s);
    }

    /**
     * Listener for the next button.
     * Switches to the next rank of the current mode.
     */
    public void clickNext() {
        this.rankIndex++;
        setRank();
    }

    /**
     * Listener for the previous button.
     * Switches to the previous rank of the current mode.
     */
    public void clickPrevious() {
        if (this.rankIndex == 0) {
            this.rankIndex = getMaxIndex();
        } else {
            this.rankIndex--;
        }
        setRank();
    }

    /**
     * Listener for the back button.
     * Switches to the home menu.
     */
    public void clickBack() {
        ViewSwitcher.getInstance().switchView(this.getStage(), ViewType.HOME);
    }

    /**
     * Method that binds the rank data to the table.
     * 
     * @param r the rank to bind.
     */
    public void bindData(final Rank r) {
        ObservableList<Map.Entry<String, Integer>> obRank = FXCollections.observableArrayList(r.getRank().entrySet());
        this.currentRank.setItems(obRank);
    }

}
