package Config;

public class Settings {
    public static final int MAP_WIDTH = 25;
    public static final int MAP_HEIGHT = 10;
    public static final int STEPS = 3;

    public enum Direction {
        UP,
        DOWN,
        RIGHT,
        LEFT
    }

    public enum Subjects {
        ROCKS(1, "Rock"),
        GRASS(1, "Grass"),
        TREES(3,"Tree"),
        HERBVORE(0, "Herbvore"),
        PREDSTOR(2, "Predator");

        private final int totalObjects;
        private final String entityName;

        Subjects(int totalObjects, String entityName){
            this.totalObjects = totalObjects;
            this.entityName = entityName;
        }

        public int getTotalObjects(){
            return this.totalObjects;
        }

        public String getEntityName() {
            return entityName;
        }
    }


//end of enum
}