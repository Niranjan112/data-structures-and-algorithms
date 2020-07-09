package node;

import java.util.ArrayList;
import java.util.HashMap;

public class WeightedNode implements Comparable<WeightedNode> {
    public String name;
    private ArrayList<WeightedNode> neighbors = new ArrayList<WeightedNode>();
    private int distance;
    private HashMap<WeightedNode, Integer> weightMap = new HashMap<>();
    private WeightedNode parent;


    public WeightedNode(String name) {
        this.name = name;
        this.distance = Integer.MAX_VALUE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<WeightedNode> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(ArrayList<WeightedNode> neighbors) {
        this.neighbors = neighbors;
    }

    public HashMap<WeightedNode, Integer> getWeightMap() {
        return weightMap;
    }

    public void setWeightMap(HashMap<WeightedNode, Integer> weightMap) {
        this.weightMap = weightMap;
    }

    public WeightedNode getParent() {
        return parent;
    }

    public void setParent(WeightedNode parent) {
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

    @Override
    public int compareTo(WeightedNode o) {
        return this.distance - o.distance;
    }
}