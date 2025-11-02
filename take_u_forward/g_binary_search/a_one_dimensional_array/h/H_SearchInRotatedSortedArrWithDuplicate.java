package take_u_forward.g_binary_search.a_one_dimensional_array.h;

public class H_SearchInRotatedSortedArrWithDuplicate {

  public static void main(String[] args) {
    /*
     *
     * 81. Search in Rotated Sorted Array II
     * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
     *
     * For detailed explanation check TUF
     * */

    int[] arr = {2,5,6,0,0,1,2};

    System.out.println("Search: " + binarySearch(arr, 0)); // TC: O(log n) and SC: O(1)
  }

  public static boolean binarySearch(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    int mid;

    while(low <= high) {
      mid = (low + high) / 2;

      if(arr[mid] == target) {
        return true;
      }

      /*
      * If we get same number at arr[low], arr[mid] and arr[high],
      * then we don't know which side is actually sorted and which side to go to search target.
      *
      * So in this situation, increment low by 1 position and decrement high by 1 position.
      * By doing this, we trim array and eliminate this condition by ignoring same number present at low and high.
      * Also, check img.png in same package for array value example.
      *
      * Rest approach will be same as previous problem solution G_SearchInRotatedSortedArr
      * */
      if(arr[low] == arr[mid] && arr[mid] == arr[high]) {
        low++;
        high--;
        continue;
      }

      if (arr[mid] <= arr[high]) { // If arr[mid] <= arr[high], then means the right part is sorted.
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

    return false;
  }
}
