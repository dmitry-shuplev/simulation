package Subjects;

import Config.Settings;
import Map.Coordinate;
import Map.Map;

import javax.swing.plaf.DimensionUIResource;
import java.util.ArrayList;

public class Predator extends Creature {

    private final char representSymbol = 'P';

    public Predator(Coordinate coordinate) {
        setCoordinate(coordinate);
    }

    public char getView() {
        return representSymbol;
    }

    public void motheToPerpous(Map map) {
        Coordinate purpouseCoordinate = findPurpouseCoordinate(map, 'H');
        ArrayList<Coordinate> path = findPath(map, purpouseCoordinate);

        Coordinate nextStepCoordinate = path.getFirst();

        Settings.Direction nextStep = this.getCoordinate().getDirection(nextStepCoordinate);
        this.move(nextStep, map);
    }


}
