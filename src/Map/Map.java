package Map;

import Subjects.*;

import java.util.HashMap;

public class Map {
    private final int xMax = 10;
    private final int yMax = 10;

    private HashMap<Coordinate, Entity> map = new HashMap<>();

    public void addEntitys() {
        Coordinate coordinate = new Coordinate(1, 1);
        Herbvore herb = new Herbvore(coordinate);
        //map.put(herb.);

        coordinate = new Coordinate(2, 2);
        map.put(coordinate, new Rock());

        coordinate = new Coordinate(5, 5);
        map.put(coordinate, new Predator());

        coordinate = new Coordinate(9, 9);
        map.put(coordinate, new Grass(coordinate));
    }

    public void showMap() {
        for (int y = yMax; y >= 0; y--) {
            for (int x = 0; x < xMax; x++) {
                Coordinate coordinate = new Coordinate(x, y);
                if (map.get(coordinate) == null) {
                    System.out.print(" * ");
                } else {
                    System.out.print(" "+map.get(coordinate).getView()+" ");
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
