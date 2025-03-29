import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import Config.Settings;
import Map.*;
import Subjects.*;
import Config.Settings.*;

import static Config.Settings.*;
import static java.lang.Thread.sleep;

public class Simulation {

    public static void main(String[] args) throws InterruptedException {
        Map map = new Map();
        View.createViewMap(map);
        Herbvore herb1 = new Herbvore(Coordinate.getRandCoordinate(map));
        Predator pr1 = new Predator(Coordinate.getRandCoordinate(map));
        map.getMap().put(herb1.getCoordinate(), herb1);
        map.getMap().put(pr1.getCoordinate(), pr1);

        ArrayList<Node> path = new ArrayList<>();

        Random rand = new Random();

        for (int i = 0; i < STEPS; i++) {
            map.getPath().clear();
            pr1.move(Direction.values()[rand.nextInt(4)], map);
            herb1.move(Direction.RIGHT, map);
            herb1.move(Direction.values()[rand.nextInt(4)], map);
            path = pr1.finedPath2(map, herb1);

            for (Node node : path) {
                map.getPath().add(node.getCoordinate());
            }
            View.updateMap(map);
            sleep(1000);
//Здесь основной цикл программы
        }


        System.out.println("Закончено");
        //  System.exit(0);
    }
}
