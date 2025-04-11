package interfaces;

import config.Settings;
import game_map.Coordinate;
import game_map.GameMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import static config.Settings.SEARCH_AREA;
import game_map.*;

public interface Seeking {
    public default Coordinate findPreyCoordinate(GameMap map, char entityType) {
        ArrayList<Coordinate> wasChecked = new ArrayList<>();
        ArrayList<Coordinate> queue = new ArrayList<>();
        queue.add(this.getCoordinate());
        while (!queue.isEmpty()) {
            Coordinate currentNodeCoordinate = queue.remove(0);
            wasChecked.add(currentNodeCoordinate);
            for (Coordinate nodeCoordinate : map.getNaighbors(currentNodeCoordinate)) {
                if (!wasChecked.contains(nodeCoordinate) && !queue.contains(nodeCoordinate)) {
                    if (!map.isFieldEmpty(nodeCoordinate) && map.getMap().get(nodeCoordinate).getOwnSimbols() == entityType) {
                        return nodeCoordinate;
                    }
                    queue.add(nodeCoordinate);
                }
            }
        }
        return Coordinate.getRandCoordinate(map);
    }

    public default ArrayList<Coordinate> findPath(GameMap map, Coordinate targetCreatureCoordinate) {
        ArrayList<Coordinate> path = new ArrayList<>();
        ArrayList<Node> queue = new ArrayList<>();
        ArrayList<Node> wasCheked = new ArrayList<>();
        Node rootNode = new Node(this.getCoordinate());
        int stepCounter = 0;
        queue.add(rootNode);
        Node processedNode = new Node();
        baseLoop:
        while (!queue.isEmpty()) {
            stepCounter++;
            if (stepCounter > SEARCH_AREA) {
                break baseLoop;
            }
            processedNode = queue.remove(0);
            for (Coordinate nodeCoordinate : map.getNaighbors(processedNode.getCoordinate())) {
                if (nodeCoordinate.equals(targetCreatureCoordinate)) {
                    break baseLoop;
                }
                if (map.isFieldEmpty(nodeCoordinate)) {
                    Node newNode = new Node(nodeCoordinate);
                    if (wasCheked.contains(newNode)) {
                        continue;
                    }
                    newNode.setParantNode(processedNode);
                    newNode.setCostMove(processedNode.getCostMove() + Settings.MOVE_PRICE);
                    newNode.setCostMoveHeuristic(Coordinate.getHeuristicCoast(nodeCoordinate, targetCreatureCoordinate));
                    newNode.setCostMoveTotal(newNode.getCostMove() + newNode.getCostMoveHeuristic());
                    Node duplicateNode = newNode.getDuplicateFrom(queue);
                    if (duplicateNode == null) {
                        queue.add(newNode);
                    } else if (duplicateNode.getCostMoveTotal() > newNode.getCostMoveTotal()) {
                        queue.remove(duplicateNode);
                        queue.add(newNode);
                    }
                }
            }
            wasCheked.add(processedNode);//Добавляем узел в массив отработанных
            Collections.sort(queue, Comparator.comparing(Node::getCostMoveTotal).thenComparingInt(Node::getCostMoveHeuristic));
        }//конец основного цикла
        while (!processedNode.equals(rootNode)) {
            path.add(0, processedNode.getCoordinate());
            processedNode = processedNode.getParantNode();
        }
        return path;
    }

    Coordinate getCoordinate();

    void setCoordinate(Coordinate coordinate);

}
