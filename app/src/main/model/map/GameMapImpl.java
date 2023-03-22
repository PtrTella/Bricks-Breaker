package main.model.map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class GameMapImpl implements GameMap {
    
    private Map<String, List<Integer>> maps = new HashMap<String, List<Integer>>();

    final String path ="." + File.separator + File.separator + "app" + File.separator + File.separator +
                    "src" + File.separator + File.separator + "main" + File.separator + File.separator +
                    "resources" + File.separator + File.separator + "mapsFile";

    public GameMapImpl(){}

    //To optimize Do this loop with a different thread
    @Override
    public void LoadMap() {
        List<Integer> list;
        for(String f : Arrays.asList(new File(path).list())){
            list = new ArrayList<Integer>();
            try (Scanner sc = new Scanner(new File(path + File.separator + File.separator + f))) {
                while(sc.hasNextInt()){
                    list.add(sc.nextInt());
                }
                maps.put(f,list);
                sc.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Set<String> getNamesMap() {
        return maps.keySet();
    }

    @Override
    public List<Integer> getMap(String name) {
        return maps.get(name);
    }

}
