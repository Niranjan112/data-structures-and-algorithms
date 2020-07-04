package dfsGraph;

import java.util.ArrayList;

import node.GraphNode;

public class DFSRecursive {
    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

    public DFSRecursive(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addUndirectedEdge(int i, int j) {
        GraphNode firstNode = nodeList.get(i-1);
        GraphNode secondNode = nodeList.get(j-1);
        firstNode.getNeighbors().add(secondNode);
        secondNode.getNeighbors().add(firstNode);
    }

    public void dfs() {
        for(GraphNode node: nodeList) {
            if(!node.isVisited()) {
                dfsVisit(node);
            }
        }
    }

    public void dfsVisit(GraphNode node) {
        node.setVisited(true);
        System.out.print(node.getName()+" ");

        for(GraphNode neighbor: node.getNeighbors()) {
            if(!neighbor.isVisited()) {
                dfsVisit(neighbor);
            }
        }
    }
}