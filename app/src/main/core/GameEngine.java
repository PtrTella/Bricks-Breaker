package main.core;

import main.model.GameState;

public class GameEngine {
    
    private long period = 20;
    private GameState gameState;

    public GameEngine(){}

    public void initGame(){
        System.out.println("initGame - End");
		//gameState = new GameState(this);
        //controller
        //view
    }

    public void mainLoop(){
		long previousCycleStartTime = System.currentTimeMillis();
		while (!gameState.isGameOver()) {
			long currentCycleStartTime = System.currentTimeMillis();
			long elapsed = currentCycleStartTime - previousCycleStartTime;
			processInput();
			updateGame(elapsed);
			render();
			waitForNextFrame(currentCycleStartTime);
			previousCycleStartTime = currentCycleStartTime;
		}
	}

    protected void waitForNextFrame(long cycleStartTime){
		long dt = System.currentTimeMillis() - cycleStartTime;
		if (dt < period){
			try {
				Thread.sleep(period - dt);
			} catch (Exception ex){}
		}
	}

    protected void processInput(){}

    protected void updateGame(long elapsed){}

    protected void render(){
		//view.render();
	}
}
