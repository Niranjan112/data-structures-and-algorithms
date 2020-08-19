package greedyAlgorithms;

// Enhanced Solution for minimum product for subset of an array - O(n)

public class MaximumProductSubset {
  static int maxProductSubset(int arr[]) {
    if(arr.length == 1) {
      return arr[0];
    }
    int negativeMax = Integer.MAX_VALUE;
    int countZero = 0, countNegative = 0, product = 1;

    for (int i = 0; i < arr.length; i++) {

      if(arr[i] == 0) {
        countZero++;
        continue;
      }

      if(arr[i] < 0) {
        countNegative++;
        negativeMax = Math.max(negativeMax, arr[i]);
      }

      product *= arr[i];
    }

    if(countZero == arr.length) {
      return 0;
    }

    if(countNegative % 2 == 1) {

      if(countNegative == 1 && countZero > 0 && countNegative + countZero == arr.length) {
        return 0;
      }

      product = product / negativeMax;
    }

    return product;
  }

  public static void main(String[] args) {
    int arr[] = { 1, 1, 2, 4, 3, 0 };

    System.out.println(maxProductSubset(arr));
  }
}