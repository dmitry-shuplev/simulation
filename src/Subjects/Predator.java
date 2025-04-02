package Subjects;

import Map.Coordinate;
import static Config.Settings.*;

public class Predator extends Creature {

    private final char representSymbol = 'P';
    private char preySymbol = 'H';

    public Predator(Coordinate coordinate) {
        setCoordinate(coordinate);
        this.setLife(PREDATOR_LIFE);
    }

    public char getView() {
        return representSymbol;
    }

    @Override
    public char getPreySymbol() {
        return preySymbol;
    }
}
