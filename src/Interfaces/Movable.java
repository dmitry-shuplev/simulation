package Interfaces;

public interface Movable {
    enum Direction{
        UP,
        DOWN,
        RIGHT,
        LEFT
    }
    void move(Direction direction);
}
