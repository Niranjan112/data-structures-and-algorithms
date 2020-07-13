package mst;

import node.WeightedNodeForDisjointSet;

public class UndirectedEdge {
  private WeightedNodeForDisjointSet firstNode;
  private WeightedNodeForDisjointSet secondNode;
  private int weight;

  public UndirectedEdge(WeightedNodeForDisjointSet firstNode, WeightedNodeForDisjointSet secondNode, int weight) {
    this.firstNode = firstNode;
    this.secondNode = secondNode;
    this.weight = weight;
  }

  public WeightedNodeForDisjointSet getFirst() {
    return firstNode;
  }
  public void setFirst(WeightedNodeForDisjointSet firstNode) {
    this.firstNode = firstNode;
  }
  public WeightedNodeForDisjointSet getSecond() {
    return secondNode;
  }
  public void setSecond(WeightedNodeForDisjointSet secondNode) {
    this.secondNode = secondNode;
  }
  public int getWeight() {
    return weight;
  }
  public void setWeight(int weight) {
    this.weight = weight;
  }

  @Override
  public String toString() {
    return "Edge (" + firstNode + "," + secondNode + "), weight = " + weight;
  }
}