package brickbreaker.model.factory;

import java.util.ArrayList;
import java.util.List;

import brickbreaker.common.P2d;
import brickbreaker.common.V2d;
import brickbreaker.model.gameObjects.Ball;
import brickbreaker.model.gameObjects.Bar;
import brickbreaker.model.gameObjects.Brick;

public class GameFactory {
    
    static private GameFactory instance;
	
	static public GameFactory getInstance(){
		if (instance == null){
			instance = new GameFactory();
		}
		return instance;
	}

	// TODO change posToSet with fixed position at start

    public Ball createBall(P2d posToSet, V2d velToSet){
		return new Ball(posToSet, velToSet);
	}

	public List<Brick> createBricks(List<Integer> list, Integer col, Integer line){
		List<Brick> result = new ArrayList<>();
		Integer life;
		try {
			for( int y = 0; y < line; y++){
				for( int x = 0; x < col; x++){
					if((life = list.get(x+y*col)) > 0 ){
						result.add(new Brick(new P2d(x, y), life));	// <- new P2d(x+spaceLeft, y+spaceTop)
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Size of map not correct");
			e.printStackTrace();
		}
		return result;
	}

    public Bar createBar(P2d posToSet){
		return new Bar(posToSet, 1);
	}
}
