package take_u_forward.g_binary_search.a_one_dimensional_array.d;

public class D_FindFloorAndCeil {

  public static void main(String[] args) {
    /*
     *
     * Floor and Ceil in Sorted Array
     * Problem Link: https://takeuforward.org/arrays/floor-and-ceil-in-sorted-array/
     *
     * For detailed explanation check TUF
     * */

    int[] arr = {3, 4, 4, 7, 8, 10};

    System.out.println("Floor: " + findFloor(arr, 5)); // TC: O(log n) and SC: O(1)
    System.out.println("Ceil: " + findFloor(arr, 5)); // TC: O(log n) and SC: O(1)
  }

  public static int findFloor(int[] arr, int target) {
    // Here we have to find immediate lesser number than target number or equal to target number.
    int low = 0;
    int high = arr.length - 1;
    int mid;

    int ansIndex = -1;

    while (low <= high) {
      mid = (low + high) / 2;

      /*
      * If number at mid is less or equal to target then we will find the greatest number on right side which is less or equal to target.
      * */
      if(arr[mid] <= target) {
        ansIndex = mid;
        low = mid + 1;
      } else { // If number at mid is greater than target then we will find another greater number on left side which is less or equal to target.
        high = mid - 1;
      }
    }

    return arr[ansIndex];
  }

  public static int findCeil(int[] arr, int target) {
    // Here we have to find immediate greater number than target number or equal to target number
    int low = 0;
    int high = arr.length - 1;
    int mid;

    int ansIndex = -1;

    while (low <= high) {
      mid = (low + high) / 2;

      // If number at mid is already greater or equal to target then we will find next greater element on left side which just greater than target num.
      if(arr[mid] >= target) {
        ansIndex = mid;
        high = mid - 1;
      } else { // if number at mid is less than target then we will find immediate greater element on right side which is just greater than target num.
        low = mid + 1;
      }
    }

    return arr[ansIndex];
  }
}
