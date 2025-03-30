package Map;

import Subjects.*;
import Config.Settings;

import java.util.ArrayList;
import java.util.HashMap;

import static Config.Settings.*;


public class Map {

    private final int xMax = MAP_WIDTH;
    private final int yMax = MAP_HEIGHT;
    private HashMap<Coordinate, Entity> map = new HashMap<>();
    private ArrayList<Coordinate> path = new ArrayList<>();

    public Map() {
        filingMap();
        MapTamplate1.fillingMap(this);
    }

    public HashMap<Coordinate, Entity> getMap() {
        return map;
    }

    public boolean isFieldEmpty(Coordinate coordinate) {
        if (this.getMap().containsKey(coordinate)) {
            return false;
        }
        return true;
    }

    public void addEntyty(Coordinate cordinate, Entity entity) {
        map.put(cordinate, entity);
    }

    public Coordinate[] getNeighuds(Coordinate rootCoordinate) {
        Coordinate[] naighuds = new Coordinate[4];

        return naighuds;
    }

    public HashMap<Coordinate, Entity> gemMapCopy() {
        return new HashMap<>(map);
    }


    public ArrayList<Coordinate> getNaighbors(Coordinate rootCoordinate) {
        ArrayList<Coordinate> neighudsCoordinate = new ArrayList<>();
        for (Direction direction : Direction.values()) {
            if (!rootCoordinate.equals(rootCoordinate.getNextStepCoordinate(direction))) {
                neighudsCoordinate.add(rootCoordinate.getNextStepCoordinate(direction));
            }
        }
        return neighudsCoordinate;
    }

    private void filingMap() {
        for (Subjects entity : Subjects.values()) {
            for (int i = entity.getTotalObjects(); i > 0; i--) {
                createSomeEntity(entity.getEntityName());
            }
        }
    }

    private void createSomeEntity(String entityName) {
        Coordinate coordinate = Coordinate.getRandCoordinate(this);
        try {
            Class<?> clazz = Class.forName("Subjects." + entityName);
            var constructor = clazz.getDeclaredConstructor(coordinate.getClass());
            Object entity = constructor.newInstance(coordinate);
            this.map.put(coordinate, (Entity) entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Coordinate> getPath() {
        return path;
    }

    public Entity getEntityByCoordinate(Coordinate coordinate){
    return map.get(coordinate);
    }

    public void setPath(ArrayList<Coordinate> path) {
        this.path = path;
    }
}
