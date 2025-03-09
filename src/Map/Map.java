package Map;

import Config.Settings;
import Subjects.*;
import Config.Settings.*;
import java.util.HashMap;

import static Config.Settings.X_MAX;
import static Config.Settings.Y_MAX;


public class Map {
    private final int xMax = X_MAX;
    private final int yMax = Y_MAX;
    private HashMap<Coordinate, Entity> map = new HashMap<>();


    public HashMap<Coordinate, Entity> getMap() {
        return map;
    }


    public void showMap() {
        for (int y = yMax; y >= 0; y--) {
            for (int x = 0; x < xMax; x++) {
                Coordinate coordinate = new Coordinate(x, y);
                if (map.get(coordinate) == null) {
                    System.out.print(" * ");
                } else {
                    System.out.print(" " + map.get(coordinate).getView() + " ");
                }
            }
            System.out.print("\n");
        }
        Coordinate co1 = new Coordinate(2, 2);
        Coordinate co2 = new Coordinate(2, 2);
        System.out.println(co2.equals(co1));
        System.out.println(map.get(co1));
    }


}
