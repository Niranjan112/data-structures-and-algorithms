package take_u_forward.g_binary_search.a_one_dimensional_array.c;

public class C_SearchInsertPosition {

  public static void main(String[] args) {
    /*
     *
     * 35. Search Insert Position
     * Problem Link: https://leetcode.com/problems/search-insert-position/description/
     *
     * For detailed explanation check TUF
     * */

    int[] arr = {1, 3, 5, 6};

    System.out.println("Insert Position: " + approach(arr, 7)); // TC: O(log n) and SC: O(1)
  }

  public static int approach(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    int mid;

    // If target is greater than last element of arr then we return arr.length because that will be the insert position.
    int ansIndex = arr.length;

    while (low <= high) {
      mid = (low + high) / 2;

      /*
      * If number at mid is greater than target number then go to left side so that we may find another greater number on left side.
      * We want lowest greater number than target which is available in arr.
      * */
      if(arr[mid] >= target) {
        ansIndex = mid; // This index can be an answer so just update ansIndex.
        high = mid - 1;
      } else { // If Number at mid is less than target then let's find lowest greater num than target on right side.
        low = mid + 1;
      }
    }

    return ansIndex;
  }
}
