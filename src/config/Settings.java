package config;

public class Settings {
    public static final int MAP_WIDTH = 25;
    public static final int MAP_HEIGHT = 10;
    public static final int STEPS = 5;
    public static final int MOVE_PRICE = 10;
    public static final int SEARCH_AREA = 200;
    public static int HERBVORE_SATIATY = 100;
    public static int HERBVOR_LIFE = 3;
    public static int PREDATOR_SATIATY = 100;
    public static int PREDATOR_LIFE = 10;
    public static int GRASS_QUANTITY = 1;

    public enum Direction {
        UP,
        DOWN,
        RIGHT,
        LEFT
    }

    public enum Subjects {
        ROCKS(10, "Rock"),
        GRASS(10, "Grass"),
        TREES(10, "Tree"),
        HERBVORE(3, "Herbvore"),
        PREDSTOR(1, "Predator");

        private final int amountEntities;
        private final String entityName;

        Subjects(int amountEntities, String entityName) {
            this.amountEntities = amountEntities;
            this.entityName = entityName;
        }

        public int getAmountEntities() {
            return this.amountEntities;
        }

        public String getEntityName() {
            return entityName;
        }
    }


//end of enum
}