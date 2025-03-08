package Subjects;

import Interfaces.Movable;
import Map.Coordinate;

public class Herbvore extends Creature implements Movable {

    private final char representSymbol = 'H';
    private Coordinate coordinate;

  public   Herbvore(Coordinate coordinate){
     this.coordinate = coordinate;
    }

    public char getView() {
        return representSymbol;
    }
}
