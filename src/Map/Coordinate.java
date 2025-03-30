package Map;

import java.util.Objects;
import java.util.Random;

import Config.Settings.*;

import static Config.Settings.*;

public class Coordinate {
    public int x;
    public int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static int getHeuristicCoast(Coordinate start, Coordinate finish){
        return (Math.abs(finish.x-start.x)+Math.abs(finish.y-start.y) - 1)*10;
    }


    public boolean isCoordinateCorrect() {
        if (this.x < 0 || this.y < 0 || this.x > MAP_WIDTH - 1 || this.y > MAP_HEIGHT - 1) {
            return false;
        }
        return true;
    }

    public static Coordinate getRandCoordinate(Map map) {
        Random rand = new Random();
        int x = rand.nextInt(0, MAP_WIDTH - 1);
        int y = rand.nextInt(0, MAP_HEIGHT - 1);
        Coordinate coordinate = new Coordinate(x, y);
        if (!map.isFieldEmpty(coordinate)) {
            System.out.println("Ошибка. Обьект с такими координатами уже существует.");
            getRandCoordinate(map);
        }
        return coordinate;
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
        if(this.x == start.x && this.y<start.y){return Direction.DOWN;}
        else if (this.x == start.x && this.y>start.y) {return Direction.UP;}
        else if (this.x>start.x && this.y==start.y) {return Direction.LEFT;}
        else if (this.x<start.x && this.y==start.y) {return Direction.RIGHT;}
        else return null;
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
