package Subjects;

import Config.Settings;
import Config.Settings.*;
import Map.*;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import static java.lang.Thread.sleep;

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
        int total_staps = 0;
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
                System.out.println(total_staps++ + ":" + operatedNode.toString());
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

    //__________________________________________________________________finedPath2
    public ArrayList<Node> finedPath2(Map map, Creature targetCreature) {
        ArrayList<Node> path = new ArrayList<>();
        ArrayList<Node> queue = new ArrayList<>();
        ArrayList<Node> wasCheked = new ArrayList<>();
        Node rootNode = new Node(this.getCoordinate());
        queue.add(rootNode); //добавлен первый узел в очередь;
        // Основной цикл будет действовать пока очередь не пуста
        Node processedNode = new Node();
        int total_stap = 0; //log
        baseLoop:
        while (!queue.isEmpty()) {
            processedNode = queue.remove(0);//взяли из очереди и удалили первый элемент
            //создаем по координатам и добавляем в очередь все  _доступные_ соседние узлы
            //log
            System.out.println(total_stap++ + " Проверяемый узел | " + processedNode.toString());
            //log end

            for (Coordinate nodeCoordinate : map.getNaighbors(processedNode.getCoordinate())) {
            if(nodeCoordinate.equals(targetCreature.getCoordinate())){break baseLoop;}
                //если поле с координатами свободно то создаем и добавляем очередь в узел
                if (map.isFieldEmpty(nodeCoordinate)) {
                    Node newNode = new Node(nodeCoordinate);
                    if (wasCheked.contains(newNode)) {
                        //log
                        System.out.println(" добавляемый узел уже был проверен | " + newNode.toString());
                        //log end
                        continue;
                    }//проверка был ли уже обработан этот узел
                    newNode.setParantNode(processedNode);//добавляем узел родитель
                    newNode.setCostMove(processedNode.getCostMove() + Settings.MOVE_PRICE);
                    newNode.setCostMoveHeuristic(Coordinate.getHeuristicCoast(nodeCoordinate, targetCreature.getCoordinate()));
                    newNode.setCostMoveTotal(newNode.getCostMove() + newNode.getCostMoveHeuristic());
                    //проверка узла на уникальность(есть ли узел с такими же координатами в списке)
                    Node duplicateNode = newNode.getDuplicateFrom(queue);
                    if (duplicateNode == null) {
                        queue.add(newNode);
                        //log
                        System.out.println("добавлен в чередь | " + newNode);
                        //log end
                    } else if (duplicateNode.getCostMoveTotal() > newNode.getCostMoveTotal()) {
                        queue.remove(duplicateNode);
                        //log
                        System.out.println("пересчитан узел | " + duplicateNode);
                        //log end
                        queue.add(newNode);
                        //log
                        System.out.println("на | " + newNode.toString());
                        //log end
                    }
                }
            }
            //сортируем массив очереди по общей цене пути и выбираем нулевой(с наименьшей ценой пути) для следующей итерации
            wasCheked.add(processedNode);//Добавляем узел в массив отработанных
            Collections.sort(queue, Comparator.comparing(Node::getCostMoveTotal).thenComparingInt(Node::getCostMoveHeuristic));
            //log
            // Вывод отсортированного списка
            System.out.println("Отсортированный список:");
            for (Node node : queue) {
                System.out.println(node.toString()); // Выводим каждый узел
            }
            //log end

            //log
            /*
            try {
                // Ожидание 1 секунду (1000 миллисекунд)
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Обработка исключения, если поток был прерван
                System.out.println("Поток прерван: " + e.getMessage());
            }*/


        }//конец основного цикла
        //log
        System.out.println("Конец цикла");
        System.out.println(processedNode.toString());
        System.out.println(processedNode.getParantNode().toString());
        //log end
//преобразование массива узлов в массив координат
        while (!processedNode.equals(rootNode)) {
           //log
            System.out.println("получение пути");
            //log end
            path.add(0, processedNode);
            processedNode = processedNode.getParantNode();
        }
        return path;
        //end of fined Creatuer
    }

    private int getAbsolutelyWeightPath(Coordinate currentCoordinate, Coordinate targetCoordinate) {
        return Math.abs(targetCoordinate.x - currentCoordinate.x) + Math.abs(targetCoordinate.y - currentCoordinate.y);
    }


}
