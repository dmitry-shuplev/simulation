package Subjects;

import Map.Coordinate;

public class Predator extends Creature{
    public Predator(Coordinate coordinate) {
        setCoordinate(coordinate);}

    private final char representSymbol = 'P';

    public char getView() {
        return representSymbol;
    }
}
