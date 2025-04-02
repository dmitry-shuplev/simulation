package Subjects;

import Config.Settings;
import Map.Coordinate;
import Map.Map;

import java.util.ArrayList;

import static Config.Settings.*;

public class Herbvore extends Creature {

    private final char representSymbol = 'H';
    private final char preySymbol = 'G';
    private int satiaty = HERBVORE_SATIATY;
    private int life = HERBVOR_LIFE;

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
