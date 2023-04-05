package main.model;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import main.controllers.state.event.HittedBrickEvent;
import main.common.P2d;
import main.controllers.state.event.HitPowerUp;
import main.controllers.state.event.WorldEventListener;
import main.model.gameObjects.Ball;
import main.model.gameObjects.Bar;
import main.model.gameObjects.Brick;
import main.model.gameObjects.PowerUp;
import main.model.gameObjects.TypePower;
import main.model.gameObjects.bounding.RectBoundingBox;

public class WorldImpl implements World {

    private List<Ball> balls;
    private Bar bar;
    private List<Brick> bricks;
    private List<PowerUp> activePowerUps;
    private RectBoundingBox mainBBox;
	private WorldEventListener evListener;

    public WorldImpl(final RectBoundingBox bbox, final Ball ballToSet, 
                    final Bar barToSet, final List<Brick> bricks, final List<TypePower> powerUps) {
        this.balls.add(ballToSet);
        this.bar = barToSet;
        this.bricks.addAll(bricks);
        randomPowerUpAssignament(bricks, powerUps);
        this.mainBBox = bbox;
    }

    // adding TypePower randomly to bricks
    private void randomPowerUpAssignament(List<Brick> b, List<TypePower> p){
        Integer diff = b.size() - p.size();
        Random random = new Random();
        if(diff > 0){
            p.addAll(Collections.nCopies(diff, TypePower.NULL));
        }
        for(Brick brick : b){
            brick.setPowerUp(p.remove(random.nextInt(p.size())));
        }
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
        //return this.balls.size();
    }

    @Override
    public Integer getNumBalls(){
        return this.balls.size();
    }

    @Override
    public Bar getBar() {
        return this.bar;
    }

    @Override
    public void removeBrick(Brick brick){
        this.bricks.remove(brick);
        if(brick.getPowerUp() != TypePower.NULL){
            // TODO choose width and height of power up
            this.activePowerUps.add(new PowerUp(brick.getBBox().getP2d(), null, null, brick.getPowerUp()));
        }
        //return this.bricks.size();
    }

    @Override
    public Integer getNumBricks(){
        return this.bricks.size();
    }

    @Override
    public void updateGame(final int elapsed) {
        //TODO: Check if the update loop is useless.
    }

    @Override
    public void checkCollision() {
        RectBoundingBox barBox = this.bar.getBBox();
        P2d ul = mainBBox.getULCorner(mainBBox.getP2d(), mainBBox.getWidth(), mainBBox.getHeight());
		P2d br = mainBBox.getBRCorner(mainBBox.getP2d(), mainBBox.getWidth(), mainBBox.getHeight());

        // Power up collision with bar
        for(PowerUp p : this.activePowerUps){
            if(p.getBBox().isCollidingWith(barBox.getP2d(), barBox.getWidth(), barBox.getHeight())){
                this.evListener.notifyEvent(new HitPowerUp(p));
            }
        }

        for(Ball ball : this.balls){
            
            P2d pos = ball.getPosition();
            Double r = ball.getRadius();

            // TODO one or the other
            
            // brick collision with balls
            for(Brick b : this.bricks) {
                if (b.getBBox().isCollidingWith(pos, r)){
                    this.evListener.notifyEvent(new HittedBrickEvent(b));
                }
            }

            // ball collision with border
            if(pos.getY() + r > ul.getY()){
                // collion with TOP
            } else if(pos.getY() - r < br.getY()){
                // collion with BOTTOM
            } else if(pos.getX() + r > br.getX()){
                // collion with RIGHT
            } else if(pos.getX() -r < ul.getX()){
                // collision with LEFT
            }
        }
        
    }

    @Override
    public void checkBoundary() {}
    
}
