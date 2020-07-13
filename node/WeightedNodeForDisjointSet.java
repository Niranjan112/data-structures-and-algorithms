package node;

import mst.DisjointSet;
import java.util.ArrayList;
import java.util.HashMap;

public class WeightedNodeForDisjointSet {
  private String name;
  private DisjointSet set;
  private ArrayList<WeightedNodeForDisjointSet> neighbors = new ArrayList<WeightedNodeForDisjointSet>();
  private int distance;
  private HashMap<WeightedNodeForDisjointSet, Integer> weightMap = new HashMap<>();
  private WeightedNodeForDisjointSet parent;

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

  public ArrayList<WeightedNodeForDisjointSet> getNeighbors() {
    return neighbors;
  }

  public void setNeighbors(ArrayList<WeightedNodeForDisjointSet> neighbors) {
    this.neighbors = neighbors;
  }

  public HashMap<WeightedNodeForDisjointSet, Integer> getWeightMap() {
    return weightMap;
  }

  public void setWeightMap(HashMap<WeightedNodeForDisjointSet, Integer> weightMap) {
    this.weightMap = weightMap;
  }

  public WeightedNodeForDisjointSet getParent() {
    return parent;
  }

  public void setParent(WeightedNodeForDisjointSet parent) {
    this.parent = parent;
  }

  public int getDistance() {
    return distance;
  }

  public void setDistance(int distance) {
    this.distance = distance;
  }

  @Override
  public String toString() {
    return name;
  }
}