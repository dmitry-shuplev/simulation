package Subjects;

import Config.Settings.*;
import Map.*;


public abstract class Entity {
    private Coordinate coordinate;

    private int life = 100;
    private char represenSymbol;

    public abstract char getOwnSimbols();

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

