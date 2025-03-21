package Subjects;

import Config.Settings;
import Map.Coordinate;
import Map.Map;

public class Herbvore extends Creature {

    private final char representSymbol = 'H';

    public Herbvore(Coordinate coordinate) {
        setCoordinate(coordinate);
    }

    public char getView() {
        return representSymbol;
    }

}
