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

    public boolean isCoordinateCorrect() {
        if (this.x < 0 || this.y < 0 || this.x > X_MAX - 1 || this.y > Y_MAX - 1) {
            return false;
        }
        return true;
    }

    public static Coordinate getRandCoordinate(Map map) {
        Random rand = new Random();
        int x = rand.nextInt(0, X_MAX - 1);
        int y = rand.nextInt(0, Y_MAX - 1);
        Coordinate coordinate = new Coordinate(x, y);
        if (!map.isFieldEmpty(coordinate)){
            System.out.println("Ошибка");
            getRandCoordinate(map);
        }
        return coordinate;
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
        if (obj == null || !(obj instanceof Coordinate)) return false;
        Coordinate coordinate = (Coordinate) obj;
        return x == coordinate.x && y == coordinate.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
