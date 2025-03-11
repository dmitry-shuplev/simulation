package Config;

public class Settings {
    public static final int X_MAX = 20;
    public static final int Y_MAX = 10;
    public static final int STEPS = 10;

    public static final int TOTAL_HERBVORE = 0;

    public enum Direction{
        UP,
        DOWN,
        RIGHT,
        LEFT
    }
    public enum EntityType{
        ROCK,
        GRASS,
        HERBVORE,
        PREDATOR
    }
}
