package main.model;

import main.core.GameFactory;

public class GameState {
    
    //private int score;	depends on type of game
	private World world;

    public GameState(){

        GameFactory f = GameFactory.getInstance();
		
        world = new World();
        //world.add();
    }

    public World getWorld(){
		return world;
	}

    public boolean isGameOver(){
		return true;
	}

    public void update(int dt){
		world.updateState(dt);
	}
}
