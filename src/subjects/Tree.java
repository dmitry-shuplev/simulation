package subjects;

import game_map.Coordinate;

public class Tree extends Entity {
private final char representSymbol = 'T';

    public Tree(Coordinate coordinate) {
        setCoordinate(coordinate);
    }

    @Override
    public char getOwnSimbols(){
        return representSymbol;
    }

}
