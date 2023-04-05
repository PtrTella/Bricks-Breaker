package main.model;

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

    private Bar bar;
    private Ball ball;
    private List<Brick> bricks;
    private List<PowerUp> powerUps;
    private WorldEventListener listener;

    @Override
    public void setEventListener(final WorldEventListener listener) {
        this.listener = listener;
    }

    @Override
    public void updateGame(final int elapsed) {
        //TODO: Check if the update loop is useless.
    }

    @Override
    public void checkCollision() {
        RectBoundingBox barBox = this.bar.getBBox();

        for(PowerUp p : this.powerUps) {
            if(p.getBBox().isCollidingWith(barBox.getP2d(), barBox.getWidth(), barBox.getHeight())) {
                this.listener.notifyEvent(new HitPowerUp(p));
            }
        }

        for(Brick b : this.bricks) {
            if (b.getBBox().isCollidingWith(this.ball.getPosition(), this.ball.getBBox().getRadius())) {
                this.listener.notifyEvent(new HittedBrickEvent(b));
            }
        }
    }

    @Override
    public void checkBoundary() {

    }

    @Override
    public List<Brick> getBricks() {
        return this.getBricks();
    }
    
}
