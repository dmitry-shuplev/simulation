package Subjects;

import Map.Coordinate;

public class Predator extends Creature{

    private final char representSymbol = 'P';

    public Predator(Coordinate coordinate) {
        setCoordinate(coordinate);}

    public char getView() {
        return representSymbol;
    }
}
