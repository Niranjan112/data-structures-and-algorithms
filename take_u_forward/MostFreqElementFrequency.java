package take_u_forward;

import java.util.Arrays;

public class MostFreqElementFrequency {

  public static void main(String[] args) {
    /*
    * LeetCode Question: 1838. Frequency of the Most Frequent Element
    * Problem link: https://leetcode.com/problems/frequency-of-the-most-frequent-element/description/
    * */

    int[] nums = {1,4,8,13};
    int k = 5;

    System.out.println(maxFrequency(nums, k));
  }

  public static int maxFrequency(int[] nums, int k) {
    // Sort the array to make it easier to find the max frequency of an element.
    Arrays.sort(nums);

    int result = 1; // Result of max frequency of an element.
    int start = 0; // Start pointer of the window.
    int end = 0; // End pointer of the window.

    long currentWindowSum = 0; // Current sum of all nums in the window.

    while(end < nums.length) {
      currentWindowSum += nums[end]; // Add the current num to the current sum.
      end++; // Move the end pointer to the right to include the next element in the window.

      int lastNumElementOfWindow = nums[end - 1]; // Get last element of the current window.
      int currentWindowSize = end - start; // Get the current window size.

      // Store sum If all numbers in the current window are same as last element of the window.
      long sumOfAllNumbersSameInWindow = (long) currentWindowSize * lastNumElementOfWindow;

      /*
      * Compare if the sumOfAllNumbersSameInWindow is greater than actual current sum + k (k is the number of increments we can do),
      * then we need to shrink the window from the start and remove the num from currentSum.
      * This is because we cannot make all elements in the current window equal to the last element which will give us the max frequency
      * with the given k increments.
      * */
      if( sumOfAllNumbersSameInWindow > currentWindowSum + k) {
        currentWindowSum -= nums[start];
        start++;
      }

      // Calculate the current window size again after possible shrinking.
      currentWindowSize = end - start;

      // Update the result if the current window size is greater than the previous result.
      result = Math.max(result, currentWindowSize);
    }

    return result;
  }

}
