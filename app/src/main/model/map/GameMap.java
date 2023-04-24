package main.model.map;

import java.util.List;

public interface GameMap {

    /* return a List of maps name in the directory */
    List<String> getNamesMap();
    
    /* 
     *  Return a map, if new: load the new map, else return the same in memory.
     *  If name map is absent catch exception and return an empty list.
     *  If size map is not correct return an empty list
     */
    List<Integer> LoadMap(String name);

    //boolean addMap();

    //boolean removeMap();

}
