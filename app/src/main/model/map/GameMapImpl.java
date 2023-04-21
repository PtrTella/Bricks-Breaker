package main.model.map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameMapImpl implements GameMap {
    
    static private GameMapImpl instance;
    private final String sep;
    private final String path;
    
    private List<Integer> currentMap;
    private String mapName;

    static public GameMapImpl getInstance(){
		if (instance == null){
			instance = new GameMapImpl();
		}
		return instance;
	}

    public GameMapImpl(){
        this.currentMap = new ArrayList<Integer>();
        this.mapName = "";
        this.sep = File.separator + File.separator;
        this.path ="." + sep + "app" + sep + "src" + sep + "main" + sep + "resources" + sep + "mapsFile";
    }

    @Override
    public List<String> getNamesMap() {
        return Arrays.asList(new File(path).list());
    }

    @Override
    public List<Integer> LoadMap(String fileName) {
        if(!this.mapName.equals(fileName)){
            currentMap.clear();
            try (Scanner sc = new Scanner(new File(path + sep + fileName))) {
                while(sc.hasNextInt()){
                    currentMap.add(sc.nextInt());
                }
                sc.close();
                this.mapName = fileName;
            } catch (FileNotFoundException e) {
                this.mapName = "";
                e.printStackTrace();
                return List.of();
            }
        }
        return this.currentMap;
    }

}
