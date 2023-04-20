package main.model;

import java.util.ArrayList;
import java.util.List;

import main.controllers.state.event.HitBrick;
import main.common.P2d;
import main.controllers.state.event.HitBar;
import main.controllers.state.event.HitBorder;
import main.controllers.state.event.HitPowerUp;
import main.controllers.state.event.WorldEventListener;
import main.model.gameObjects.Ball;
import main.model.gameObjects.Bar;
import main.model.gameObjects.Brick;
import main.model.gameObjects.PowerUp;
import main.model.gameObjects.TypePower;
import main.model.gameObjects.bounding.RectBoundingBox;

public class WorldImpl implements World {

    public static enum TypeObj { BALL, BRICK, BAR, POWERUP }
    public enum SideCollision { TOP, BOTTOM, LEFT, RIGHT }

    private List<Ball> balls;
    private Bar bar;
    private List<Brick> bricks;
    private List<PowerUp> activePowerUps;
    private RectBoundingBox mainBBox;
	private WorldEventListener evListener;

    // TODO add obj nel gameState
    public WorldImpl(final RectBoundingBox mainBbox) {
        this.balls = new ArrayList<>();
        this.bricks = new ArrayList<>();
        this.activePowerUps = new ArrayList<>();
        this.mainBBox = mainBbox;
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
    public Integer getNumBalls(){
        return this.balls.size();
    }

    @Override
    public Bar getBar() {
        return this.bar;
    }

    @Override
    public void setBar(Bar bar){
        this.bar = bar;
    }

    @Override
    public void addBricks(List<Brick> bricks){
        this.bricks.addAll(bricks);
    }

    @Override
    public void removeBrick(Brick brick){
        if(brick.getPowerUp() != TypePower.NULL){
            this.activePowerUps.add(new PowerUp(brick.getBBox().getP2d(), brick.getPowerUp()));
        }
        this.bricks.remove(brick);
    }

    @Override
    public List<Brick> getBricks(){
        return this.bricks;
    }

    @Override
    public void updateGame(final int elapsed) {
        //TODO: Check if the update loop is useless.
    }

    @Override
    public void checkCollision() {
        checkCollisionWithBall();
        checkCollisionWithPowerUp();
    }
    
    /*
     * Ball collsion with boundary
     * Ball collision with bar
     * Ball collision with bricks
     */
    private void checkCollisionWithBall(){
        P2d ul = mainBBox.getULCorner();
		P2d br = mainBBox.getBRCorner();
        
        for(Ball ball : this.balls){
            P2d pos = ball.getPosition();
            Double r = ball.getRadius();
            
            if(pos.getY() - r < ul.getY()){
                this.evListener.notifyEvent(new HitBorder(ball, SideCollision.TOP, ul.getY()));      //TOP-BORDER
            } else if(pos.getY() + r > br.getY()){
                this.evListener.notifyEvent(new HitBorder(ball, SideCollision.BOTTOM, br.getY()));   //BOTTOM-BORDER
            } else if(pos.getX() - r < ul.getX()){
                this.evListener.notifyEvent(new HitBorder(ball, SideCollision.LEFT, ul.getX()));     //LEFT-BORDER
            }else if(pos.getX() + r > br.getX()){
                this.evListener.notifyEvent(new HitBorder(ball, SideCollision.RIGHT, br.getX()));    //RIGHT-BORDER
            }else if(bar.getBBox().isCollidingWith(ball.getBBox())){
                this.evListener.notifyEvent(new HitBar(ball));                                  //BAR
            }else{
                for(Brick b : this.bricks) {                                                //BRICK
                    if (b.getBBox().isCollidingWith(ball.getBBox())){
                        this.evListener.notifyEvent(new HitBrick(b,ball));
                    }
                }
            }
        }
    }
    
    /*
     * Power up collision with bar
     */
    private void checkCollisionWithPowerUp(){
        for(PowerUp p : this.activePowerUps){
            
            if(p.getPosition().getY() - p.getHeight()/2 < mainBBox.getBRCorner().getY()){
                this.activePowerUps.remove(p);
            }else if(p.getBBox().isCollidingWith(bar.getBBox())){
                this.evListener.notifyEvent(new HitPowerUp(p));
                this.activePowerUps.remove(p);
            }
        }
    }

}
