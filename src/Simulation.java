import java.util.ArrayList;
import java.util.Map;

import game_map.*;
import subjects.*;
import view.View;

import static config.Settings.*;
import static java.lang.Thread.sleep;

public class Simulation {

    public static void main(String[] args) throws InterruptedException {
        GameMap map = new GameMap();
        View.createViewMap(map);

        ArrayList<Coordinate> path = new ArrayList<>();

        for (int i = 0; i < STEPS; i++) {
            map.getPath().clear();

            nextTurn(map);
           /*
           Этот код может показывать проложенный путь. использовался для настройки алгоритма поиска пути.
           path = pr1.findPath(map, preyCoordinate);
            for (Coordinate coordinate : path) {
                map.getPath().add(coordinate);
            }
          */

            Grass g =new Grass(map.getRandCoordinate());
            map.addEntity(g.getCoordinate(), g);


//Здесь основной цикл программы
        }


        System.out.println("Закончено");
        //  System.exit(0);
    }


    private static void nextTurn(GameMap map) throws InterruptedException {
        for (var entity : map.getMapCopy().values()) {

            if (entity instanceof Herbvore) {
                ((Herbvore) entity).moveToPrey(map);
            }
            if(entity instanceof Predator){
                ((Predator) entity).moveToPrey(map);
            }
            View.updateMap(map);
            if (entity instanceof Herbvore) {
                ((Herbvore) entity).eat(map);
            }
            if(entity instanceof Predator){
                ((Predator) entity).eat(map);
            }

        }

        map.clearMap();
        View.updateMap(map);
       sleep(500);
    }
}
