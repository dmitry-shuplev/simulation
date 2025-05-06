package view;

import game_map.*;
import simulation.Simulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View {
    private static JFrame frame = new JFrame();
    private static JButton startSimulation;

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

        buttonPanel.add(startButton);
        buttonPanel.add(pauseButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);

    }

    public static void updateMap(GameMap map) {
        MapComponents field = new MapComponents(map);
        frame.getContentPane().add(field, BorderLayout.CENTER);
        frame.repaint();
    }

}
