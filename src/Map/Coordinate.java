package Map;

import java.util.Objects;

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
        if (this.x < 0 || this.y < 0 || this.x > X_MAX-1 || this.y > Y_MAX-1) {
            return false;
        }
        return true;
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
