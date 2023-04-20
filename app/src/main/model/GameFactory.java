package main.model;

import java.util.List;

import main.model.gameObjects.Ball;
import main.model.gameObjects.Bar;
import main.model.gameObjects.Brick;

public class GameFactory {
    
    static private GameFactory instance;
	
	static public GameFactory getInstance(){
		if (instance == null){
			instance = new GameFactory();
		}
		return instance;
	}

    public Ball createBall(){
		return null;
	}

	public List<Brick> createBricks(String nameMap){
		return null;
	}

    private Brick createBrick(){
		return null;
	}

    public Bar createBar(){
		return null;
	}
}
