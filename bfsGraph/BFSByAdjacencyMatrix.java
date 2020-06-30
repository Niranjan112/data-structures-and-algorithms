package bfsGraph;

import java.util.ArrayList;
import java.util.LinkedList;

import node.GraphNode;

public class BFSByAdjacencyMatrix {
    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
    int[][] adjacencyMatrix;

    BFSByAdjacencyMatrix(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }

    public void bfs() {
        for(GraphNode node: nodeList) {
            if(!node.isVisited()) {
                bfsVisit(node);
            }
        }
    }

    public void bfsVisit(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
        queue.add(node);
        while(!queue.isEmpty()) {
            GraphNode presentNode = queue.remove(0);
            presentNode.setVisited(true);
            System.out.print(presentNode.getName() + " ");
            
            ArrayList<GraphNode> neighbors = getNeighbors(presentNode);
            for(GraphNode neighbor: neighbors) {
                if(!neighbor.isVisited()) {
                    queue.add(neighbor);
                    neighbor.setVisited(true);
                }
            }
        }
    }

    public ArrayList<GraphNode> getNeighbors(GraphNode node) {
        ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();

        int nodeIndex = node.getIndex();

        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if(adjacencyMatrix[nodeIndex][i] == 1) {
                neighbors.add(nodeList.get(i));
            }
        }

        return neighbors;
    }

    public void addUndirectedEdge(int i, int j) {
        i--;
        j--;
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
    }
}