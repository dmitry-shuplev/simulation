import java.util.HashMap;

import Map.Map;
import Map.Coordinate;
import Subjects.*;
import Config.Settings.*;

import static Config.Settings.*;

public class Simulation {
    public static void main(String[] args) throws InterruptedException {
        Map map = new Map();
        for (int i = STEPS; i > 0; i--) {

           // View.showMap(map);
           // View.showEntitys(map);
            View.showMapSwing(map);
        }


    }


}
