package brickbreaker.model.world;

import java.util.List;
import java.util.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import brickbreaker.common.TypePower;
import brickbreaker.common.TypePowerUp;
import brickbreaker.common.Vector2D;
import brickbreaker.model.factory.ApplicatorFactory;
import brickbreaker.model.world.gameObjects.Ball;
import brickbreaker.model.world.gameObjects.Bar;
import brickbreaker.model.world.gameObjects.Brick;
import brickbreaker.model.world.gameObjects.PowerUp;
import brickbreaker.model.world.gameObjects.bounding.RectBoundingBox;
import brickbreaker.model.world.gameObjects.collision.WorldEvent;
import brickbreaker.model.world.gameObjects.collision.powerUpApplicator.PowerUpApplicator;

/**
 * {@inheritDoc}
 * Implements the {@link World} interface.
 */
public class WorldImpl implements World {

    /**
     * Indicates on which side the collision occurred.
     */
    public enum SideCollision {
        /** Top side. */
        TOP,
        /** Bottom side. */
        BOTTOM,
        /** Left side. */
        LEFT,
        /** Right side. */
        RIGHT;
    }

    private List<Ball> balls;
    private Bar bar;
    private List<Brick> bricks;
    private List<PowerUp> powerUps;
    private RectBoundingBox mainBBox;
    private Map<PowerUpApplicator, Integer> activePowerUps;
    private WorldEvent event;
    private ApplicatorFactory factory;
    private Integer score;
    private boolean destructibleBrick;

    private final Double mulELAPSED = 0.001;
    private final Integer brickScore = 100;

    /**
     * World constructor.
     * 
     * @param mainBbox the main bounding box of the world.
     */
    public WorldImpl(final RectBoundingBox mainBbox) {
        this.balls = new ArrayList<>();
        this.bricks = new ArrayList<>();
        this.powerUps = new ArrayList<>();
        this.mainBBox = mainBbox;
        this.activePowerUps = new HashMap<>();
        this.score = 0;
        this.event = new WorldEvent();
        this.factory = new ApplicatorFactory();
        destructibleBrick = true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addBall(final Ball ball) {
        this.balls.add(ball);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Ball> getBalls() {
        return this.balls;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Bar getBar() {
        return this.bar;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBar(final Bar bar) {
        this.bar = bar;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addBricks(final List<Brick> bricks) {
        this.bricks.addAll(bricks);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Brick> getBricks() {
        return this.bricks;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PowerUp> getPowerUp() {
        return this.powerUps;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RectBoundingBox getMainBBox() {
        return this.mainBBox;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateGame(final int elapsed) {
        balls.stream().forEach(t -> t.setPosition(t.getPosition().sum(t.getSpeed().mul(mulELAPSED * elapsed))));
        powerUps.stream().forEach(t -> t.setPosition(t.getPosition().sum(t.getSpeed().mul(mulELAPSED * elapsed))));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void checkCollision() {
        checkCollisionWithPowerUp();
        checkCollisionWithBall();
        disablePowerUp();
    }

    /*
     * Ball collsion with boundary
     * Ball collision with bar
     * Ball collision with bricks
     */
    private void checkCollisionWithBall() {
        Vector2D ul = mainBBox.getULCorner();
        Vector2D br = mainBBox.getBRCorner();

        Iterator<Ball> ballIt = balls.iterator();
        while (ballIt.hasNext()) {
            Ball ball = ballIt.next();
            Vector2D pos = ball.getPosition();
            Double r = ball.getRadius();

            if (pos.getY() - r < ul.getY()) {
                // TOP-BORDER
                this.event.process(ball, SideCollision.TOP, ul.getY());
            } else if (pos.getY() + r > br.getY()) {
                // BOTTOM-BORDER
                ballIt.remove();
                if (this.balls.size() <= 0) {
                    this.bar.decLife();
                }
            } else if (pos.getX() - r < ul.getX()) {
                // LEFT-BORDER
                this.event.process(ball, SideCollision.LEFT, ul.getX());
            } else if (pos.getX() + r > br.getX()) {
                // RIGHT-BORDER
                this.event.process(ball, SideCollision.RIGHT, br.getX());
            } else if (bar.getBBox().isCollidingWith(ball.getBBox())) {
                // BAR
                this.event.process(ball, this.bar);
            } else {
                // BRICK
                Iterator<Brick> brickIt = bricks.iterator();
                boolean found = true;
                while (brickIt.hasNext()) {
                    Brick brick = brickIt.next();
                    if (brick.getBBox().isCollidingWith(ball.getBBox())) {
                        if (found) {
                            this.event.process(ball, brick);
                            found = false;
                        }
                        if (destructibleBrick) {
                            brick.decLife();
                            if (brick.getLife() <= 0) {
                                if (brick.getPowerUp() != TypePower.NULL) {
                                    this.powerUps.add(new PowerUp(brick.getBBox().getP2d(), brick.getPowerUp()));
                                }
                                brickIt.remove();
                                this.addToScore(brickScore);
                            }
                        }
                    }
                }
            }
        }
    }

    /*
     * Power up collision with bar
     */
    private void checkCollisionWithPowerUp() {
        Iterator<PowerUp> powerIt = powerUps.iterator();
        while (powerIt.hasNext()) {
            PowerUp p = powerIt.next();
            if (p.getPosition().getY() + p.getHeight() / 2 > mainBBox.getBRCorner().getY()) {
                powerIt.remove();
            } else if (p.getBBox().isCollidingWith(bar.getBBox())) {
                Boolean type = p.getPowerUp().getType().equals(TypePowerUp.POSITIVE);
                this.factory.createApplicator(p.getPowerUp(), type).applyPowerUp(this);
                if (p.getPowerUp().getDuration() > 0) {
                    this.activePowerUps.put(
                            this.factory.createApplicator(p.getPowerUp(), !type),
                            p.getPowerUp().getDuration());
                }
                powerIt.remove();
            }
        }
    }

    private void disablePowerUp() {
        Iterator<Map.Entry<PowerUpApplicator, Integer>> iterator = activePowerUps.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<PowerUpApplicator, Integer> entry = iterator.next();
            PowerUpApplicator key = entry.getKey();
            int value = entry.getValue() - 1;
            if (value <= 0) {
                key.applyPowerUp(this);
                iterator.remove();
            } else {
                entry.setValue(value);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getScore() {
        return this.score;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void addToScore(final Integer value) {
        this.score += value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDestructibleBrick(final boolean b) {
        this.destructibleBrick = b;
    }

}
