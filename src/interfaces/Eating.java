package interfaces;

import game_map.GameMap;
import subjects.Entity;
import game_map.Coordinate;

public interface Eating {
    public default void eat(GameMap gameMap) {
        for (Coordinate neighborCoordinate : gameMap.getNaighbors(this.getCoordinate())) {
            Entity entity = gameMap.get(neighborCoordinate);

            if (entity != null) {
                if (entity.getOwnSimbols() == this.getPreySymbol()) {
                    entity.setLife(entity.getLife() - 1);
                    break;
                }
            }
        }
    }

    Coordinate getCoordinate();
    char getPreySymbol();

}
