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

        ArrayList<Coordinate> path = new ArrayList<>();

        for (int i = 0; i < STEPS; i++) {
            map.getPath().clear();

           /*path = pr1.findPath(map, preyCoordinate);
            for (Coordinate coordinate : path) {
                map.getPath().add(coordinate);
            }

            */
            boolean movedToPrey;
            int counte = 0;
            for (var entity : map.getMapCopy().values()) {

                if (entity.getClass().equals(Herbvore.class) || (entity.getClass().equals(Predator.class))) {
                    ((Creature) entity).moveToPrey(map);
                    ((Creature) entity).eat(map);
                }

            }

            Grass g =new Grass(Coordinate.getRandCoordinate(map));
            map.addEntity(g.getCoordinate(), g);

            map.clearMap();
            View.updateMap(map);
            sleep(1000);
//Здесь основной цикл программы
        }


        System.out.println("Закончено");
        //  System.exit(0);
    }
}
