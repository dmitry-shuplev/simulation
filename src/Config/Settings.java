package Config;

public class Settings {
    public static final int MAP_WIDTH = 25;
    public static final int MAP_HEIGHT = 10;
    public static final int STEPS = 100;
    public static final int MOVE_PRICE = 10;
    public static final int SEARCH_AREA = 200;

    public enum Direction {
        UP,
        DOWN,
        RIGHT,
        LEFT
    }

    public enum Subjects {
        ROCKS(20, "Rock"),
        GRASS(1, "Grass"),
        TREES(20, "Tree"),
        HERBVORE(0, "Herbvore"),
        PREDSTOR(0, "Predator");

        private final int totalObjects;
        private final String entityName;

        Subjects(int totalObjects, String entityName) {
            this.totalObjects = totalObjects;
            this.entityName = entityName;
        }

        public int getTotalObjects() {
            return this.totalObjects;
        }

        public String getEntityName() {
            return entityName;
        }
    }


//end of enum
}