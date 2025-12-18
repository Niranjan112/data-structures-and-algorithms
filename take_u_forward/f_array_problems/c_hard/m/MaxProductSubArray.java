package take_u_forward.f_array_problems.c_hard.m;

public class MaxProductSubArray {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 0};

    bruteForceApproach(arr); // TC: O(n^2) and SC: O(1)
    optimalApproach(arr); // TC: O(n) and SC: O(1)
  }

  public static void bruteForceApproach(int[] arr) {

    int maxSubArrProduct = Integer.MIN_VALUE;

    for (int i = 0; i < arr.length; i++) {

      int product = 1;

      for (int j = i; j < arr.length; j++) {

        product = product * arr[j];
        maxSubArrProduct = Math.max(maxSubArrProduct, product);
      }
    }

    System.out.println("Max product from sub array: " + maxSubArrProduct);
  }

  public static void optimalApproach(int[] arr) {
    int maxSubArrProduct = Integer.MIN_VALUE;
    int prefixProduct = 1;
    int suffixProduct = 1;

    for (int i = 0; i < arr.length; i++) {

      // If prefixProduct or suffixProduct become 0 because any 0 occurred in arr then reset to 1.
      if(prefixProduct == 0) {
        prefixProduct = 1;
      }
      if(suffixProduct == 0) {
        suffixProduct = 1;
      }

      prefixProduct *= arr[i]; // Starts multiplying from start
      suffixProduct *= arr[arr.length - i - 1]; // Starts multiplying from last

      maxSubArrProduct = Math.max(maxSubArrProduct, Math.max(prefixProduct, suffixProduct)); // Get max sub array product every time
    }

    System.out.println("Max product from sub array: " + maxSubArrProduct);
  }
}
