
package Subjects;

import Config.Settings;
import Map.Coordinate;
import Config.Settings.*;

import static Config.Settings.*;

public class Grass extends Entity {
    private final char representSymbol = 'G';
    private int life;

    public Grass(Coordinate coordinate){
        setCoordinate(coordinate);
        this.life = GRASS_QUANTITY;
    }

    public char getView() {
        return representSymbol;
    }

    public void IncreaceQuantity(){
       // quantity-=1;
    }


}

