package view;

import game_map.*;
import simulation.Simulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View {
    private static JFrame frame = new JFrame();
    static private JLabel stepsLabel;

    public static void createViewMap(GameMap map) {
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 600);
        frame.setLocation(150, 50);
        frame.setTitle("Это проект Симуляция Road_map Сергея Жукова");

        MapComponents field = new MapComponents(map);
        frame.getContentPane().add(field, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton startButton = new JButton("Start");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Simulation.start();
            }
        });

        JButton pauseButton = new JButton("Pause");
        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Simulation.pause();
            }
        });

        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Simulation.stop();
            }
        });

        buttonPanel.add(startButton);
        buttonPanel.add(pauseButton);
        buttonPanel.add(stopButton);

        JPanel stepsPanel = new JPanel(); // Новая панель для счетчика шагов
        stepsLabel = new JLabel("Шаги: 0"); // Создание JLabel для отображения шагов
        stepsPanel.add(stepsLabel); // Добавление JLabel на панель счетчика шагов

        // Добавление панелей в окно
        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH); // Панель кнопок
        frame.getContentPane().add(stepsPanel, BorderLayout.NORTH); // Панель счетчика шагов


    }

    public static void updateMap(GameMap map) {
        MapComponents field = new MapComponents(map);
        frame.getContentPane().add(field, BorderLayout.CENTER);
        frame.repaint();
    }

    public static void updateStepsLabel() { // Метод для обновления счетчика шагов
        int steps = Simulation.getStepsNumber();
        stepsLabel.setText("Шаги: " + steps); // Обновление текста JLabel
    }

}
