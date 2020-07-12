package node;

import mst.DisjointSet;

public class WeightedNodeForDisjointSet {
  private String name;
  private DisjointSet set;

    public WeightedNodeForDisjointSet(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public DisjointSet getSet() {
      return set;
    }

    public void setSet(DisjointSet set) {
      this.set = set;
    }

    @Override
    public String toString() {
        return name;
    }
}