package Subjects;

import Config.Settings;
import Map.*;
import Map.Map;
import java.util.*;
import static Config.Settings.*;


public abstract class Creature extends Entity {

    private char preySymbol;
    private int satiaty;
    private int life;


    public void eat(Map map) {
        for (Coordinate neighborCoordinate : map.getNaighbors(this.getCoordinate())) {
            Entity entity = map.getEntityByCoordinate(neighborCoordinate);

            if (entity != null) {
                if (entity.getView() == this.getPreySymbol()) {
                    entity.setLife(entity.getLife() - 1);
                }
            }
        }

    }

    public void increaseLife() {
        this.life--;
    }

    public char getPreySymbol() {
        return preySymbol;
    }
}
