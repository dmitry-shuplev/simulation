
package subjects;

import config.Settings;
import game_map.Coordinate;
import config.Settings.*;


public class Grass extends Entity {
    private final char representSymbol = 'G';
    private final int GRASS_QUANTITY = Settings.GRASS_QUANTITY;

    public Grass(Coordinate coordinate) {
        setCoordinate(coordinate);
        this.setLife(GRASS_QUANTITY);
    }

    @Override
    public char getOwnSimbols() {
        return representSymbol;
    }


}

