
package subjects;

import game_map.Coordinate;
import static config.Settings.*;

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

