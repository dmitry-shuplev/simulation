package Subjects;

import Config.Settings;
import Map.Coordinate;
import Map.Map;

import java.util.ArrayList;

public class Herbvore extends Creature {

    private final char representSymbol = 'H';

    public Herbvore(Coordinate coordinate) {
        setCoordinate(coordinate);
    }

    public char getView() {
        return representSymbol;
    }

    public void motheToPerpous(Map map) {
        Coordinate purpouseCoordinate = findPurpouseCoordinate(map, 'G');
        ArrayList<Coordinate> path = findPath(map, purpouseCoordinate);

        Coordinate nextStepCoordinate = path.getFirst();

        Settings.Direction nextStep = this.getCoordinate().getDirection(nextStepCoordinate);
        this.move(nextStep, map);
    }
}
