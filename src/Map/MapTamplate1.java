package Map;

import Config.Settings;
import Subjects.Rock;

import static Config.Settings.MAP_HEIGHT;

public class MapTamplate1 {
    public static void fillingMap(Map map) {
        for (int i = 0; i < MAP_HEIGHT-2; i++) {
            Rock rock = new Rock(new Coordinate(12,i));
            map.getMap().put(rock.getCoordinate(), rock);
        }
    }
}
