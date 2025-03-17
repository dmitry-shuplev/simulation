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
        JFrame frame = new JFrame();
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //GraphModel graphModel = new GraphModel();

        BorderLayout borderLayout = new BorderLayout();
       // FieldComponent field = new FieldComponent(graphModel);
        Button buttonStartWide = new Button("Сгенерировать карту");
        Button buttonStartDeep = new Button("Сделать ход");
        Button buttonReset = new Button("Запустить карту");
        Button buttonStepWide = new Button("Шаг в ширину");
        Button buttonStepDeep = new Button("Шаг в глубину");

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        buttons.add(buttonStartWide);
        buttons.add(buttonStartDeep);
        buttons.add(buttonStepWide);
        buttons.add(buttonStepDeep);
        buttons.add(buttonReset);

        frame.getContentPane().setLayout(borderLayout);
        //frame.getContentPane().add(field, BorderLayout.CENTER);
        frame.getContentPane().add(buttons, BorderLayout.PAGE_END);

        /*buttonReset.addActionListener(e -> field.clear());
        buttonStartWide.addActionListener(e -> field.startWide());
        buttonStartDeep.addActionListener(e -> field.startDeep());
        buttonStepWide.addActionListener(e -> field.stepWide());
        buttonStepDeep.addActionListener(e -> field.stepDeep());*/

        frame.setVisible(true);
       // field.clear();
    }



}
