package interfaces;

import Map.Map;
import Subjects.Entity;
import Map.Coordinate;

public interface Eating {
    public default void eat(Map map) {
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
