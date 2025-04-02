package Subjects;

import Config.Settings;
import Map.Coordinate;
import Map.Map;

import java.util.ArrayList;

public class Herbvore extends Creature {

    private final char representSymbol = 'H';

    private final char preySymbol = 'G';

    public Herbvore(Coordinate coordinate) {
        setCoordinate(coordinate);
    }

    public char getView() {
        return representSymbol;
    }

    @Override
    public char getPreySymbol() {
        return preySymbol;
    }
}
