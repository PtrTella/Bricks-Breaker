package main.model;

import java.util.ArrayList;
import java.util.List;

import main.controllers.state.event.HittedBrickEvent;
import main.controllers.state.event.HitPowerUp;
import main.controllers.state.event.WorldEventListener;
import main.model.gameObjects.Ball;
import main.model.gameObjects.Bar;
import main.model.gameObjects.Brick;
import main.model.gameObjects.PowerUp;
import main.model.gameObjects.bounding.RectBoundingBox;

public class WorldImpl implements World {

    private List<Ball> balls;
    private Bar bar;
    private List<Brick> bricks;
    private List<PowerUp> powerUps;
    private RectBoundingBox mainBBox;
	private WorldEventListener evListener;

    public WorldImpl(final RectBoundingBox bbox) {
        this.balls = new ArrayList<Ball>();
        this.bricks = new ArrayList<Brick>();
        this.powerUps = new ArrayList<PowerUp>();
        this.mainBBox = bbox;
    }

    @Override
    public void setEventListener(final WorldEventListener listener) {
        this.evListener = listener;
    }

    @Override
    public void addBall(Ball ball) {
        this.balls.add(ball);
    }

    @Override
    public void removeBall(Ball ball) {
        this.balls.remove(ball);
    }

    @Override
    public List<Ball> getBalls() {
        return this.balls;
    }

    @Override
    public void setBar(Bar barToSet) {
        this.bar = barToSet;
    }

    @Override
    public Bar getBar() {
        return this.bar;
    }

    @Override
    public void setBricks(List<Brick> brickToSet) {
        this.bricks.addAll(brickToSet);
    }

    @Override
    public void removeBrick(Brick brick){
        this.bricks.remove(brick);
    }

    @Override
    public List<Brick> getBricks() {
        return this.bricks;
    }

    @Override
    public void setPowerUps(List<PowerUp> powerUpToSet) {
        this.powerUps.addAll(powerUpToSet);
    }

    public void removePowerUp(PowerUp powerUp){
        this.powerUps.remove(powerUp);
    }

    @Override
    public List<PowerUp> getPowerUps() {
        return this.powerUps;
    }

    @Override
    public void updateGame(final int elapsed) {
        //TODO: Check if the update loop is useless.
    }

    @Override
    public void checkCollision() {
        RectBoundingBox barBox = this.bar.getBBox();

        for(PowerUp p : this.powerUps){
            if(p.getBBox().isCollidingWith(barBox.getP2d(), barBox.getWidth(), barBox.getHeight())){
                this.evListener.notifyEvent(new HitPowerUp(p));
            }
        }

        for(Ball ball : this.balls){
            for(Brick b : this.bricks) {
                if (b.getBBox().isCollidingWith(ball.getPosition(), ball.getBBox().getRadius())){
                    this.evListener.notifyEvent(new HittedBrickEvent(b));
                }
            }
        }
        
    }

    @Override
    public void checkBoundary() {}
    
}
