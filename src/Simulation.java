import java.util.HashMap;

import Map.Map;
import Map.Coordinate;
import Subjects.*;

import static Config.Settings.*;

public class Simulation {
    public static void main(String[] args) throws InterruptedException {
        Map map = new Map();
        Entity entity = new Herbvore(new Coordinate(0,0));
        addEntity(map, entity);
        View.showMap(map);

        for (int i = STEPS; i > 0; i--) {
            entity.move(Entity.Direction.UP, map);
            entity.move(Entity.Direction.RIGHT, map);

            Thread.sleep(1000);
            View.showMap(map);
            View.showEntitys(map);
        }


    }

    private static void addEntity(Map map, Entity entity) {

        map.getMap().put(entity.getCoordinate(), entity);
    }

}
