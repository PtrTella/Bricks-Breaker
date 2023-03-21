package main.model.map;

import java.util.List;
import java.util.Set;

public interface GameMap {

    void LoadMap();

    Set<String> getNamesMap();

    List<Integer> getMap(String name);

    //boolean addMap();

    //boolean removeMap();

}
