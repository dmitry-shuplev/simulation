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
        View.createViewMap(map);
        Herbvore herb1 = new Herbvore(new Coordinate(22, 3));
        Predator pr1 = new Predator(new Coordinate(5,5));
        map.getMap().put(herb1.getCoordinate(), herb1);
        map.getMap().put(pr1.getCoordinate(), pr1);


        ArrayList<Node> path = new ArrayList<>();
            path = pr1.finedPath2(map, herb1);
            for(Node node:path){
                System.out.println(node);
            }


        View.updateMap(map);

       // System.out.println(pr1.finedObject(map, 'H').toString());


        for (int i = 0; i < STEPS; i++) {
//Здесь основной цикл программы

        }
        System.out.println("Закончено");


    }
}
