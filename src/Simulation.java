import java.util.HashMap;

import Map.Map;
import Map.Coordinate;
import Subjects.*;
import Config.Settings.*;

import static Config.Settings.*;

public class Simulation {

    public static void main(String[] args) throws InterruptedException {
        Map map = new Map();
        View.createViewMap(map);

        for (int i = STEPS; i > 0; i--) {
            for (Entity entity : map.getMap().values()) {
                if (entity.getView() == 'H') {
                    entity.move(Direction.DOWN, map);
                }
            }


        }

    }
}
