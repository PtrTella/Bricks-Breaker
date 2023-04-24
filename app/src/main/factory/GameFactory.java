package main.factory;

import java.util.ArrayList;
import java.util.List;

import main.common.P2d;
import main.common.V2d;
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

    public Ball createBall(P2d posToSet, V2d velToSet){
		return new Ball(posToSet, velToSet);
	}

	public List<Brick> createBricks(List<Integer> list, Integer col, Integer line){
		List<Brick> result = new ArrayList<>();
		try {
			for( int y = 0; y < line; y++){
				for( int x = 0; x < col; x++){
					result.add(new Brick(new P2d(x+1, y+1), list.get(x+y*col)));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

    public Bar createBar(P2d posToSet, V2d velToSet){
		return new Bar(posToSet, velToSet, 1);
	}
}
