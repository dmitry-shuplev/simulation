package Subjects;

import Config.Settings;
import Map.Coordinate;
import Map.Map;

import javax.swing.plaf.DimensionUIResource;
import java.util.ArrayList;

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
