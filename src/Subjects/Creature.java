package Subjects;

import Config.Settings;
import Config.Settings.*;
import Map.*;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public abstract class Creature extends Entity {

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

    public Entity finedObject(Map map, char entityType) {
        ArrayList<Coordinate> wasChecked = new ArrayList<>();
        ArrayList<Coordinate> queue = new ArrayList<>();
        queue.add(this.getCoordinate());
        while (!queue.isEmpty()) {
            Coordinate currentNodeCoordinate = queue.remove(0);
            wasChecked.add(currentNodeCoordinate);
            for (Coordinate nodeCoordinate : map.getNaighbors(currentNodeCoordinate)) {
                if (!wasChecked.contains(nodeCoordinate) && !queue.contains(nodeCoordinate)) {
                    if (!map.isFieldEmpty(nodeCoordinate) && map.getMap().get(nodeCoordinate).getView() == entityType) {
                        return map.getMap().get(nodeCoordinate);
                    }
                    queue.add(nodeCoordinate);
                }
            }
        }
        return null;
    }

    public ArrayList<Node> finedPath(Map map, Coordinate targetCoordinate) {
        ArrayList<Node> path = new ArrayList<>();
        ArrayList<Node> wasChecked = new ArrayList<>();
        ArrayList<Node> queue = new ArrayList<>();
        queue.add(new Node(this.getCoordinate()));
        Node currentNode = queue.remove(0);
        while (!(map.getNaighbors(currentNode.getCoordinate())).contains(targetCoordinate)) {
            for (Coordinate naighbourCoordinate : map.getNaighbors(currentNode.getCoordinate())) {
                Node operatedNode = new Node(naighbourCoordinate);
                if (!wasChecked.contains(operatedNode) && map.isFieldEmpty(operatedNode.getCoordinate())) {
                    //дбавляем координаты родительского узла в текущий узел
                    operatedNode.setParantNode(currentNode);
                    //вычисляем и добавляем цену пути до текущего узла, эвристическую стоимсть, и общую стоимость пути.
                    operatedNode.setCostMove(currentNode.getCostMove() + Settings.MOVE_PRICE);
                    operatedNode.setCostMoveHeuristic(Coordinate.getHeuristicCoast(operatedNode.getCoordinate(), targetCoordinate));
                    operatedNode.setCostMoveTotal(operatedNode.getCostMove() + operatedNode.getCostMoveHeuristic());
                    //добавляем узел в очередь на обработку
                    queue.add(operatedNode);
                }
            }
            //сортируем очередь по наименьшей цене пути
            Collections.sort(queue, Comparator.comparingInt(Node::getCostMoveTotal));
            //добавляем обработанный узел в лист проверенных
            wasChecked.add(currentNode);
            //Берем элеметнт с наименьшей ценой движения(первый в отсортированом списке.
            if (queue.isEmpty()) {
                System.out.println("Путь не найден");
                return null;
            } else {
                currentNode = queue.remove(0);
            }
        }
        while (!currentNode.getCoordinate().equals(this.getCoordinate())) {
            path.add(0, currentNode);
            currentNode = currentNode.getParantNode();
        }
        return path;
    }

    private int getAbsolutelyWeightPath(Coordinate currentCoordinate, Coordinate targetCoordinate) {
        return Math.abs(targetCoordinate.x - currentCoordinate.x) + Math.abs(targetCoordinate.y - currentCoordinate.y);
    }


}
