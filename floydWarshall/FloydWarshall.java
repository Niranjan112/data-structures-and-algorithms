package floydWarshall;

import java.util.ArrayList;

import node.WeightedNode;

public class FloydWarshall {
    ArrayList<WeightedNode> nodeList = new ArrayList<>();

    public FloydWarshall(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void floydWarshall() {
        int size = nodeList.size();
        int[][] V = new int[size][size];

        // Initializing Distance table from adjacency list
        for (int i = 0; i < size; i++) {
            WeightedNode firstNode = nodeList.get(i);
            for (int j = 0; j < size; j++) {
                WeightedNode secondNode = nodeList.get(j);

                if(i == j) {
                    V[i][j] =  0;
                } else if(firstNode.getWeightMap().containsKey(secondNode)) {
                    V[i][j] = firstNode.getWeightMap().get(secondNode);
                } else {
                    V[i][j] = Integer.MAX_VALUE / 10;
                }
            }
        }

        // Floyd Warshall's Algorithm
        for(int k = 0; k < nodeList.size(); k++) {
            for (int i = 0; i < nodeList.size(); i++) {
                for (int j = 0; j < nodeList.size(); j++) {
                    if(V[i][j] > V[i][k] + V[k][j]) {
                        V[i][j] = V[i][k] + V[k][j];
                    }
                }
            }
        }

        // Print table of node with minimum distance and shortest path from each source
        for (int i = 0; i < size; i++) {
            System.out.print("Printing distance list for node " + nodeList.get(i) + ": ");
            for (int j = 0; j < size; j++) {
                System.out.print(V[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void addWeightedEdge(int i, int j, int d) {
        WeightedNode firstNode = nodeList.get(i - 1);
        WeightedNode secondNode = nodeList.get(j - 1);
        firstNode.getNeighbors().add(secondNode);
        firstNode.getWeightMap().put(secondNode, d);
    }
}