package take_u_forward.f_array_problems.b_medium.m;

import java.util.HashMap;
import java.util.Map;

public class M_SubArraySumEqualsK {

  public static void main(String[] args) {
    /*
     *
     * 560. Subarray Sum Equals K
     * Problem Link: https://leetcode.com/problems/subarray-sum-equals-k/description/
     *
     * For detailed explanation check TUF
     * */

    int[] arr = {1, 1, 1};

    bruteForceApproach(arr, 2); // TC: O(n^2) and SC: O(1)
    optimalApproach(arr, 2); // TC: O(n) and SC: O(n)
    optimalApproach2(arr, 2); // TC: O(n) and SC: O(1)
  }

  public static void bruteForceApproach(int[] arr, int k) {
    int subArrayCount = 0;
    int sum = 0;

    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length; j++) {
        sum += arr[j];

        if(sum == k) {
          subArrayCount++;
        }
      }

      sum = 0;
    }

    System.out.println("Sub Array count: " + subArrayCount);
  }

  public static void optimalApproach(int[] arr, int k) {
    // Note: For visual explanation check

    /*
    * Hashmap to store prefix sum and it's count.
    * k -> prefix sum till now
    * v -> count of prefix sum
    * */
    Map<Integer, Integer> hashMap = new HashMap<>();

    int prefixSum = 0; // To store prefix sum calculate till now
    int subArrayCount = 0; // To store count of sub array

    hashMap.put(prefixSum, 1); // Initially put 0 -> 1 for same number as k in arr.

    for (int num: arr) {
      prefixSum += num;

      // If prefixSum till now - k is available in HashMap then increment by its count.
      if(hashMap.containsKey(prefixSum - k)) {
        int count = hashMap.get(prefixSum - k);
        subArrayCount += count;
      }

      // If prefixSum is already in HashMap then increment its count
      // Else add the prefixSum as count 1 as it occurred first time.
      if(hashMap.containsKey(prefixSum)) {
        int count = hashMap.get(prefixSum);
        hashMap.put(prefixSum, ++count);
      } else {
        hashMap.put(prefixSum, 1);
      }
    }

    System.out.println("Sub Array count: " + subArrayCount);
  }

  public static void optimalApproach2(int[] nums, int k) {
    // Note: This solution will only work if all numbers in array are positive
    int i = 0; // Left Pointer
    int j = 0; // Right Pointer

    int sum = 0;
    int subArrayCount = 0;

    while (j < nums.length) {
      sum += nums[j]; // expand the window

      // if sum exceeds k then shrink the window from left until sum is less than k
      while (sum > k && i <= j) {
        sum -= nums[i];
        i++;
      }

      // if sum == k, count it
      if (sum == k) {
        subArrayCount++;
      }

      j++; // move right end
    }

    System.out.println("Sub Array count: " + subArrayCount);
  }
}
