package greedyAlgorithms;

import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

public class FractionalKnapsack {
  static void fractionalKnapsack(ArrayList<FractionalKnapsackItem> items, int capacity) {
    Comparator<FractionalKnapsackItem> comparator = new Comparator<FractionalKnapsackItem>() {
      @Override
      public int compare(FractionalKnapsackItem o1, FractionalKnapsackItem o2) {
        if(o2.getRatio() > o1.getRatio())
          return 1;
        else
          return -1;
      }
    };

    Collections.sort(items, comparator);

    int usedCapacity = 0;
    double totalValue = 0;
    for(FractionalKnapsackItem item: items) {
      if(usedCapacity + item.getWeight() <= capacity) {
        usedCapacity += item.getWeight();
        totalValue += item.getValue();
        System.out.println("Taken " + item);
      } else {
        int usedWeight = capacity - usedCapacity;
        usedCapacity += usedWeight;
        totalValue += item.getRatio() * usedWeight;
        System.out.println("Taken: "+"item index = " + item.getIndex() + ",obtained value = " + item.getRatio() * usedWeight + ",used weight = " + usedWeight + ", ratio = " + item.getRatio() + "]");
      }

      if(usedCapacity == capacity) break;
    }

    System.out.println("\nTotal value obtained: "+ totalValue);
  }
}