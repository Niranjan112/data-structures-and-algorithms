package dfsGraph;

import java.util.ArrayList;
import java.util.Stack;

import node.GraphNode;

public class DFSIterative {
    ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();

    public DFSIterative(ArrayList<GraphNode> nodeList) {
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
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()) {
            GraphNode presentNode = stack.pop();
            presentNode.setVisited(true);
            System.out.print(presentNode.getName()+" ");

            for(GraphNode neighbor: presentNode.getNeighbors()) {
                if(!neighbor.isVisited()) {
                    stack.push(neighbor);
                    neighbor.setVisited(true);
                }
            }
        }
    }
}