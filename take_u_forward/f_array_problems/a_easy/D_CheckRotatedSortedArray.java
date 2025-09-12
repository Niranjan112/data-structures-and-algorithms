package take_u_forward.f_array_problems.a_easy;

public class D_CheckRotatedSortedArray {

  public static void main(String[] args) {
    /*
    * Leet Code Problem: 1752. Check if Array Is Sorted and Rotated
    * LeetCode Link: https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
    * Youtube Link: https://www.youtube.com/watch?v=pO3L3zX5DOI
    * */

    int[] arr = {2,4,1,2,4};

    System.out.println(checkIfRotatedSortedOrNormalSortedArray(arr)); // O(n) time complexity and O(1) space complexity
  }

  public static boolean checkIfRotatedSortedOrNormalSortedArray(int[] arr) {
    /*
    * Explanation:
    * If arr[] = {4,5,6,1,2,3}
    * If you observe here, starting from index 0 till index 2. Array is sorted and consider it a right sub array
    * Then starting from index 3 till index end the array is sorted.
    * So we can say array is rotated sorted.
    * Here the split/drop/deviation happened only once.
    *
    * After doing above check, at last we also have to check whether last element is smaller than first element in array.
    * This is because when array is sorted and really rotated,
    * then first element of rightest part of sub array should be greater than all element in the leftest part of sub array.
    * So this is also we will count as a drop.
    *
    * If arr[] = {2,4,1,2,4}
    * In above example, we can see the spilt happened once at index 2.
    * But last element 4 is greater than first element 2, so one more drop will be counted.
    * So it is not a sorted array and also not a rotated sorted array.
    * */


    int countDrops = 0;
    int n = arr.length;

    for (int i = 0; i < n; i++) {
      // Compare with next element in circular manner
      // While doing circular check it will just check, last and first element.
      if (arr[i] > arr[(i + 1) % n]) {
        countDrops++;
      }
      if (countDrops > 1) {
        return false; // More than one drop -> not sorted & rotated
      }
    }

    return true;
  }
}
