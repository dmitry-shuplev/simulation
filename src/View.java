import Map.*;
import Config.Settings.*;
import Subjects.Entity;

import java.lang.ref.Cleaner;

import static Config.Settings.X_MAX;
import static Config.Settings.Y_MAX;

public class View {

    public static void showMap(Map map) {
        clearConsole();
        for (int y = Y_MAX; y >= 0; y--) {
            for (int x = 0; x < X_MAX; x++) {
                Coordinate coordinate = new Coordinate(x, y);
                if (map.getMap().get(coordinate) == null) {
                    System.out.print(" * ");
                } else {
                    System.out.print(" " + map.getMap().get(coordinate).getView() + " ");
                }
            }
            System.out.print("\n");
        }

    }

    public static void showEntitys(Map map) {
        for (Coordinate coordinate : map.getMap().keySet()) {
            System.out.print(coordinate.toString());
            System.out.println(" " + map.getMap().get(coordinate));
        }

    }

    public static void clearConsole() {
        try {
            // Команда для очистки терминала в Windows
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println("Ошибка при очистке терминала: " + e.getMessage());
        }
    }


}
