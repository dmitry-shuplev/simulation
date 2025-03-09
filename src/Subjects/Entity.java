package Subjects;

import Map.*;


public abstract class Entity {
    public abstract char getView();
    private Coordinate coordinate;

    public enum Direction{
        UP,
        DOWN,
        RIGHT,
        LEFT
    }

    public void move(Direction direction, Map map){
        map.getMap().remove(coordinate);
        switch (direction){
        case UP: this.coordinate.y++;
        break;
        case DOWN: this.coordinate.y--;
            break;
        case LEFT: this.coordinate.x--;
            break;
        case RIGHT: this.coordinate.x++;
            break;
    }
map.getMap().put(coordinate, this);
        }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}

