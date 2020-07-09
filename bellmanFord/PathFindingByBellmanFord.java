package bellmanFord;

import java.util.ArrayList;

import node.WeightedNode;

public class PathFindingByBellmanFord {
    ArrayList<WeightedNode> nodeList = new ArrayList<>();

    public PathFindingByBellmanFord(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
        for(WeightedNode node: nodeList) {
            node.setDistance(Integer.MAX_VALUE/10);
        }
    }

    public void bellmanFord(WeightedNode source) {
        source.setDistance(0);

        for (int i = 1; i < nodeList.size(); i++) {
            for(WeightedNode presentNode: nodeList) {
                for(WeightedNode neighborNode: presentNode.getNeighbors()) {
                    if(neighborNode.getDistance() > (presentNode.getDistance() + presentNode.getWeightMap().get(neighborNode))) {
                        neighborNode.setDistance(presentNode.getDistance() + presentNode.getWeightMap().get(neighborNode));
                        neighborNode.setParent(presentNode);
                    }
                }
            }
        }

        //Checking for negative cycle
        System.out.println("Checking for negative cycle");
        for(WeightedNode presentNode: nodeList) {
            for(WeightedNode neighborNode: presentNode.getNeighbors()) {
                if(neighborNode.getDistance() > (presentNode.getDistance() + presentNode.getWeightMap().get(neighborNode))) {
                    System.out.println("Negative Cycle found: \n");
                    System.out.println("Vertex Name: " + neighborNode);
                    System.out.println("Old Distance: " + neighborNode.getDistance());
                    int newDistance = presentNode.getDistance() + presentNode.getWeightMap().get(neighborNode);
                    System.out.println("New Distance: " + newDistance);
                    return;
                }
            }
        }

        System.out.println("Negative cycle not found !");

        System.out.println("\nPrinting Paths now: ");
        for(WeightedNode nodeToCheck: nodeList) {
            if(nodeToCheck.getDistance() != Integer.MAX_VALUE / 10) {
                System.out.print("Node " + nodeToCheck + ", distance: " + nodeToCheck.getDistance() + ", Path: ");
                pathPrinting(nodeToCheck);
            } else {
                System.out.print("No path for node " + nodeToCheck);
            }
            System.out.println();
        }
    }

    public void pathPrinting(WeightedNode node) {
        if(node.getParent() != null) {
            pathPrinting(node.getParent());
            System.out.print("->" + node);
        } else {
            System.out.print(node);
        }
    }

    public void addWeightedEdge(int i, int j, int d) {
        WeightedNode firstNode = nodeList.get(i - 1);
        WeightedNode secondNode = nodeList.get(j - 1);

        firstNode.getNeighbors().add(secondNode);
        firstNode.getWeightMap().put(secondNode, d);
    }
}