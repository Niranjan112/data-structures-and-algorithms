package take_u_forward.f_array_problems.b_medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class A_TwoSum {

  public static void main(String[] args) {
    /*
    * 1. Two Sum
    * Problem link: https://leetcode.com/problems/two-sum/description/
    *
    * */

    int[] arr = {2,7,11,15};

    bruteForceApproach(arr, 13); // O(n^2) time complexity and O(1) space complexity
    betterApproach(arr, 13); // O(N*logN) time complexity and O(N) space complexity

    System.out.println("Is Two Sum exists: " + optimalApproach(arr, 13)); // O(N) + O(N*logN) time complexity and O(1) space complexity
  }

  public static void bruteForceApproach(int[] arr, int targetSum) {

    for (int i = 0; i < arr.length; i++) {
      for (int j = i+1; j < arr.length; j++) {

        if((arr[i]+arr[j] == targetSum) ) {
          System.out.println(arr[i] + " + " + arr[j] + " = " + targetSum);
          return;
        }
      }
    }
  }

  public static void betterApproach(int[] arr, int targetSum) {

    // key - array element, value -> index of array element
    Map<Integer, Integer> map = new HashMap<>();

    /*
    * Subtract current number in array with targetSum so you will get the remaining number that you want to achieve targetSum.
    * Check if that remaining number exits in the map.
    * If yes, then you got your two sums numbers.
    * If no, put the current number in Map and just check for other number.
    * */
    for (int i = 0; i < arr.length; i++) {
      int remaining = targetSum - arr[i];

      if(map.containsKey(remaining)) {
        System.out.println(arr[i] + " + " + remaining + " = " + targetSum);
        break;
      }

      map.put(arr[i], i);
    }
  }

  public static boolean optimalApproach(int[] arr, int targetSum) {
    // Note: This approach will only work if you just want to check whether two sum exists or not that's it.

    Arrays.sort(arr); // Sort the array first.

    int leftIndex = 0, rightIndex = arr.length - 1;

    int sum;

    /*
    * As the array is sorted now,
    * Put one pointer at start of array and one pointer at last of array.
    *
    * If arr[leftIndex] + arr[rightIndex] =  targetSum (We found it, and it's exists)
    *
    * If arr[leftIndex] + arr[rightIndex] >  targetSum then move right pointer to left side by rightIndex-- (the calc sum should reduce then)
    * Else if it smaller than move left pointer to right side by leftIndex++ (the calc sum should increase then)
    * */
    while (leftIndex < rightIndex) {
      sum = arr[leftIndex] + arr[rightIndex];

      if(sum == targetSum) {
        return true;
      }

      if(sum > targetSum) {
        rightIndex--;
      } else {
        leftIndex++;
      }
    }

    return false;
  }
}
