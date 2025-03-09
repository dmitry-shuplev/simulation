import Map.*;
import Config.Settings.*;

import static Config.Settings.X_MAX;
import static Config.Settings.Y_MAX;

public class View {

    public static void showMap(Map map){
        for (int y = Y_MAX; y >= 0; y--) {
            for (int x = 0; x < X_MAX; x++) {
                Coordinate coordinate = new Coordinate(x, y);
                if (map.getMap().get(coordinate) == null) {
                    System.out.print(" * ");
                } else {
                    System.out.print(" " + map.getMap().get(coordinate).getView() + " ");
                }
            }
            System.out.print("\n");
        }

    }
}
