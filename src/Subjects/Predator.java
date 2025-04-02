package Subjects;

import Config.Settings;
import Map.Coordinate;
import Map.Map;

import javax.swing.plaf.DimensionUIResource;
import java.util.ArrayList;

public class Predator extends Creature {

    private final char representSymbol = 'P';
    private char preySymbol = 'H';


    public Predator(Coordinate coordinate) {
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
