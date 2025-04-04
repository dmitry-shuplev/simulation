package Map;

import Subjects.*;
import java.util.ArrayList;
import java.util.HashMap;
import static Config.Settings.*;


public class Map {

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
       return !this.getMap().containsKey(coordinate);
    }

    public void addEntity(Coordinate cordinate, Entity entity) {
        if(this.isFieldEmpty(cordinate))
        {
        map.put(cordinate, entity);}
    }

    public void removeEntity(Coordinate coordinate) {
        this.getMap().remove(coordinate);
    }

    public HashMap<Coordinate, Entity> getMapCopy() {
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

    public void clearMap() {
        for (Entity entity : this.getMapCopy().values()) {
            if (entity.getLife() <= 0) {
                map.remove(entity.getCoordinate());
            }
        }
    }

    public ArrayList<Coordinate> getPath() {
        return path;
    }

    public void setPath(ArrayList<Coordinate> path) {
        this.path = path;
    }

    public Entity getEntityByCoordinate(Coordinate coordinate) {
        return map.get(coordinate);
    }




}
