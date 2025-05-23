package simulation;

import game_map.*;
import subjects.*;
import view.View;

import static config.Settings.*;
import static java.lang.Thread.sleep;

public class Simulation {
    static int stepsCounter = 0;
    static boolean flag = false;
    static GameMap map;

    public static void main(String[] args) throws InterruptedException {

        map = new GameMap();
        View.createViewMap(map);
        startSimulation(0, map);

    }


    private static void nextTurn(GameMap map) throws InterruptedException {
        sleep(800);
        for (var entity : map.getMapCopy().values()) {

            if (entity instanceof Herbvore) {
                ((Herbvore) entity).moveToPrey(map);
            }
            if (entity instanceof Predator) {
                ((Predator) entity).moveToPrey(map);
            }
            if (entity instanceof Herbvore) {
                ((Herbvore) entity).eat(map);
            }
            if (entity instanceof Predator) {
                ((Predator) entity).eat(map);
            }
        }

        map.clearMap();
        View.updateMap(map);
        stepsCounter++;
        View.updateStepsLabel();
    }

    private static void startSimulation(int stepNumber, GameMap map) {
        while (flag) {
            if (stepsCounter > STEPS) {
                System.out.println("Программа закончила работу.По превышению количества шагов.");
                System.exit(0);
            }
            try {
                nextTurn(map);
            } catch (InterruptedException e) {
                System.out.println("Ошибка потоков из за искользования sleep.");
            }
        }

    }

    public static void start() {
        flag = true;
        new Thread(() -> startSimulation(stepsCounter, map)).start();
    }

    public static void pause() {
        flag = false;
    }

    public static void stop() {
        System.exit(0);
    }

    public static int getStepsNumber() {
        return stepsCounter;
    }
}
