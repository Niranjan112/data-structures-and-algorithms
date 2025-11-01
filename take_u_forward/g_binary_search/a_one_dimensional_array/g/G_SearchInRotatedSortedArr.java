package take_u_forward.g_binary_search.a_one_dimensional_array.g;

public class G_SearchInRotatedSortedArr {

  public static void main(String[] args) {
    /*
     *
     * 33. Search in Rotated Sorted Array
     * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
     *
     * For detailed explanation check TUF
     * */

    int[] arr = {4, 5, 6, 7, 0, 1, 2};

    System.out.println("Search in rotated sorted array: " + binarySearch(arr, 0)); // TC: O(log n) and SC: O(1)
  }

  public static int binarySearch(int[] arr, int target) {
    // Note for visual explanation check binary_search_rotated_sorted_arr_1.jpg and binary_search_rotated_sorted_arr_2.jpg
    int low = 0;
    int high = arr.length - 1;
    int mid;

    while(low <= high) {
      mid = (low + high) / 2;

      if(arr[mid] == target) {
        return mid;
      } else if (arr[mid] <= arr[high]) { // If arr[mid] <= arr[high], then means the right part is sorted.
        // As right part is sorted check whether target number lies between right part.
        if(arr[mid] <= target && target <= arr[high])
        {
          low = mid + 1;
        } else { // Else target number not lies between right part then simply search on left part.
          high = mid - 1;
        }
        
      } else { // If arr[low] <= arr[mid], then means the left part is sorted.
        // As left part is sorted check whether target number lies between left part.
        if(arr[low] <= target && target <= arr[mid])
        {
          high = mid - 1;
        } else { // Else target number not lies between left part then simply search on right part.
          low = mid + 1;
        }
      }

      // Note: In rotated sorted array, either left part or right part one of them will always be sorted.
    }

    return -1;
  }
}
