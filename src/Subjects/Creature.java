package Subjects;

import Config.Settings;
import Config.Settings.*;
import Map.*;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import static Config.Settings.SEARCH_AREA;
import static java.lang.Thread.sleep;

public abstract class Creature extends Entity {

    private ArrayList<Coordinate> finedPath;

    public void move(Direction direction, Map map) {
        Coordinate coordinate = getCoordinate();
        Coordinate newCoordinate = coordinate.getNextStepCoordinate(direction);
        if (map.isFieldEmpty(newCoordinate)) {
            map.getMap().remove(coordinate);
            coordinate = newCoordinate;
            this.setCoordinate(coordinate);
            map.getMap().put(coordinate, this);
        }
    }


    public Coordinate findPurpouseCoordinate(Map map, char entityType) {
        ArrayList<Coordinate> wasChecked = new ArrayList<>();
        ArrayList<Coordinate> queue = new ArrayList<>();
        queue.add(this.getCoordinate());
        while (!queue.isEmpty()) {
            Coordinate currentNodeCoordinate = queue.remove(0);
            wasChecked.add(currentNodeCoordinate);
            for (Coordinate nodeCoordinate : map.getNaighbors(currentNodeCoordinate)) {
                if (!wasChecked.contains(nodeCoordinate) && !queue.contains(nodeCoordinate)) {
                    if (!map.isFieldEmpty(nodeCoordinate) && map.getMap().get(nodeCoordinate).getView() == entityType) {
                        return nodeCoordinate;
                    }
                    queue.add(nodeCoordinate);
                }
            }
        }
        return Coordinate.getRandCoordinate(map);
    }

    public ArrayList<Node> findPath(Map map, Creature targetCreature) {
        ArrayList<Node> path = new ArrayList<>();
        ArrayList<Node> queue = new ArrayList<>();
        ArrayList<Node> wasCheked = new ArrayList<>();
        Node rootNode = new Node(this.getCoordinate());
        int stepCounter = 0;
        queue.add(rootNode);
        Node processedNode = new Node();
        int total_stap = 0; //log
        baseLoop:
        while (!queue.isEmpty()) {
            stepCounter++;
            if (stepCounter > SEARCH_AREA) {
                break baseLoop;
            }
            processedNode = queue.remove(0);
            for (Coordinate nodeCoordinate : map.getNaighbors(processedNode.getCoordinate())) {
                if (nodeCoordinate.equals(targetCreature.getCoordinate())) {
                    break baseLoop;
                }
                if (map.isFieldEmpty(nodeCoordinate)) {
                    Node newNode = new Node(nodeCoordinate);
                    if (wasCheked.contains(newNode)) {
                        continue;
                    }
                    newNode.setParantNode(processedNode);
                    newNode.setCostMove(processedNode.getCostMove() + Settings.MOVE_PRICE);
                    newNode.setCostMoveHeuristic(Coordinate.getHeuristicCoast(nodeCoordinate, targetCreature.getCoordinate()));
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
            path.add(0, processedNode);
            processedNode = processedNode.getParantNode();
        }
        return path;
    }

}
