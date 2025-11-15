package take_u_forward.f_array_problems.c_hard.h;

import java.util.Arrays;

public class H_MergeTwoSortedArr {

  public static void main(String[] args) {
    /*
     *
     * 88. Merge Sorted Array
     * Problem Link: https://leetcode.com/problems/merge-sorted-array/description/
     *
     * */


    int m = 3;
    int n = 3;
    bruteForceApproach(new int[] {1, 2, 3, 0, 0, 0}, m, new int[] {2, 5, 6}, n); // TC: O((n) + log(m+n)) & SC: O(1)
    optimalApproach(new int[] {1, 2, 3, 0, 0, 0}, m, new int[] {2, 5, 6}, n); // TC: O(n + m) & SC: O(1)
  }

  public static void bruteForceApproach(int[] arr1, int m, int[] arr2, int n) {

    // Copy arr2 element from m index to arr 1.
    int j = 0;
    for (int i = m; i < arr1.length; i++) {
      arr1[i] = arr2[j];
      j++;
    }

    Arrays.sort(arr1); // Sort arr1 then
    System.out.println("Sorted merge arr: " + Arrays.toString(arr1));

  }

  public static void optimalApproach(int[] arr1, int m, int[] arr2, int n) {
    // Note: For visual explanation, check merge_two_sorted_optimal.jpg

    int i = m - 1; // last element in nums1
    int j = n - 1; // last element in nums2
    int k = m + n - 1; // last index of nums1 from where we put arr2 element or arr1 element itself

    while (i >= 0 && j >= 0) {
      if(arr1[i] > arr2[j]) { // If element in arr1 at i is greater than arr2 at j put it to k position of arr1
        arr1[k] = arr1[i];
        k--;
        i--;
      } else { // Else element in arr2 at j is greater or equal than arr1 at i put it to k position of arr1
        arr1[k] = arr2[j];
        k--;
        j--;
      }
    }

    // Copy any remaining elements from nums2
    while (j >= 0) {
      arr1[k] = arr2[j];
      k--;
      j--;
    }
  }
}
