
package Map;


import java.util.ArrayList;

public class Node {
    //Для добавления возможнсти упрощеннй обработки дробных значени цена движения на 1 клетку 10 а не 1.
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
    public String toString() {
        String str = this.getCoordinate() + "|" + this.getCostMoveTotal() + "|"
                + this.getCostMoveHeuristic() + "|" + this.getCostMove();
        return str;
    }
}
