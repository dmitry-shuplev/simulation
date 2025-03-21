import Map.*;
import Config.Settings.*;
import Subjects.Entity;

import javax.swing.*;
import java.awt.*;
import java.lang.ref.Cleaner;

public class View {

    public static void createViewMap(Map map){
        JFrame frame = new JFrame() {};
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 600);
        frame.setLocation(150, 50);
        frame.setTitle("Это проект Симуляция Road_map Сергея Жукова");

        MapComponents field = new MapComponents(map);
        frame.getContentPane().add(field, BorderLayout.CENTER);
    }


}
