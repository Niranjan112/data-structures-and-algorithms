package greedyAlgorithms;

// Enhanced Solution for minimum product for subset of an array - O(n)

public class MinimumProductSubset {

  static int minProductSubset(int arr[]) {
    int negativeMax = Integer.MIN_VALUE;
    int positiveMinValue = Integer.MAX_VALUE;
    int countNegative = 0, countZero = 0, product = 1;

    for (int i = 0; i < arr.length; i++) {

      if( arr[i] == 0 ) {
        countZero++;
        continue;
      }

      if( arr[i] < 0 ) {
        countNegative++;
        negativeMax = Math.max(arr[i], negativeMax);
      }

      if( arr[i] > 0 && arr[i] < positiveMinValue) {
        positiveMinValue = arr[i];
      }

      product *= arr[i];
    }

    if( (countNegative == 0 && countZero > 0) || countZero == arr.length) {
      return 0;
    }

    if(countNegative == 0) {
      return positiveMinValue;
    }

    if(countNegative % 2 == 0 && countNegative != 0) {
      product =  product / negativeMax;
    }

    return product;
  }
  public static void main(String[] args) {
    int arr[] = { 9, 10, 2, 4, 3, -9, -3 };

    System.out.println("Minimum product: " + minProductSubset(arr));
  }
}