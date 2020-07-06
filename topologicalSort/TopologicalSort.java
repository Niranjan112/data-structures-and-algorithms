package topologicalSort;

import java.util.ArrayList;
import java.util.Stack;

import node.GraphNode;

public class TopologicalSort {
    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

    public TopologicalSort(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addDirectedEdge(int i, int j) {
        GraphNode firstNode = nodeList.get(i-1);
        GraphNode secondNode = nodeList.get(j-1);
        firstNode.getNeighbors().add(secondNode);
    }

    public void topologicalSort() {
        Stack<GraphNode> stack = new Stack<>();
        for(GraphNode node: nodeList) {
            if(!node.isVisited()) {
                topologicalSortVisit(node, stack);
            }
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public void topologicalSortVisit(GraphNode node, Stack<GraphNode> stack) {
        for(GraphNode neighbor: node.getNeighbors()) {
            if(!neighbor.isVisited()) {
                topologicalSortVisit(neighbor, stack);
            }
        }
        node.setVisited(true);
        stack.push(node);
    }
}