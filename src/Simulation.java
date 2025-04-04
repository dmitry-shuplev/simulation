import java.util.ArrayList;


import Map.*;
import Subjects.*;

import static Config.Settings.*;
import static java.lang.Thread.sleep;

public class Simulation {

    public static void main(String[] args) throws InterruptedException {
        Map map = new Map();
        View.createViewMap(map);

        ArrayList<Coordinate> path = new ArrayList<>();

        for (int i = 0; i < STEPS; i++) {
            map.getPath().clear();

           /*
           Этот код может показывать проложенный путь. использовался для настройки алгоритма поиска пути.
           path = pr1.findPath(map, preyCoordinate);
            for (Coordinate coordinate : path) {
                map.getPath().add(coordinate);
            }
          */
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
