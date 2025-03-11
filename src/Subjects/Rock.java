package Subjects;

import Map.Coordinate;

public class Rock extends Entity {
    public Rock(Coordinate coordinate) {
        setCoordinate(coordinate);

    private final char representSymbol = 'R';

    public char getView() {
        return representSymbol;
    }
}
