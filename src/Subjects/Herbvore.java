package Subjects;

import Map.Coordinate;

public class Herbvore extends Creature {

    private final char representSymbol = 'H';

    public Herbvore(Coordinate coordinate) {
        setCoordinate(coordinate);
    }

    public char getView() {
        return representSymbol;
    }
}
