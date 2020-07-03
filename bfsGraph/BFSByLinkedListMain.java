package bfsGraph;

import java.util.ArrayList;

import node.GraphNode;

public class BFSByLinkedListMain {
    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

        for (int i = 1; i < 11; i++) {
            nodeList.add(new GraphNode("V" + i, i-1));
        }

        BFSByLinkedList graph = new BFSByLinkedList(nodeList);

        graph.addUndirectedEdge(1,2);
        graph.addUndirectedEdge(1,4);
        graph.addUndirectedEdge(2,3);
        graph.addUndirectedEdge(2,5);
        graph.addUndirectedEdge(3,6);
        graph.addUndirectedEdge(3,10);
        graph.addUndirectedEdge(4,7);
        graph.addUndirectedEdge(5,8);
        graph.addUndirectedEdge(6,9);
        graph.addUndirectedEdge(7,8);
        graph.addUndirectedEdge(8,9);
        graph.addUndirectedEdge(9,10);

        System.out.println("Printing BFS from source: V1");
        graph.bfs();
    }
}