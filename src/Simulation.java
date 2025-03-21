import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import Map.Map;
import Map.Coordinate;
import Subjects.*;
import Config.Settings.*;

import static Config.Settings.*;
import static java.lang.Thread.sleep;

public class Simulation {

    public static void main(String[] args) throws InterruptedException {
        Map map = new Map();
        Herbvore herb1 = new Herbvore(new Coordinate(5,5));
        map.getMap().put(herb1.getCoordinate(), herb1);
        View.createViewMap(map);
        Random random = new Random();
        for(int s = 0; s<STEPS; s++){
            herb1.move(Direction.values()[random.nextInt(4)], map);
            herb1.move(Direction.values()[random.nextInt(4)], map);
          View.updateMap(map);
          sleep(2000);
            System.out.println(herb1.getCoordinate().toString());
            System.out.println(map.getMap().size());
        }

    }
}
