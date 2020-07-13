package mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import node.WeightedNodeForDisjointSet;

public class Kruskal {
  ArrayList<WeightedNodeForDisjointSet> nodeList = new ArrayList<>();
  ArrayList<UndirectedEdge> edgeList = new ArrayList<>();

  public Kruskal(ArrayList<WeightedNodeForDisjointSet> nodeList) {
    this.nodeList = nodeList;
  }

  public void kruskal() {
    DisjointSet.makeSet(nodeList);

    Comparator<UndirectedEdge> comparator = new Comparator<UndirectedEdge>() {
      @Override
      public int compare(UndirectedEdge o1, UndirectedEdge o2) {
        return o1.getWeight() - o2.getWeight();
      }
    };

    Collections.sort(edgeList, comparator);
    int cost = 0;
    for(UndirectedEdge edge: edgeList) {
      WeightedNodeForDisjointSet firstNode = edge.getFirst();
      WeightedNodeForDisjointSet secondNode = edge.getSecond();

      if(!DisjointSet.findSet(firstNode).equals(DisjointSet.findSet(secondNode))){
        DisjointSet.union(firstNode, secondNode);
        cost += edge.getWeight();
        System.out.println("Taken " + edge);
      }
    }
		System.out.println("\nTotal cost of MST: " + cost);
  }

  public void addWeightedUndirectedEdge(int firstIndex, int secondIndex, int weight ) {
    UndirectedEdge edge = new UndirectedEdge(nodeList.get(firstIndex - 1), nodeList.get(secondIndex - 1), weight);
    WeightedNodeForDisjointSet firstNode = edge.getFirst();
    WeightedNodeForDisjointSet secondNode = edge.getSecond();
    firstNode.getNeighbors().add(secondNode);
    secondNode.getNeighbors().add(firstNode);
    firstNode.getWeightMap().put(secondNode, weight);
    secondNode.getWeightMap().put(firstNode, weight);
    edgeList.add(edge);
  }
}