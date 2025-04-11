package interfaces;

import config.Settings;
import game_map.Coordinate;
import game_map.GameMap;
import subjects.Entity;

import java.util.ArrayList;

public interface Movable {

    public default void move(Settings.Direction direction, GameMap gameMap) {
        Coordinate coordinate = getCoordinate();
        Coordinate newCoordinate = gameMap.getNextStepCoordinate(direction, coordinate);
        if (gameMap.isFieldEmpty(newCoordinate)) {
            gameMap.removeEntity(coordinate);
            this.setCoordinate(newCoordinate);
            gameMap.addEntity(newCoordinate, (Entity) this);
        }
    }

    public default boolean moveToPrey(GameMap map) {
        Coordinate preyCoordinate = findPreyCoordinate(map, getPreySymbol());
        ArrayList<Coordinate> path = findPath(map, preyCoordinate);
        if (path.isEmpty()) {
            return true;
        }
        Coordinate nextStepCoordinate = path.getFirst();
       // Settings.Direction nextStep = this.getCoordinate().getDirection(nextStepCoordinate);
        Settings.Direction nextStep = map.getDirection(this.getCoordinate(), nextStepCoordinate);
        this.move(nextStep, map);
        return false;
    }

    public abstract Coordinate findPreyCoordinate(GameMap map, char symbol);

    public abstract ArrayList<Coordinate> findPath(GameMap map, Coordinate coordinate);

    Coordinate getCoordinate();

    void setCoordinate(Coordinate coordinate);

    char getPreySymbol();

}
