package greedyAlgorithms;

import java.util.*;
public class CoinChangeProblem {
  public static void main(String args[]) {
    int arr[] = {1, 2, 5, 10, 50, 100, 500,2000};
    
    int amount = 2758;
    int index = arr.length - 1;
    Arrays.sort(arr);
    while(amount != 0) {
      if(arr[index] <= amount) {
        System.out.println("Demonetisation taken: " + arr[index]);
        amount -= arr[index];
      } else {
        index--;
      }
    }
  }
}