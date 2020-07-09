package dijkstras;

import java.util.ArrayList;
import java.util.PriorityQueue;

import node.WeightedNode;

public class PathFindingByDijkstras {
    ArrayList<WeightedNode> nodeList = new ArrayList<>();

    public PathFindingByDijkstras(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addWeightedEdge(int i, int j, int d) {
        WeightedNode firstNode = nodeList.get(i - 1);
        WeightedNode secondNode = nodeList.get(j - 1);

        firstNode.getNeighbors().add(secondNode);
        firstNode.getWeightMap().put(secondNode, d);
    }

    public void dijkstrasTraversal(WeightedNode node) {
        PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
        node.setDistance(0);
        queue.addAll(nodeList);

        while(!queue.isEmpty()) {
            WeightedNode presentNode = queue.remove();
            for(WeightedNode neighbor: presentNode.getNeighbors()) {
                if(neighbor.getDistance() > (presentNode.getDistance() + presentNode.getWeightMap().get(neighbor))) {
                    neighbor.setDistance(presentNode.getDistance() + presentNode.getWeightMap().get(neighbor));
                    neighbor.setParent(presentNode);

                    queue.remove(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        for (WeightedNode nodeToCheck : nodeList) {
            System.out.print("Node "+nodeToCheck+", distance: "+nodeToCheck.getDistance()+", Path: ");
            printPath(nodeToCheck);
            System.out.println();

        }
    }

    public void printPath(WeightedNode node) {
        if(node.getParent() != null) {
            printPath(node.getParent());
            System.out.print("->" + node);
        } else {
            System.out.print(node);
        }
    }


}