package take_u_forward.g_binary_search.a_one_dimensional_array.i;

public class I_FindMinInRotatedSortedArr {

  public static void main(String[] args) {
    /*
     *
     * 153. Find Minimum in Rotated Sorted Array
     * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
     *
     * For detailed explanation check TUF
     * */

    int[] arr = {4, 5, 6, 7, 0, 1, 2};

    System.out.println("Min: " + binarySearch(arr)); // TC: O(log n) and SC: O(1)

    System.out.println("Min: " + binarySearch(new int[] {})); // TC: O(log n) and SC: O(1)
  }

  public static int binarySearch(int[] arr) {
    // Note: For visual explanation check find_min_in_rotated_sorted_arr.jpg
    int low = 0;
    int high = arr.length - 1;
    int mid;

    int ansMin = Integer.MAX_VALUE;

    while (low <= high) {
      mid = (low + high) / 2;

      // If the array is already sorted and not rotated then simply return first element of arr and break the loop.
      if(arr[low] <= arr[high]) {
        ansMin = Math.min(ansMin, arr[low]);
        break;
      }

      /*
      * If left part is sorted then, take min from it and update to ansMin.
      * And move the pointer to right unsorted part to search for min
      * */
      if(arr[low] <= arr[mid]) {
        ansMin = Math.min(ansMin, arr[low]);
        low = mid + 1;
      } else { // If right part is sorted then, take min from it and update to ansMin. Also move the pointer to left unsorted part to search for min
        ansMin = Math.min(ansMin, arr[mid]);
        high = mid - 1;
      }
    }

    return ansMin;
  }
}
