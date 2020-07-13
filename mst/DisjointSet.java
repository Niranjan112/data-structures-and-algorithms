package mst;

import java.util.ArrayList;

import node.WeightedNodeForDisjointSet;

public class DisjointSet {
  private ArrayList<WeightedNodeForDisjointSet> nodesOfSet = new ArrayList<>();

  public static void driver(ArrayList<WeightedNodeForDisjointSet> nodeList) {
    makeSet(nodeList);
    for(int i = 0; i < nodeList.size() - 1; i++) {
      WeightedNodeForDisjointSet firstNode = nodeList.get(i);
      WeightedNodeForDisjointSet secondNode = nodeList.get(i + 1);

      System.out.println("Checking if node " + firstNode + " and " + secondNode + " belongs to different set, if yes, will Union them...");

      System.out.println("\nFirst Set name is: " + firstNode);
      firstNode.getSet().printAllNodesOfThisSet();
      System.out.println("\nSecond Set name is: " + secondNode);
      secondNode.getSet().printAllNodesOfThisSet();

      if(!firstNode.getSet().equals(secondNode.getSet())) {
        System.out.println("\nMaking union " + firstNode + " and " + secondNode);
        DisjointSet unionSet = union(firstNode, secondNode);
        unionSet.printAllNodesOfThisSet();
      }
      System.out.println("\n**************************************\n");
    }
  }

  public static void makeSet(ArrayList<WeightedNodeForDisjointSet> nodeList) {
    for(WeightedNodeForDisjointSet node: nodeList) {
      DisjointSet set = new DisjointSet();
      set.nodesOfSet.add(node);
      node.setSet(set);
    }
  }

  public static DisjointSet findSet(WeightedNodeForDisjointSet node) {
    return node.getSet();
  }

  public static DisjointSet union(WeightedNodeForDisjointSet node1, WeightedNodeForDisjointSet node2) {
    if(node1.getSet().equals(node2.getSet())) {
      return null;
    } else {
      DisjointSet set1 = node1.getSet();
      DisjointSet set2 = node2.getSet();

      if(set1.nodesOfSet.size() > set2.nodesOfSet.size()) {
        ArrayList<WeightedNodeForDisjointSet> nodesOfSet2 = set2.nodesOfSet;
        for(WeightedNodeForDisjointSet node: nodesOfSet2) {
          node.setSet(set1);
          set1.nodesOfSet.add(node);
        }
        return set1;
      } else {
        ArrayList<WeightedNodeForDisjointSet> nodesOfSet1 = set1.nodesOfSet;
        for (WeightedNodeForDisjointSet node : nodesOfSet1) {
          node.setSet(set2);
          set2.nodesOfSet.add(node);
        }
        return set2;
      }
    }
  }

  public static DisjointSet getSet(WeightedNodeForDisjointSet node) {
    return node.getSet();
  }

  public void printAllNodesOfThisSet() {
    System.out.println("Printing all nodes of the set: ");
    for(WeightedNodeForDisjointSet node: nodesOfSet) {
      System.out.print(node + "  ");
    }
    System.out.println();
  }
}