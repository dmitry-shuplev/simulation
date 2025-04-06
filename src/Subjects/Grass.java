
package Subjects;

import Map.Coordinate;
import static Config.Settings.*;

public class Grass extends Entity {
    private final char representSymbol = 'G';

    public Grass(Coordinate coordinate){
        setCoordinate(coordinate);
        this.setLife(GRASS_QUANTITY);
    }

    @Override
    public char getOwnSimbols(){
        return representSymbol;
    }


}

