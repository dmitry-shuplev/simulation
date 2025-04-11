package game_map;

import subjects.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

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
        if (this.isFieldEmpty(cordinate)) {
            entities.put(cordinate, entity);
        }
    }

    public void removeEntity(Coordinate coordinate) {
        this.getMap().remove(coordinate);
    }

    public ArrayList<Coordinate> getNaighbors(Coordinate rootCoordinate) {
        ArrayList<Coordinate> neighudsCoordinate = new ArrayList<>();
        for (Direction direction : Direction.values()) {
            Coordinate naighborCoordinate = getNextStepCoordinate(direction, rootCoordinate);
            if (!rootCoordinate.equals(naighborCoordinate)) {
                neighudsCoordinate.add(naighborCoordinate);
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
        Coordinate coordinate = this.getRandCoordinate();
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

    public static int getHeuristicCoast(Coordinate start, Coordinate finish) {
        return (Math.abs(finish.x - start.x) + Math.abs(finish.y - start.y) - 1) * 10;
    }

    public Coordinate getRandCoordinate() {
        Random rand = new Random();
        int x = rand.nextInt(0, MAP_WIDTH - 1);
        int y = rand.nextInt(0, MAP_HEIGHT - 1);
        Coordinate coordinate = new Coordinate(x, y);
        if (!this.isFieldEmpty(coordinate)) {
            getRandCoordinate();
        }
        return coordinate;
    }

    public Coordinate getNextStepCoordinate(Direction dir, Coordinate rootCoordinate) {
        Coordinate coordinate = new Coordinate(rootCoordinate.x, rootCoordinate.y);
        switch (dir) {
            case UP:
                coordinate.y -= 1;
                break;
            case DOWN:
                coordinate.y += 1;
                break;
            case LEFT:
                coordinate.x -= 1;
                break;
            case RIGHT:
                coordinate.x += 1;
                break;
        }
        return isCoordinateCorrect(coordinate)? coordinate:rootCoordinate;
    }

    public boolean isCoordinateCorrect(Coordinate coordinate) {
        return coordinate.x >= 0 && coordinate.y >= 0 && coordinate.x < MAP_WIDTH && coordinate.y < MAP_HEIGHT;
    }

    public Direction getDirection(Coordinate current, Coordinate destinatinon) {
        if (current.x == destinatinon.x && current.y < destinatinon.y) {
            return Direction.DOWN;
        } else if (current.x == destinatinon.x && current.y > destinatinon.y) {
            return Direction.UP;
        } else if (current.x > destinatinon.x && current.y == destinatinon.y) {
            return Direction.LEFT;
        } else if (current.x < destinatinon.x && current.y == destinatinon.y) {
            return Direction.RIGHT;
        } else return null;
    }


}
