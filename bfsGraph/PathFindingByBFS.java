package bfsGraph;

import java.util.ArrayList;
import java.util.LinkedList;

import node.GraphNode;

public class PathFindingByBFS {
    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

    public PathFindingByBFS(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addUndirectedEdge(int i, int j) {
        GraphNode firstNode = nodeList.get(i);
        GraphNode secondNode = nodeList.get(j);
        firstNode.getNeighbors().add(secondNode);
        secondNode.getNeighbors().add(firstNode);
    }

    public void pathPrinting(GraphNode node) {
        if(node.getParent()!=null) {
            pathPrinting(node.getParent());
        }
        System.out.print(node+" ");
    }

    public void BFSForSSSP(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            GraphNode presentNode = queue.remove(0);
            presentNode.setVisited(true);
            System.out.print("Printing path for node "+presentNode.getName()+": ");
            pathPrinting(presentNode);
            System.out.println("\n");

            for(GraphNode neighbor: presentNode.getNeighbors()) {
                if(!neighbor.isVisited()) {
                    queue.add(neighbor);
                    neighbor.setVisited(true);
                    neighbor.setParent(presentNode);
                }
            }
        }
    }
}