import game_map.*;

import javax.swing.*;
import java.awt.*;

public class View {
private static JFrame frame = new JFrame();

    public static void createViewMap(GameMap map){
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 600);
        frame.setLocation(150, 50);
        frame.setTitle("Это проект Симуляция Road_map Сергея Жукова");

        MapComponents field = new MapComponents(map);
        frame.getContentPane().add(field, BorderLayout.CENTER);

    }

    public static void updateMap(GameMap map){
        MapComponents field = new MapComponents(map);
        frame.getContentPane().add(field, BorderLayout.CENTER);
        frame.repaint();
    }

}
