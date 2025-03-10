package Map;

import Config.Settings;
import Subjects.*;
import Config.Settings.*;

import java.util.HashMap;

import static Config.Settings.*;


public class Map {

    private final int xMax = X_MAX;
    private final int yMax = Y_MAX;
    private HashMap<Coordinate, Entity> map = new HashMap<>();

    public HashMap<Coordinate, Entity> getMap() {
        return map;
    }

    public void filingMap() {
        for (int i = TOTAL_HERBVORE; i > 0; i--) {
            Herbvore herb = cerateHerbvore();
            this.map.put(herb.getCoordinate(), herb);
        }

    }

    private Herbvore cerateHerbvore() {
        Herbvore herb = new Herbvore(Coordinate.getRandCoordinate(this));
        return herb;
    }


    public boolean isFieldEmpty(Coordinate coordinate) {
        if (this.getMap().containsKey(coordinate)) {
            return false;
        }
        return true;
    }


}
