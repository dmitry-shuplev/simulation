package game_map;

import java.util.Objects;
import java.util.Random;

import static config.Settings.*;

public class Coordinate {
    public int x;
    public int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public boolean isCoordinateCorrect() {
        return this.x >= 0 && this.y >= 0 && this.x < MAP_WIDTH && this.y < MAP_HEIGHT;
    }


    public Coordinate getNextStepCoordinate(Direction direction) {
        Coordinate newCoordinate = new Coordinate(this.x, this.y);
        switch (direction) {
            case UP:
                newCoordinate.y = this.y - 1;
                break;
            case DOWN:
                newCoordinate.y = this.y + 1;
                break;
            case LEFT:
                newCoordinate.x = this.x - 1;
                break;
            case RIGHT:
                newCoordinate.x = this.x + 1;
                break;
        }
        return newCoordinate.isCoordinateCorrect() ? newCoordinate : this;
    }

    public Direction getDirection(Coordinate start) {
        if (this.x == start.x && this.y < start.y) {
            return Direction.DOWN;
        } else if (this.x == start.x && this.y > start.y) {
            return Direction.UP;
        } else if (this.x > start.x && this.y == start.y) {
            return Direction.LEFT;
        } else if (this.x < start.x && this.y == start.y) {
            return Direction.RIGHT;
        } else return null;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Coordinate)) return false;
        Coordinate other = (Coordinate) obj;
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
