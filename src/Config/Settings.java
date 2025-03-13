package Config;

public class Settings {
    public static final int X_MAX = 20;
    public static final int Y_MAX = 10;
    public static final int STEPS = 10;

    public enum Direction {
        UP,
        DOWN,
        RIGHT,
        LEFT
    }

    public enum Entites {
        GRASS(1, "Grass"),
        HERBVORE(2, "Herbvore");
        private final int totalObjects;
        private final String entityName;

        Entites(int totalObjects, String entityName){
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