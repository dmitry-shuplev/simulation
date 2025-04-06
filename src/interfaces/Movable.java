package interfaces;

import Config.Settings;
import Map.Coordinate;
import Map.Map;
import Subjects.Entity;

import java.util.ArrayList;

public interface Movable {

    public default void move(Settings.Direction direction, Map map) {
        Coordinate coordinate = getCoordinate();
        Coordinate newCoordinate = coordinate.getNextStepCoordinate(direction);
        if (map.isFieldEmpty(newCoordinate)) {
            map.removeEntity(coordinate);
            this.setCoordinate(newCoordinate);
            map.addEntity(newCoordinate, (Entity) this);
        }
    }

    public default boolean moveToPrey(Map map) {
        Coordinate preyCoordinate = findPreyCoordinate(map, getPreySymbol());
        ArrayList<Coordinate> path = findPath(map, preyCoordinate);
        if (path.isEmpty()) {
            return true;
        }
        Coordinate nextStepCoordinate = path.getFirst();
        Settings.Direction nextStep = this.getCoordinate().getDirection(nextStepCoordinate);
        this.move(nextStep, map);
        return false;
    }

    Coordinate findPreyCoordinate(Map map, char symbol);

    Coordinate getCoordinate();

    void setCoordinate(Coordinate coordinate);

    char getPreySymbol();

    ArrayList<Coordinate> findPath(Map map, Coordinate coordinate);

}
