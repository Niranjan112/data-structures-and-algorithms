package bfsGraph;

import java.util.ArrayList;
import java.util.LinkedList;

import node.GraphNode;

public class BFSByLinkedList {
    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

    public BFSByLinkedList(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void bfs() {
        for(GraphNode node: nodeList) {
            if(!node.isVisited()) {
                bfsVisit(node);
            }
        }
    }

    public void bfsVisit(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);

        while(!queue.isEmpty()) {
            GraphNode presentNode = queue.remove(0);
            presentNode.setVisited(true);
            System.out.print(presentNode.getName() + " ");

            for(GraphNode neighbor: presentNode.getNeighbors()) {
                if(!neighbor.isVisited()) {
                    queue.add(neighbor);
                    neighbor.setVisited(true);
                }
            }
        }
    }

    public void addUndirectedEdge(int i, int j) {
        GraphNode firstNode = nodeList.get(i-1);
        GraphNode secondNode = nodeList.get(j-1);
        firstNode.getNeighbors().add(secondNode);
        secondNode.getNeighbors().add(firstNode);
    }
}