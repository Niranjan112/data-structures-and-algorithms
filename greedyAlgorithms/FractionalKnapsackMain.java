package greedyAlgorithms;

import java.util.ArrayList;

public class FractionalKnapsackMain {
  public static void main(String[] args) {
    int [] value = {6,2,1,8,3,5};
    int [] weight = {6,10,3,5,1,3};
    int capacity = 10;
    ArrayList<FractionalKnapsackItem> items = new ArrayList<>();

    for(int i = 0; i < value.length;i++) {
      items.add(new FractionalKnapsackItem(i + 1, value[i], weight[i]));
    }
    
    FractionalKnapsack.fractionalKnapsack(items, capacity);
  }
}