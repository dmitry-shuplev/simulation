package Subjects;

import Map.Coordinate;
import static Config.Settings.*;

public class Herbvore extends Creature {

    private final char representSymbol = 'H';
    private final char preySymbol = 'G';
    private int satiaty = HERBVORE_SATIATY;

    public Herbvore(Coordinate coordinate) {
        setCoordinate(coordinate);
        this.setLife(HERBVOR_LIFE);
    }

    public char getView() {
        return representSymbol;
    }

    @Override
    public char getPreySymbol() {
        return preySymbol;
    }
}
