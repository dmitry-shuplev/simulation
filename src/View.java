import Map.*;
import Config.Settings.*;
import Subjects.Entity;

import javax.swing.*;
import java.awt.*;
import java.lang.ref.Cleaner;

import static Config.Settings.MAP_LENGTH;
import static Config.Settings.MAP_HEIGHT;

public class View {

    public static void showMap(Map map) {
        for (int y = MAP_HEIGHT-1; y >= 0; y--) {
            for (int x = 0; x <= MAP_LENGTH-1; x++) {
                Coordinate coordinate = new Coordinate(x, y);
                if (map.getMap().get(coordinate) == null) {
                    System.out.print(" * ");
                } else {
                    System.out.print(" " + map.getMap().get(coordinate).getView() + " ");
                }
            }
            System.out.print("\n");
        }
        System.out.println("_______________________________");

    }

    public static void showEntitys(Map map) {
        for (Coordinate coordinate : map.getMap().keySet()) {
            System.out.print(coordinate.toString());
            System.out.println(" " + map.getMap().get(coordinate));
        }

    }

    public static void clearConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println("Ошибка при очистке терминала: " + e.getMessage());
        }
    }

    public static void showMapSwing(Map map){
JFrame frame = new JFrame(){};
frame.setVisible(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(1200,600);
frame.setLocation(150, 50);
frame.setTitle("Это проект Симуляция Road_map Сергея Жукова");
    }



}
