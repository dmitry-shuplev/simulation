package Subjects;

import Map.Coordinate;
import Map.Map;
import interfaces.Movable;
import interfaces.Seeking;

import java.util.ArrayList;

import static Config.Settings.*;

public class Predator extends Creature implements Movable, Seeking {

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

    @Override
    public Coordinate findPreyCoordinate(Map map, char symbol){
        return Seeking.super.findPreyCoordinate(map, symbol);
    }

    @Override
    public ArrayList<Coordinate> findPath(Map map, Coordinate coordinate){
        return Seeking.super.findPath(map, coordinate);
    }
}
