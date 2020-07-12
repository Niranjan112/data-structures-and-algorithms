package mst;

import java.util.ArrayList;

import node.WeightedNodeForDisjointSet;

public class DisjointMain {
  public static void main(String[] args) {
    ArrayList<WeightedNodeForDisjointSet> nodeList = new ArrayList<WeightedNodeForDisjointSet>();

    for (int i = 0; i < 10; i++) {
      nodeList.add(new WeightedNodeForDisjointSet("" + (char) (65 + i)));
    }

    DisjointSet.driver(nodeList);
  }
}