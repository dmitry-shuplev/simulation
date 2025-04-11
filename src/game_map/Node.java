
package game_map;


import java.util.ArrayList;

public class Node {
    private Coordinate nodeCoordinate;
    Node parantNode;
    int costMoveTotal;
    int costMoveHeuristic;
    int costMove;

    public Node() {
    }

    public Node(Coordinate coordinate) {
        nodeCoordinate = coordinate;
    }

    public Coordinate getCoordinate() {
        return nodeCoordinate;
    }

    public Node getParantNode() {
        return parantNode;
    }

    public void setParantNode(Node parantNode) {
        this.parantNode = parantNode;
    }

    public int getCostMoveTotal() {
        return costMoveTotal;
    }

    public void setCostMoveTotal(int costMoveTotal) {
        this.costMoveTotal = costMoveTotal;
    }

    public int getCostMoveHeuristic() {
        return costMoveHeuristic;
    }

    public void setCostMoveHeuristic(int costMoveHeuristic) {
        this.costMoveHeuristic = costMoveHeuristic;
    }

    public int getCostMove() {
        return costMove;
    }

    public void setCostMove(int costMove) {
        this.costMove = costMove;
    }

    public Node getDuplicateFrom(ArrayList<Node> queue) {
        for (Node currentNode : queue) {
            if (currentNode.getCoordinate().equals(this.getCoordinate())) {
                return currentNode;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Сравнение ссылок
        if (obj == null || !(obj instanceof Node)) return false; // Проверка типа
        Node other = (Node) obj;
        return this.nodeCoordinate.equals(other.nodeCoordinate); // Сравнение по координатам
    }

    @Override
    public int hashCode() {
        return nodeCoordinate.hashCode(); // Используем хэш-код координат
    }

    @Override
    public String toString() {
        return this.getCoordinate() + "|" + this.getCostMoveTotal() + "|"
                + this.getCostMoveHeuristic() + "|" + this.getCostMove();
    }
}
