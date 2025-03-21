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
        Entity ent = herb1.finedObject(map, 'T');
        System.out.print(ent.getClass());
        System.out.println(ent.getCoordinate());
        for(int s = 0; s<STEPS; s++){

        }

    }
}
