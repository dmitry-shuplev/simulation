package view;

import javax.swing.*;
import config.Settings;
import game_map.*;
import java.awt.*;
import java.util.ArrayList;

public class MapComponents extends JComponent {
    private GameMap currentMap;
    private Image predatorImage;
    private Image herbvoreImage;
    private Image grassImage;
    private Image treeImage;
    private Image rockImage;


    public MapComponents(GameMap map) {
        this.currentMap = map;
    }

    public MapComponents(GameMap map, ArrayList<Coordinate> path) {
        this.currentMap = map;
    }


    @Override
    public void paint(Graphics g) {
        //super.paint(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Settings.MAP_WIDTH, Settings.MAP_HEIGHT);

        predatorImage = new ImageIcon(getClass().getResource("/images/predator.png")).getImage();
        herbvoreImage = new ImageIcon(getClass().getResource("/images/rabit1.png")).getImage();
        grassImage = new ImageIcon(getClass().getResource("/images/grass3.png")).getImage();
        treeImage = new ImageIcon(getClass().getResource("/images/tree.png")).getImage();
        rockImage = new ImageIcon(getClass().getResource("/images/rock2.png")).getImage();

        int cellSize = getWidth() / Settings.MAP_WIDTH;

        for (int y = 0; y < Settings.MAP_HEIGHT; y++) {
            for (int x = 0; x < Settings.MAP_WIDTH; x++) {

                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(x * cellSize, y * cellSize, (int) (cellSize / 1.2), (int) (cellSize / 1.2));


                switch (getEntitySymbol(x, y)) {
                    case 'P':
                        g.setColor(Color.RED);
                        g.fillRect(x * cellSize, y * cellSize, (int) (cellSize / 1.2), (int) (cellSize / 1.2));
                        g.drawImage(predatorImage, x * cellSize, y * cellSize, (int) (cellSize / 1.2), (int) (cellSize / 1.2), this);
                        break;
                    case 'H':
                        g.setColor(Color.PINK);
                        g.fillRect(x * cellSize, y * cellSize, (int) (cellSize / 1.2), (int) (cellSize / 1.2));
                        g.drawImage(herbvoreImage, x * cellSize, y * cellSize, (int) (cellSize / 1.5), (int) (cellSize / 1.5), this);
                        break;
                    case 'G':
                        g.setColor(new Color(144, 238, 144));
                        g.fillRect(x * cellSize, y * cellSize, (int) (cellSize / 1.2), (int) (cellSize / 1.2));
                        g.drawImage(grassImage, x * cellSize, y * cellSize, (int) (cellSize / 1.2), (int) (cellSize / 1.2), this);
                        break;
                    case 'T':
                        g.setColor(Color.GREEN);
                        g.fillRect(x * cellSize, y * cellSize, (int) (cellSize / 1.2), (int) (cellSize / 1.2));
                        g.drawImage(treeImage, x * cellSize, y * cellSize, (int) (cellSize / 1.2), (int) (cellSize / 1.2), this);
                        break;
                    case 'R':
                        g.setColor(new Color(139, 69, 19));
                        g.fillRect(x * cellSize, y * cellSize, (int) (cellSize / 1.2), (int) (cellSize / 1.2));
                        g.drawImage(rockImage, x * cellSize, y * cellSize, (int) (cellSize / 1.2), (int) (cellSize / 1.2), this);
                        break;
                    case 'p':
                        g.setColor(Color.DARK_GRAY);
                        g.fillRect(x * cellSize, y * cellSize, (int) (cellSize / 1.2), (int) (cellSize / 1.2));
                        break;
                    default:
                        break;
                }

            }
        }
    }

    private char getEntitySymbol(int x, int y) {
        Coordinate coordinate = new Coordinate(x, y);

        if (currentMap.getPath().contains(coordinate)) {
            return 'p';
        }
        if (currentMap.getMap().get(coordinate) != null) {
            return currentMap.getMap().get(coordinate).getOwnSimbols();
        }
        return 'E';
    }


}
