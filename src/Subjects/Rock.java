package Subjects;

import Map.Coordinate;

public class Rock extends Entity {
    public Rock(Coordinate coordinate) {
        setCoordinate(coordinate);

    private final char representSymbol = 'R';

    public Rock(Coordinate coordinate) {
        setCoordinate(coordinate);
    }
    public char getView() {
        return representSymbol;
    }
}
