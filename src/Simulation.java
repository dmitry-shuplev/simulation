import java.util.HashMap;
import Map.Map;
import Map.Coordinate;
import Subjects.*;

public class Simulation {
    public static void main(String[] args) {
        Map map = new Map();
        Entity entity = new Herbvore(new Coordinate(1,1));
        addEntity(map, entity);

        View.showMap(map);
    }

private static void addEntity(Map map, Entity entity){
        map.getMap().put(entity.getCoordinate(), entity);
}

}
