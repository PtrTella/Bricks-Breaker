package main.model;

import java.util.ArrayList;
import java.util.List;

public class World {
    
    private List<GameObject> ball;
    private List<Brick> brick;
    private GameObject bar;
    private List<GameObject> powerUp;

    public World(){
        ball = new ArrayList<GameObject>();
        brick = new ArrayList<Brick>();
        powerUp = new ArrayList<GameObject>();
    }

    public void updateState(long dt){}
}
