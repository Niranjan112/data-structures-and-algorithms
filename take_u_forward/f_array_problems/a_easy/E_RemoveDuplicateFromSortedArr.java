package take_u_forward.f_array_problems.a_easy;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class E_RemoveDuplicateFromSortedArr {

  public static void main(String[] args) {
    /*
    * LeetCode Problem: 26. Remove Duplicates from Sorted Array
    * LeetCode Problem Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
    *
    * Explanation link: https://takeuforward.org/data-structure/remove-duplicates-in-place-from-sorted-array/
    * */

    int[] arr1 = {0,0,1,1,1,2,2,3,3,4};
    int[] arr2 = {0,0,1,1,1,2,2,3,3,4};

    System.out.println("Total duplicates: " + bruteForceApproach(arr1)); // O(n + n) time complexity and O(n) space complexity
    System.out.println("Total duplicates: " + optimalApproach(arr2)); // O(n) time complexity and O(1) space complexity
  }

  public static int bruteForceApproach(int[] arr) {
    Set<Integer> numSet = new LinkedHashSet<>(); // Using LinkedHashSet to maintain the order of elements

    for (int num: arr) {
      numSet.add(num);
    }

    int i = 0;
    for (int num: numSet) {
      arr[i] = num;
      i++;
    }

    System.out.println("Array after removing duplicates: " + Arrays.toString(arr));

    return numSet.size();
  }

  public static int optimalApproach(int[] arr) {
    int i = 0;

    /*
    * Keep forwarding j until we find a different element than arr[i].
    * Once we find that different element, we increment i and copy the element at j to i.
    * This way, all unique elements are moved to the front of the array.
    * */
    for (int j = 1; j < arr.length; j++) {
      if(arr[i] != arr[j]) {
        i++;
        arr[i] = arr[j];
      }
    }

    System.out.println("Array after removing duplicates: " + Arrays.toString(arr));

    return i+1;
  }
}
