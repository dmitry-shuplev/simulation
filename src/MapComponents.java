import javax.swing.*;
import javax.swing.text.html.parser.Entity;

import Config.Settings;
import Map.*;

import java.awt.*;

public class MapComponents extends JComponent {
    private Map currentMap;

    public MapComponents(Map map) {
        this.currentMap = map;
    }

    @Override
    public void paint(Graphics g) {
        //super.paint(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, Settings.MAP_WIDTH, Settings.MAP_HEIGHT);

        int cellSize = getWidth() / Settings.MAP_WIDTH;

        for (int y = 0; y < Settings.MAP_HEIGHT; y++) {
            for (int x = 0; x < Settings.MAP_WIDTH; x++) {
                switch (getEntitySymbol(x, y)) {
                    case 'P':
                        g.setColor(Color.RED);
                          break;
                    case 'H':
                        g.setColor(Color.PINK);
                        break;
                    case 'G':
                        g.setColor(new Color(144, 238, 144));
                        break;
                    case 'T':
                        g.setColor(Color.GREEN);
                        break;
                    case 'R':
                        g.setColor(Color.BLACK);
                        break;
                    default:
                        g.setColor(Color.LIGHT_GRAY);
                }
                g.fillRect(x * cellSize, y * cellSize, (int) (cellSize / 1.2), (int) (cellSize / 1.2));
            }
        }
    }

    private char getEntitySymbol(int x, int y) {
        Coordinate coordinate = new Coordinate(x, y);
        if (currentMap.getMap().get(coordinate) != null) {
            return currentMap.getMap().get(coordinate).getView();
        }
        return 'E';
    }

}
