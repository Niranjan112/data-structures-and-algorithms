package greedyAlgorithms;

// Naive Solution for minimum product for subset of an array - O(2^n)

public class MinimumProductSubsetNaive {
  public static void main(String[] args) {
    int arr[] = { -1, -1, -2, 4, 3 };
    int minProduct = Integer.MAX_VALUE;

    for (int i = 0; i < (1 << arr.length); i++) {
      int product = 1;
      for (int j = 0; j < arr.length; j++) {

        if( (i & (1 << j)) > 0 ) {
          product *= arr[j];
        }
      }

      if(product < minProduct && i != 0) {
        minProduct = product;
      }
    }

    System.out.println("Minimum product: " + minProduct);
  }
}