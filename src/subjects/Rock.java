package subjects;

import game_map.Coordinate;

public class Rock extends Entity {

    private final char representSymbol = 'R';

    public Rock(Coordinate coordinate) {
        setCoordinate(coordinate);
    }

    @Override
    public char getOwnSimbols(){
        return representSymbol;
    }
}
