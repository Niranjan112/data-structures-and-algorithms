package take_u_forward.g_binary_search.a_one_dimensional_array.j;

public class J_FindRotationCount {

  public static void main(String[] args) {
    /*
     *
     * Find out how many times the array has been rotated
     * https://takeuforward.org/arrays/find-out-how-many-times-the-array-has-been-rotated/
     *
     * For detailed explanation check TUF
     * */

    int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};

    System.out.println("Number of rotation: " + linear(arr)); // TC: O(n) and SC: O(1)
    System.out.println("Number of rotation: " + binarySearch(arr)); // TC: O(log n) and SC: O(1)

  }

  public static int linear(int[] arr) {
    /*
    * The index where min number is present is the count of number of rotation happened in sorted array.
    * min number index = rotation count.
    * */
    int index = 0;
    for (int i = 0; i < arr.length - 1; i++) {
      // As the array is sorted and then rotated we will find for current num which is greater than next num.
      // Because next num is where the sorted flow will break, and it is the min number in array.
      if(arr[i] > arr[i+1]) {
        index = i + 1;
      }
    }

    return index;
  }

  public static int binarySearch(int[] arr) {
    /*
    * Same solution as previous in I_FindMinInRotatedSortedArr.
    * Just Math.min is changed to if block so that we get index as well of min number in arr.
    * */

    int low = 0;
    int high = arr.length - 1;
    int mid;

    int ansMin = Integer.MAX_VALUE;
    int ansMinIndex = 0;

    while (low <= high) {
      mid = (low + high) / 2;

      // If the array is already sorted and not rotated then simply return first element of arr and break the loop.
      if(arr[low] <= arr[high]) {
        if(arr[low] < ansMin) {
          ansMin = arr[low];
          ansMinIndex = low;
        }
        break;
      }

      /*
       * If left part is sorted then, take min from it and update to ansMin.
       * And move the pointer to right unsorted part to search for min
       * */
      if(arr[low] <= arr[mid]) {
        if(arr[low] < ansMin) {
          ansMin = arr[low];
          ansMinIndex = low;
        }
        low = mid + 1;
      } else { // If right part is sorted then, take min from it and update to ansMin. Also move the pointer to left unsorted part to search for min
        if(arr[mid] < ansMin) {
          ansMin = arr[mid];
          ansMinIndex = mid;
        }
        high = mid - 1;
      }
    }

    return ansMinIndex;
  }
}
