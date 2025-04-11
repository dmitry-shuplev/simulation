package interfaces;

import game_map.GameMap;
import subjects.Entity;
import game_map.Coordinate;

public interface Eating {
    public default void eat(GameMap map) {
        for (Coordinate neighborCoordinate : map.getNaighbors(this.getCoordinate())) {
            Entity entity = map.getEntityByCoordinate(neighborCoordinate);

            if (entity != null) {
                if (entity.getOwnSimbols() == this.getPreySymbol()) {
                    entity.setLife(entity.getLife() - 1);
                }
            }
        }

    }

    Coordinate getCoordinate();
    char getPreySymbol();

}
