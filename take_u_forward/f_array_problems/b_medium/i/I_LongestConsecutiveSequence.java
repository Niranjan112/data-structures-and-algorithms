package take_u_forward.f_array_problems.b_medium.i;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class I_LongestConsecutiveSequence {

  public static void main(String[] args) {
    /*
     *
     * 128. Longest Consecutive Sequence
     * Problem Link: https://leetcode.com/problems/longest-consecutive-sequence/description/
     *
     * For detailed explanation check TUF
     * */

    int[] arr = {102, 4, 100, 1, 101, 3, 2, 1, 1};

    bruteForceApproach(arr); // O(n^2) time complexity and O(1) space complexity.
    betterApproach(arr); // O(n log n) + O(n) time complexity and O(1) space complexity.
    optimalApproach(arr); // TC: O(N) + O(2*N) ~ O(3*N), where N = size of the array. SC: O(N), as we are using the set data structure to solve this problem.
  }

  public static void bruteForceApproach(int[] arr) {
    int maxConsecutiveSeqCount = 0; // Variable to track max consecutive sequence count

    /*
    * Iterate over each element, check for it's x+1 element if exits in array.
    * If exits, then increase the count then check for x+1 +1 element and so on and keep counting.
    * */
    for (int i = 0; i < arr.length; i++) {

      int nextNumToFind = arr[i] + 1; // Number to find for consecutive x+1
      int count = 1; // Initial count

      /*
      * If the x+1 number is found while doing linear search then look for other x+1 number and keep increasing the count.
      * */
      while (linearSearch(arr, nextNumToFind)) {
        count += 1;
        nextNumToFind += 1;
      }

      // Update maxConsecutiveSeqCount whenever we found greater sequence.
      maxConsecutiveSeqCount = Math.max(maxConsecutiveSeqCount, count);
    }

    System.out.println("Max Consecutive Sequence Number: " + maxConsecutiveSeqCount);
  }

  public static boolean linearSearch(int[] arr, int numToFind) {
    for (int currentNum : arr) {
      if (currentNum == numToFind) {
        return true;
      }
    }

    return false;
  }

  public static void betterApproach(int[] arr) {
    // Note: For visual explanation, check I_max_consecutive_count_better_1.jpg and I_max_consecutive_count_better_2.jpg in same package
    if(arr.length < 1) {
      System.out.println("Max Consecutive Sequence Number: 0");
      return;
    }

    Arrays.sort(arr); // Sort the array.

    int maxConsecutiveSeqCount = 1; // Variable to track max consecutive sequence count
    int lastNum = Integer.MIN_VALUE; // Will keep last visited number here.

    int count = 1; // Initial count
    for (int i = 0; i < arr.length; i++) {

      if(arr[i] - 1 == lastNum) { // If currentNum - 1 == lastNum then it is consecutive, so increment the count.
        count++;
      } else if (arr[i] != lastNum) { // If above statement is not passed, then check if current num and last number is not equal then reset the count to 1 for tracking new consecutive count
        count = 1;
      }

      lastNum = arr[i]; // Set the current num as last visited num that will be used in next iteration.

      maxConsecutiveSeqCount = Math.max(maxConsecutiveSeqCount, count); // Update maxConsecutiveSeqCount whenever we found greater sequence.
    }

    System.out.println("Max Consecutive Sequence Number: " + maxConsecutiveSeqCount);
  }

  public static void optimalApproach(int[] arr) {
    // Note: For visual explanation, check I_max_consecutive_count_optimal.jpg in same package
    if(arr.length < 1) {
      System.out.println("Max Consecutive Sequence Number: 0");
      return;
    }

    Set<Integer> numSet = new HashSet<>();

    // Add all numbers to Set so will have only unique numbers and duplicate will be removed.
    for (int num: arr) {
      numSet.add(num);
    }

    int maxConsecutiveSeqCount = 1; // Variable to track max consecutive sequence count

    /*
    * Iterate over all number in Set
    * If current number - 1 does not exist in the array then it could be first element of a consecutive sequence.
    * So, check for all x+1 number and keep incrementing the count and then after checking for all x+1 num update max consecutive seq count.
    *
    * By this we are ensuring that we will only go to check for consecutive seq when we found the first element of a sequence in Set.
    * */
    for (Integer num: numSet) {

      if(!numSet.contains(num - 1)) {
        int count = 1;
        int nextNumToFind = num + 1;

        while (numSet.contains(nextNumToFind)) {
          count++;
          nextNumToFind += 1;
        }

        maxConsecutiveSeqCount = Math.max(maxConsecutiveSeqCount, count);
      }
    }

    System.out.println("Max Consecutive Sequence Number: " + maxConsecutiveSeqCount);

  }
}
