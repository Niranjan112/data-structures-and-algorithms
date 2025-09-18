package take_u_forward.f_array_problems.a_easy;

import java.util.HashMap;
import java.util.Map;

public class O_LongestSubArrayThatEqualSumKPosAndNeg {

  public static void main(String[] args) {
    /*
     * Longest Subarray with given Sum K(Positives)
     * Problem Link & Explanation: https://takeuforward.org/data-structure/longest-subarray-with-given-sum-k/
     *
     * Note: Here, the array will only contain 0 and positive
     * */

    int[] arr = {2,3,5,1,9};

    bruteForceApproach(arr, 10); // O(n^2) time complexity and O(1) space complexity
    betterApproach(arr, 10); // O(N*logN) time complexity and O(N) space complexity
  }

  public static void bruteForceApproach(int[] arr, int k) {

    int maxSubArrayLength = 0; // Variable to store the length of longest sub array length.
    int sum; // Variable to track sum of each sub array.

    /*
     * Start Outer loop from 0 to N.
     * Inner loop will start from current i position till end of array.
     *
     * In inner loop, will do the job of summing each values of sub array.
     * And also checking at the time after every addition that sum got equals to k or not.
     * And then checking with previous and storing max length if sum got equals to k.
     * */
    for (int i = 0; i < arr.length; i++) {

      sum = 0;
      for (int j = i; j < arr.length; j++) {

        sum += arr[j];

        if(sum == k) {
          maxSubArrayLength = Math.max(maxSubArrayLength, j - i + 1);
        }
      }
    }

    System.out.println("Longest sub array length is " + maxSubArrayLength);
  }

  public static void betterApproach(int[] arr, int k) {
    Map<Integer, Integer> preSum = new HashMap<>(); // Map to store pre sum at every index.

    int maxSubArrayLength = 0; // Variable to store the length of longest sub array length.
    int sum = 0; // Variable to track sum of each sub array.

    /*
     * Traverse array from 0 to N.
     * At every iteration,
     * 1. Calculate the sum till then.
     * 2. Check if sum becomes equals to k.
     *   2.1 If Yes, then check if that sub array is greater than the previous one and update accordingly.
     * 3. Now, whatever the sum is calculated till now, subtract k from it and check whether we got that remaining number in previous in Map.
     *   3.1 If Yes, then get the index of that number and calculate new sub array length and compare with earlier max sub array length.
     * 4. At last check, whatever the sum is calculated till now exists already in Map.
     *   4.1 If not exists, then put the sum as key and current index as value.
     *     This we are doing because if in future 0s comes then those index should be added because it will affect the sub array size.
     *     For example, check TUF explanation link above.
     * */
    for (int i = 0; i < arr.length; i++) {

      sum += arr[i];

      if(sum == k) {
        maxSubArrayLength = Math.max(maxSubArrayLength, i + 1);
      }

      int remaining = sum - k;
      if(preSum.containsKey(remaining)) {
        int calcLen = i - preSum.get(remaining);
        maxSubArrayLength = Math.max(maxSubArrayLength, calcLen);
      }

      if(!preSum.containsKey(sum)) {
        preSum.put(sum, i);
      }
    }

    System.out.println("Longest sub array length is " + maxSubArrayLength);
  }
}
