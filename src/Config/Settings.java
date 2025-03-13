package Config;

public class Settings {
    public static final int X_MAX = 20;
    public static final int Y_MAX = 10;
    public static final int STEPS = 1;

    public enum Direction {
        UP,
        DOWN,
        RIGHT,
        LEFT
    }

    public enum Subjects {
        ROCKS(15, "Rock"),
        GRASS(10, "Grass"),
        TREES(5,"Tree"),
        HERBVORE(20, "Herbvore"),
        PREDSTOR(5, "Predator");

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