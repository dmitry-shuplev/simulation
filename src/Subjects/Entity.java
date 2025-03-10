package Subjects;

import Config.Settings.*;
import Map.*;


public abstract class Entity {
    public abstract char getView();

    private Coordinate coordinate;

    public void move(Direction direction, Map map) {
        Coordinate newCoordinate = new Coordinate(coordinate.x, coordinate.y);
        switch (direction) {
            case UP:
                newCoordinate.y++;
                break;
            case DOWN:
                newCoordinate.y--;
                break;
            case LEFT:
                newCoordinate.x--;
                break;
            case RIGHT:
                newCoordinate.x++;
                break;
        }
        if (newCoordinate.isCoordinateCorrect()) {
            map.getMap().remove(coordinate);
            coordinate = newCoordinate;
            map.getMap().put(coordinate, this);
        }
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}

