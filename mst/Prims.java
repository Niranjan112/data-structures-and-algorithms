package mst;

import java.util.ArrayList;
import java.util.PriorityQueue;

import node.WeightedNode;

public class Prims {
  ArrayList<WeightedNode> nodeList = new ArrayList<>();

  public Prims(ArrayList<WeightedNode> nodeList) {
    this.nodeList = nodeList;
  }

  public void addWeightedUndirectedEdge(int i, int j, int d) {
    WeightedNode firstNode = nodeList.get(i - 1);
    WeightedNode secondNode = nodeList.get(j - 1);
    firstNode.getNeighbors().add(secondNode);
    secondNode.getNeighbors().add(firstNode);
    firstNode.getWeightMap().put(secondNode, d);
    secondNode.getWeightMap().put(firstNode, d);
  }

  public void prims(WeightedNode node) {
    for(int counter = 0; counter < nodeList.size(); counter++) {
      nodeList.get(counter).setDistance(Integer.MAX_VALUE);
    }

    node.setDistance(0);

    PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
    queue.addAll(nodeList);

    while(!queue.isEmpty()) {
      WeightedNode presentNode = queue.remove();

      for(WeightedNode neighbor: presentNode.getNeighbors()) {
        if(queue.contains(neighbor)) {
          if(neighbor.getDistance() > presentNode.getWeightMap().get(neighbor)) {
            neighbor.setDistance(presentNode.getWeightMap().get(neighbor));
            neighbor.setParent(presentNode);
            queue.remove(neighbor);
            queue.add(neighbor);
          }
        }
      }
    }

    int cost = 0;
    for(WeightedNode nodeToCheck: nodeList) {
      System.out.println("Node " + nodeToCheck + ", key: " + nodeToCheck.getDistance() + ", Parent: " + nodeToCheck.getParent());
      cost = cost + nodeToCheck.getDistance();
    }

		System.out.println("\nTotal cost of MST: " + cost);
  }
}