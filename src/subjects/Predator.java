package subjects;

import game_map.Coordinate;
import game_map.GameMap;
import interfaces.Eating;
import interfaces.Movable;
import interfaces.Seeking;

import java.util.ArrayList;

import static config.Settings.*;

public class Predator extends Creature implements Movable, Seeking, Eating {

    private final char representSymbol = 'P';
    private char preySymbol = 'H';

    public Predator(Coordinate coordinate) {
        setCoordinate(coordinate);
        this.setLife(PREDATOR_LIFE);
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
    public Coordinate findPreyCoordinate(GameMap map, char symbol){
        return Seeking.super.findPreyCoordinate(map, symbol);
    }

    @Override
    public ArrayList<Coordinate> findPath(GameMap map, Coordinate coordinate){
        return Seeking.super.findPath(map, coordinate);
    }

    @Override
    public void eat(GameMap map){
        Eating.super.eat(map);
    }
}
