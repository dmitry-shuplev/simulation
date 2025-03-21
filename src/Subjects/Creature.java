package Subjects;

import Config.Settings.*;
import Map.*;

import java.util.ArrayList;

public abstract class Creature extends Entity {

    public void move(Direction direction, Map map) {
        Coordinate coordinate = getCoordinate();
        Coordinate newCoordinate = coordinate.getNextStepCoordinate(direction);
        if (map.isFieldEmpty(newCoordinate)) {
            map.getMap().remove(coordinate);
            coordinate = newCoordinate;
            this.setCoordinate(coordinate);
            map.getMap().put(coordinate, this);
        }
    }

    public Entity finedObject(Map map, char entityType) {
        ArrayList<Coordinate> wasChecked = new ArrayList<>();
        ArrayList<Coordinate> queue = new ArrayList<>();
        queue.add(this.getCoordinate());
        while (!queue.isEmpty()) {
            Coordinate currentNodeCoordinate = queue.remove(0);
            wasChecked.add(currentNodeCoordinate);
            for (Coordinate nodeCoordinate : map.getNaighbors(currentNodeCoordinate)) {
                if (!wasChecked.contains(nodeCoordinate) && !queue.contains(nodeCoordinate)) {
                    if(!map.isFieldEmpty(nodeCoordinate) && map.getMap().get(nodeCoordinate).getView() == entityType){
                        return map.getMap().get(nodeCoordinate);
                    }
                    queue.add(nodeCoordinate);
                }
            }
        }
        return null;
    }


}
