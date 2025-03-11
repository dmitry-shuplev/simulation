package Subjects;

import Map.Coordinate;

public class Grass extends Entity {
    private final int START_QUANTITY = 100;
    private final char representSymbol = 'G';
    private int quantity;

    public Grass(Coordinate coordinate) {
        setCoordinate(coordinate);}


    public char getView() {
        return representSymbol;
    }

}
