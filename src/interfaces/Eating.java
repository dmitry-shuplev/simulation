package interfaces;

import game_map.GameMap;
import subjects.Entity;
import game_map.Coordinate;

import static java.lang.Thread.sleep;

public interface Eating {
    public default void eat(GameMap gameMap) throws InterruptedException {
        for (Coordinate neighborCoordinate : gameMap.getNaighbors(this.getCoordinate())) {
            Entity entity = gameMap.get(neighborCoordinate);

            if (entity != null) {
                try{sleep(300);}
                catch(InterruptedException e){
                    e.printStackTrace();
                };


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
