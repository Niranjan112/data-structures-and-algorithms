package take_u_forward.f_array_problems.b_medium.b;

import java.util.Arrays;

public class B_SortAnArrOfZeroOneAndTwo {

  public static void main(String[] args) {
    /*
    * 75. Sort Colors
    * Problem Link: https://leetcode.com/problems/sort-colors/description/
    *
    * Check TUF for solution explanation.
    * */

    // Note: Brute force approach can be just to simply sort the array.

    betterApproach(new int[] {2,0,2,1,1,0}); // O(N + N) time complexity and O(1) space complexity.
    optimalApproach(new int[] {2,0,2,1,1,0}); // O(N) time complexity and O(1) space complexity.

  }

  public static void betterApproach(int[] arr) {
    // Variable to count frequency of 0,1 and 2
    int countOfZero = 0;
    int countOfOne = 0;
    int countOfTwo = 0;

    // Count 0,1 and 2
    for (int num: arr) {
      if(num == 0) {
        countOfZero++;
      } else if (num == 1) {
        countOfOne++;
      } else {
        countOfTwo++;
      }
    }

    /*
    * Now according to count variables put again the values of 0,1 and 2 into array.
    * */
    int startIndex = 0; // For putting 0 start with 0th index
    int end = countOfZero; // End should be countOfZeros
    for (int i = startIndex; i < end; i++) {
      arr[i] = 0;
    }

    startIndex += countOfZero; // For putting 1, first add countOfZeros to startIndex then start from that index.
    end += countOfOne; // End should be countOfZeros + countOfOnes
    for (int i = countOfZero; i < end; i++) {
      arr[i] = 1;
    }

    startIndex += countOfOne; // For putting 2, add countOfOnes to startIndex then start from that index.
    end += countOfTwo; // End should be countOfZeros + countOfOnes + countOfTwo
    for (int i = startIndex; i < end; i++) {
      arr[i] = 2;
    }

    System.out.println("Array after sort: " + Arrays.toString(arr));
  }

  public static void optimalApproach(int[] arr) {
    int left = 0;
    int mid = 0;
    int right = arr.length - 1;

    /*
    * This algorithm will work in a way that,
    * the numbers before arr[mid] will be always be sorted and the number at and after of arr[mid] can be unsorted.
    *
    * Once mid-index crosses the right-index then it can be a termination condition as we have arranged all num.
    * */
    while(mid <= right) {

      // If arr[mid] == 0, then put it to left side.
      // Also, it is confirmed that the current number at arr[left] will always be 0 so swapping will not be affected.
      // increment left and mid by 1 as we know both are zero.
      if(arr[mid] == 0) {

        int temp = arr[left];
        arr[left] = arr[mid];
        arr[mid] = temp;

        left++;
        mid++;

      } else if(arr[mid] == 1) { // If arr[mid] == 1, then we know this is what we want so just move mid by 1.

        mid++;

      } else if(arr[mid] == 2) {

        // If arr[mid] == 2, then put it on the right side.
        // We know the part after right is 2 only.
        // So we do decrement right by 1 to sort the remaining part between mid and right in coming iteration
        int temp = arr[mid];
        arr[mid] = arr[right];
        arr[right] = temp;

        right--;

      }
    }

    // Note: This algorithm is also known as the Dutch flag algorithm.

    System.out.println("Array after sort: " + Arrays.toString(arr));
  }
}
