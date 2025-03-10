package Map;

import Config.Settings;
import Subjects.*;
import Config.Settings.*;

import java.util.HashMap;

import static Config.Settings.X_MAX;
import static Config.Settings.Y_MAX;


public class Map {

    private final int xMax = X_MAX;
    private final int yMax = Y_MAX;
    private HashMap<Coordinate, Entity> map = new HashMap<>();

    public HashMap<Coordinate, Entity> getMap()
    {
        return map;
    }

    public void filingMap(){

    }

    public boolean isFieldEmpty(Coordinate coordinate){
        if(this.getMap().containsKey(coordinate)){return false;}
        return true;
    }
}
