package Subjects;

import Map.Coordinate;

public abstract class Entity {
    public abstract char getView();
    private Coordinate coordinate;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }
}

