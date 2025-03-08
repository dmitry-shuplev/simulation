package Interfaces;
import Map.Coordinate;

public interface Movable {
    enum Direction {
        UP,
        DOWN,
        RIGHT,
        LEFT
    }

    default Coordinate getCoordinate(){
        return this.coordinate;
    }

    default void move(Direction direction) {
        switch (direction) {
            case UP:
                this.coordinate;
                break;
            case DOWN:
                break;
            case RIGHT:
                break;
            case LEFT:
                break;
        }



    }
}
