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

        ArrayList<Coordinate> path = new ArrayList<>();

        Random rand = new Random();

        for (int i = 0; i < STEPS; i++) {
            map.getPath().clear();
            pr1.motheToPerpous(map);
            herb1.motheToPerpous(map);
            herb1.move(Direction.values()[rand.nextInt(4)], map);
            path = pr1.findPath(map, herb1.getCoordinate());

            for (Coordinate coordinate: path) {
                map.getPath().add(coordinate);
            }
            View.updateMap(map);
            sleep(1000);
//Здесь основной цикл программы
        }


        System.out.println("Закончено");
        //  System.exit(0);
    }
}
