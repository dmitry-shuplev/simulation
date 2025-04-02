package Subjects;

import Config.Settings.*;
import Map.*;


public abstract class Entity {
    private int life = 100;

    public abstract char getView();


    private Coordinate coordinate;

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}

