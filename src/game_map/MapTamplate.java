//Данный шаблон нужно задействвать если ты хочешь получить не случайную карту а карту определенного вида
package game_map;

import subjects.*;
import static config.Settings.MAP_HEIGHT;

public class MapTamplate {
    public static void fillingMap(GameMap map) {


        for (int i = 3; i < MAP_HEIGHT-3; i++) {
            Rock rock = new Rock(new Coordinate(13,i));
            map.getMap().put(rock.getCoordinate(), rock);
        }
    }
}
