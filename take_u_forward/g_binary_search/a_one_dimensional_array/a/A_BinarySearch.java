package take_u_forward.g_binary_search.a_one_dimensional_array.a;

public class A_BinarySearch {

  public static void main(String[] args) {
    /*
     *
     * 704. Binary Search
     * Problem Link: https://leetcode.com/problems/binary-search/description/
     *
     * For detailed explanation check TUF
     * */

    int[] arr = {3, 4, 6, 7, 9, 12, 16, 17};

    System.out.println("[Iterative] Binary search: " + iterativeApproach(arr, 6)); // TC: O(log n) base is 2 and SC: O(1)

    System.out.println("[Recursive] Binary search: " + recursiveApproach(arr, 6, 0, arr.length - 1)); // TC: O(log n) and SC: O(1)

    //Note: For time complexity explanation check TC_exp.png
    //Note: For overflow explanation check binary_search_overflow_exp.jpg
  }

  public static int iterativeApproach(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;

    while (low <= high) {
      int mid = (low + high) / 2;

      if(arr[mid] == target) {
        return mid;
      } else if (target > arr[mid]) {
        low = mid + 1;
      } else { // target < arr[mid]
        high = mid - 1;
      }
    }

    return -1;

  }

  public static int recursiveApproach(int[] arr, int target, int low, int high) {
    if(low > high) {
      return -1;
    }

    int mid = (low + high) / 2;

    if(arr[mid] == target) {
      return mid;
    } else if (target > arr[mid]) {
      return recursiveApproach(arr, target, mid + 1, high);
    } else { // target < arr[mid]
      return recursiveApproach(arr, target, low, mid - 1);
    }
  }

}
