package game_map;

import subjects.*;
import java.util.ArrayList;
import java.util.HashMap;
import static config.Settings.*;


public class GameMap {

    private HashMap<Coordinate, Entity> entities = new HashMap<>();
    private ArrayList<Coordinate> path = new ArrayList<>();

    public GameMap() {
        filingMap();
        MapTamplate.fillingMap(this);
    }

    public HashMap<Coordinate, Entity> getMap() {
        return entities;
    }
    public HashMap<Coordinate, Entity> getMapCopy() {
        return new HashMap<>(entities);
    }


    public boolean isFieldEmpty(Coordinate coordinate) {
       return !this.getMap().containsKey(coordinate);
    }

    public void addEntity(Coordinate cordinate, Entity entity) {
        if(this.isFieldEmpty(cordinate))
        {
            entities.put(cordinate, entity);}
    }

    public void removeEntity(Coordinate coordinate) {
        this.getMap().remove(coordinate);
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
            Class<?> clazz = Class.forName("subjects." + entityName);
            var constructor = clazz.getDeclaredConstructor(coordinate.getClass());
            Object entity = constructor.newInstance(coordinate);
            this.entities.put(coordinate, (Entity) entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearMap() {
        for (Entity entity : this.getMapCopy().values()) {
            if (entity.getLife() <= 0) {
                entities.remove(entity.getCoordinate());
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
        return entities.get(coordinate);
    }




}
