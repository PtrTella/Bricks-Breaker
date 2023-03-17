package main.core;

public class GameFactory {
    
    static private GameFactory instance;
	
	static public GameFactory getInstance(){
		if (instance == null){
			instance = new GameFactory();
		}
		return instance;
	}

    //public GameObject createBall(){}

    //public GameObject createBrick(){}

    //public GameObject createBar(){}

	//public GameObject createPowerUp(){}
}
