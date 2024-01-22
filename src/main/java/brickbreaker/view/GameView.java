package brickbreaker.view;

import brickbreaker.common.GameObjectsImages;
import brickbreaker.common.TypePower;
import brickbreaker.common.Vector2D;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import brickbreaker.model.factory.WorldFactory;
import brickbreaker.model.world.gameObjects.Ball;
import brickbreaker.model.world.gameObjects.Bar;
import brickbreaker.model.world.gameObjects.Brick;
import brickbreaker.model.world.gameObjects.PowerUp;
import brickbreaker.model.world.gameObjects.bounding.RectBoundingBox;

import java.util.HashMap;
import java.util.List;

/**
 * Class that implements the GameView interface.
 */
public class GameView extends ViewImpl {

    private static final Integer ANIMATION_TIMER = 10;

    private static final Integer IMAGE_BRICK_SIZE = 9;
    private static final Integer IMAGE_BRICK_OFFSET_START = 0;
    private static final Integer IMAGE_BRICK_OFFSET_END = 10;
    private static final Integer IMAGE_OFFSET_START = 10;
    private static final Integer IMAGE_OFFSET_END = 22;

    private static final Double CANVAS_HEIGHT = WorldFactory.BOUNDARIES_SIZE;
    private static final Double CANVAS_WIDTH = WorldFactory.BOUNDARIES_SIZE;

    private static final Double BRICK_WIDTH = Brick.BRICK_WIDTH;
    private static final Double BRICK_HEIGHT = Brick.BRICK_HEIGHT;

    @FXML
    private Label lifeLabel;

    @FXML
    private Label scoreLabel;

    @FXML
    private Pane gamePane;

    @FXML
    private ImageView backGround;

    @FXML
    private Canvas foreGround;

    @FXML
    private ImageView ball;

    @FXML
    private ImageView pauseButton;

    private GraphicsContext gcF;
    private HashMap<Integer, Image> brickImages;
    private HashMap<TypePower, Image> ppImages;
    private Image[] barAnimations;
    private Integer barAnimationIndex;
    private Integer frameCounter;

    /**
     * {@inheritDoc}
     */
    @Override
    public void init() {
        this.getController().setGameView(this);

        Integer m = this.getController().getModel().getId();
        this.backGround.setImage(this.getController().getLevelController().getMapInfo(m).getLandscape().getImage());

        this.foreGround.setHeight(CANVAS_HEIGHT);
        this.foreGround.setWidth(CANVAS_WIDTH);
        this.foreGround.widthProperty().bind(this.gamePane.widthProperty());
        this.foreGround.heightProperty().bind(this.gamePane.heightProperty());
        this.gcF = foreGround.getGraphicsContext2D();
        RectBoundingBox b = this.getController().getModel().getWorld().getMainBBox();
        this.gcF.setFill(Color.BLACK);
        this.gcF.fillRect(b.getULCorner().getX(), b.getULCorner().getY(), b.getWidth(), b.getHeight());
        this.setUpBrickImages();
        this.setUpPowerUpImages();
        this.getStage().getScene().setOnKeyPressed(e -> handleKeyPressed(e.getCode()));

        this.barAnimations = new Image[3];
        this.barAnimations[0] = GameObjectsImages.BAR_ANIMATION_1.getImage();
        this.barAnimations[1] = GameObjectsImages.BAR_ANIMATION_2.getImage();
        this.barAnimations[2] = GameObjectsImages.BAR_ANIMATION_3.getImage();
        this.barAnimationIndex = 0;

        this.frameCounter = 0;

        // Start the game
        this.getController().render();
    }

    /**
     * Set up the images of the bricks.
     */
    public void setUpBrickImages() {
        this.brickImages = new HashMap<>(10);

        for (Integer i = IMAGE_BRICK_OFFSET_START; i < IMAGE_BRICK_OFFSET_END; i++) {
            this.brickImages.put(Integer.valueOf(i + 1), GameObjectsImages.values()[IMAGE_BRICK_SIZE - i].getImage());
        }
    }

    /**
     * Set up the images of the power ups.
     */
    public void setUpPowerUpImages() {
        this.ppImages = new HashMap<>();
        for (Integer i = IMAGE_OFFSET_START; i < IMAGE_OFFSET_END; i++) {
            TypePower t = TypePower.values()[i - IMAGE_BRICK_SIZE];
            Image s = GameObjectsImages.values()[i].getImage();
            this.ppImages.put(t, s);
        }

        Image indestructibleBrick = new Image(GameObjectsImages.RED_BRICK.getFilePath(), 16, 8, true, false);

        this.ppImages.put(TypePower.BIGBALL, GameObjectsImages.BALL.getImage());
        this.ppImages.put(TypePower.SMALLBALL, GameObjectsImages.BALL.getImage());
        this.ppImages.put(TypePower.INDBRICK, indestructibleBrick);

    }

    /**
     * Method to update the game view.
     * 
     * @param score the score of the player updated.
     */
    public void render(final String score) {

        scoreLabel.setText(score);
        lifeLabel.setText(this.getController().getModel().getWorld().getBar().getLife().toString());

        Platform.runLater(() -> {

            this.gcF.clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);

            List<Brick> b = this.getController().getModel().getWorld().getBricks();
            for (Brick item : b) {
                Image i = this.brickImages.get(item.getLife());
                Vector2D p = item.getPosition();
                this.gcF.drawImage(i, p.getX() - BRICK_WIDTH / 2, p.getY() - BRICK_HEIGHT / 2, BRICK_WIDTH,
                        BRICK_HEIGHT);
            }

            List<PowerUp> p = this.getController().getModel().getWorld().getPowerUp();
            for (PowerUp item : p) {
                Image i = this.ppImages.get(item.getPowerUp());
                Vector2D v = item.getPosition();
                this.gcF.drawImage(i, v.getX() - PowerUp.POWERUP_WIDTH / 2, v.getY() - PowerUp.POWERUP_HEIGHT / 2,
                        PowerUp.POWERUP_WIDTH, PowerUp.POWERUP_HEIGHT);
            }

            Bar bar = this.getController().getModel().getWorld().getBar();
            List<Ball> balls = this.getController().getModel().getWorld().getBalls();

            if (this.frameCounter == ANIMATION_TIMER) {
                this.barAnimationIndex = (this.barAnimationIndex + 1) % 3;
                this.frameCounter = 0;
            } else {
                this.frameCounter++;
            }

            this.gcF.drawImage(this.barAnimations[this.barAnimationIndex],
                    bar.getPosition().getX() - bar.getWidth() / 2, bar.getPosition().getY() - bar.getHeight() / 2,
                    bar.getWidth(), bar.getHeight());

            for (Ball item : balls) {
                Image i = GameObjectsImages.BALL.getImage();
                Vector2D v = item.getPosition();
                this.gcF.drawImage(i, v.getX() - item.getRadius(), v.getY() - item.getRadius(), item.getRadius() * 2,
                        item.getRadius() * 2);
            }

        });
    }

    /**
     * Method to switch the view to the game over view.
     */
    public void isOver() {
        ViewSwitcher.getInstance().switchView(getStage(), ViewType.GAMEOVER);
    }

    /**
     * Method to handle the key pressed.
     * 
     * @param keyCode the key pressed.
     */
    public void handleKeyPressed(final KeyCode keyCode) {
        if (keyCode == KeyCode.LEFT) {
            this.getController().getInputController().notifyMoveLeft();
        } else if (keyCode == KeyCode.RIGHT) {
            this.getController().getInputController().notifyMoveRight();
        } else if (keyCode == KeyCode.SPACE) {
            this.getController().toggle();
        }
    }
}
