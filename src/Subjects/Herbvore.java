package Subjects;

import Config.Settings;
import Map.Coordinate;
import Map.Map;
import interfaces.Eating;
import interfaces.Movable;
import interfaces.Seeking;

import java.util.ArrayList;

import static Config.Settings.*;

public class Herbvore extends Creature implements Movable, Seeking, Eating {

    private final char representSymbol = 'H';
    private final char preySymbol = 'G';
    private int satiaty = HERBVORE_SATIATY;

    public Herbvore(Coordinate coordinate) {
        setCoordinate(coordinate);
        this.setLife(HERBVOR_LIFE);
    }

    @Override
    public char getPreySymbol() {
        return preySymbol;
    }

    @Override
    public char getOwnSimbols(){
        return representSymbol;
    }

    @Override
    public Coordinate findPreyCoordinate(Map map, char symbol){
        return Seeking.super.findPreyCoordinate(map, symbol);
    }

    @Override
    public ArrayList<Coordinate> findPath(Map map, Coordinate coordinate){
        return Seeking.super.findPath(map, coordinate);
    }

    @Override
    public void eat(Map map){
        Eating.super.eat(map);
    }

}
