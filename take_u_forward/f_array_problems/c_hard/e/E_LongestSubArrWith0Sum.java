package take_u_forward.f_array_problems.c_hard.e;

import java.util.HashMap;
import java.util.Map;

public class E_LongestSubArrWith0Sum {
  public static void main(String[] args) {
    /*
     *
     * Length of the longest subarray with zero Sum
     * Problem Link: https://takeuforward.org/data-structure/length-of-the-longest-subarray-with-zero-sum/
     * GOG Problem Link: https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
     *
     * For detailed explanation check TUF
     * */

    int[] arr = {9, -3, 3, -1, 6, -5};

    bruteForceApproach(arr); // TC: O(n^3) and SC: O(1)
    optimalApproach(arr); // TC: O(n * log n) and SC: O(n)
  }

  public static void bruteForceApproach(int[] arr) {
    int maxSubArrLen = Integer.MIN_VALUE;

    for (int i = 0; i < arr.length; i++) {
      int sum = 0;
      for (int j = i; j < arr.length; j++) {
        sum += arr[j];
        if(sum == 0) {
          System.out.println("Sum 0 found from index " + i + " to " + j);
          maxSubArrLen = Math.max(maxSubArrLen, (j - i) + 1 );
        }
      }
    }

    System.out.println("Max Sub Array Length with sum 0: " + maxSubArrLen);
  }

  public static void optimalApproach(int[] arr) {
    int maxSubArrLen = Integer.MIN_VALUE;
    int sum = 0;

    Map<Integer, Integer> map = new HashMap<>();

    /*
    * If any sum occurred in previous iteration is x
    * And sum till now is y,
    *
    * So if x is equal y,
    * then we can say previous sum occurred at particular index from that whatever number came to sum till y.
    * Might be resulting 0, so we can say index after x till index at y is sum = 0
    * */
    for (int i = 0; i < arr.length; i++) {
      sum += arr[i];

      if(sum == 0) { // If sum is 0 simply update max sub array length.
        maxSubArrLen = Math.max(maxSubArrLen, i + 1);
      } else {
        if (map.containsKey(sum)) { // If sum is found then get it index and compute sub arr length
          int prefixSumIndex = map.get(sum);
          maxSubArrLen = Math.max(maxSubArrLen, i - prefixSumIndex);
        } else { // When you don't find sum till now in Map then store with its index.
          map.put(sum, i);
        }
      }
    }

    System.out.println("Max Sub Array Length with sum 0: " + maxSubArrLen);
  }
}
