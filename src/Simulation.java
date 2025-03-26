import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import Map.*;
import Subjects.*;
import Config.Settings.*;

import static Config.Settings.*;
import static java.lang.Thread.sleep;

public class Simulation {

    public static void main(String[] args) throws InterruptedException {
        Map map = new Map();
        Herbvore herb1 = new Herbvore(new Coordinate(5, 5));
        Predator pr1 = new Predator(new Coordinate(9, 3));

        map.getMap().put(herb1.getCoordinate(), herb1);
        map.getMap().put(pr1.getCoordinate(), pr1);

        View.createViewMap(map);
        System.out.println(Coordinate.getHeuristicCoast(herb1.getCoordinate(), pr1.getCoordinate()));
        ArrayList<Node> path = herb1.finedPath(map, pr1.getCoordinate());
        System.out.println(path.toString());

        for (int s = 0; s < STEPS; s++) {

        }

    }
}
