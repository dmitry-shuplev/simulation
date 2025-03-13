package Map;

import Subjects.*;

import java.util.HashMap;

import static Config.Settings.*;


public class Map {

    private final int xMax = X_MAX;
    private final int yMax = Y_MAX;
    private HashMap<Coordinate, Entity> map = new HashMap<>();

    public Map(){
        filingMap();
    }
    public HashMap<Coordinate, Entity> getMap() {
        return map;
    }

    private void filingMap() {
        for (Subjects entity : Subjects.values()) {
            for (int i = entity.getTotalObjects(); i > 0; i--) {
                createSomeEntity(entity.getEntityName());
            }
        }
    }

    private void createSomeEntity(String entityName) {
        Coordinate coordinate = Coordinate.getRandCoordinate(this);
        try {
            Class<?> clazz = Class.forName("Subjects." + entityName);
            var constructor = clazz.getDeclaredConstructor(coordinate.getClass());
            Object entity = constructor.newInstance(coordinate);
            this.map.put(coordinate, (Entity) entity);
        } catch (Exception e) {
            e.printStackTrace();
        }


     /*   try {int a =2;
            Class<?> entity = Class.forName("Herbvore");

        }catch (Exception e){
            e.printStackTrace();
        }
*/
        //Herbvore herb = new Herbvore(Coordinate.getRandCoordinate(this));
        //return herb;
    }


    public boolean isFieldEmpty(Coordinate coordinate) {
        if (this.getMap().containsKey(coordinate)) {
            return false;
        }
        return true;
    }


}
