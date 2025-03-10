import java.util.HashMap;

import Map.Map;
import Map.Coordinate;
import Subjects.*;
import Config.Settings.*;

import static Config.Settings.*;

public class Simulation {
    public static void main(String[] args) throws InterruptedException {
        Map map = new Map();
            map.filingMap();
        Herbvore herb = new Herbvore(new Coordinate(1,1));
        for (int i = STEPS; i > 0; i--) {
            herb.move(Direction.UP, map);
            herb.move(Direction.RIGHT, map);
            Thread.sleep(1000);
            View.showMap(map);
            View.showEntitys(map);
        }


    }


}
