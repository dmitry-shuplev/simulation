
package Subjects;

import Map.Coordinate;
import static Config.Settings.*;

public class Grass extends Entity {
    private final char representSymbol = 'G';

    public Grass(Coordinate coordinate){
        setCoordinate(coordinate);
        this.setLife(GRASS_QUANTITY);
    }

    public char getView() {
        return representSymbol;
    }

    public void IncreaceQuantity(){
       // quantity-=1;
    }


}

