package Subjects;

import Config.Settings;
import Map.*;
import Map.Map;
import java.util.*;
import static Config.Settings.*;


public abstract class Creature extends Entity {

    private char preySymbol;
    private int satiaty;
    private int life;

    public void move(Direction direction, Map map) {
        Coordinate coordinate = getCoordinate();
        Coordinate newCoordinate = coordinate.getNextStepCoordinate(direction);
        if (map.isFieldEmpty(newCoordinate)) {
            map.removeEntity(coordinate);
            this.setCoordinate(newCoordinate);
            map.getMap().put(this.getCoordinate(), this);
        }
    }


    public Coordinate findPreyCoordinate(Map map, char entityType) {
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
/*первый вариант поиска пути*/
    public ArrayList<Coordinate> findPath(Map map, Coordinate targetCreatureCoordinate) {
        ArrayList<Coordinate> path = new ArrayList<>();
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


 //второй вариант поиска пути

    //конец второга варианта


    public boolean moveToPrey(Map map) {
        Coordinate preyCoordinate = findPreyCoordinate(map, getPreySymbol());
        ArrayList<Coordinate> path = findPath(map, preyCoordinate);
        if (path.isEmpty()) {
            return true;
        }
        Coordinate nextStepCoordinate = path.getFirst();
        Settings.Direction nextStep = this.getCoordinate().getDirection(nextStepCoordinate);
        this.move(nextStep, map);
        return false;
    }

    public void eat(Map map) {
        for (Coordinate neighborCoordinate : map.getNaighbors(this.getCoordinate())) {
            Entity entity = map.getEntityByCoordinate(neighborCoordinate);

            if (entity != null) {
                if (entity.getView() == this.getPreySymbol()) {
                    entity.setLife(entity.getLife() - 1);
                }
            }
        }

    }

    public void increaseLife() {
        this.life--;
    }

    public char getPreySymbol() {
        return preySymbol;
    }
}
