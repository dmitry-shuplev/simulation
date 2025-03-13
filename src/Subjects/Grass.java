package Subjects;

import Map.Coordinate;

public class Grass extends Entity {
    private final int START_QUANTITY = 100;
    private final char representSymbol = 'G';
    private int quantity;
private Coordinate coordinate;
    
    public Grass(Coordinate coordinate){
        setCoordinate(coordinate);
        this.quantity = START_QUANTITY;
    }

    public char getView() {
        return representSymbol;
    }

    public void IncreaceQuantity(){
        quantity-=1;
    }


}
