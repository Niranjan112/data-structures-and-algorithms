package topologicalSort;

import java.util.ArrayList;

import node.GraphNode;

public class topologicalSortMain {
    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<>();

        for (int i = 1; i < 7; i++) {
            nodeList.add(new GraphNode("V"+i));
        }

        TopologicalSort graph = new TopologicalSort(nodeList);

        graph.addDirectedEdge(6, 3);  
        graph.addDirectedEdge(6, 1);  
        graph.addDirectedEdge(5, 1);  
        graph.addDirectedEdge(5, 2);  
        graph.addDirectedEdge(3, 4);  
        graph.addDirectedEdge(4, 2);

        graph.topologicalSort();
    }
}