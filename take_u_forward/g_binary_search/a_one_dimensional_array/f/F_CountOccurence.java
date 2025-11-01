package take_u_forward.g_binary_search.a_one_dimensional_array.f;

public class F_CountOccurence {

  public static void main(String[] args) {
    /*
     *
     * Count Occurrences in Sorted Array
     * Problem Link: https://takeuforward.org/data-structure/count-occurrences-in-sorted-array/
     *
     * For detailed explanation check TUF
     * */

    int[] arr = {2, 2 , 3 , 3 , 3 , 3 , 4};

    System.out.println("Count: " + linearSearch(arr, 3)); // TC: O(n) and SC: O(1)
    System.out.println("Count: " + binarySearch(arr, 3)); // TC: O(2 * log n) and SC: O(1)
  }

  public static int linearSearch(int[] arr, int target) {
    int count = 0;
    for (int num: arr) {
      if(num == target) {
        count++;
      }
    }

    return count;
  }

  public static int binarySearch(int[] arr, int target) {
    int firstOccurenceIndex = getFirstOccurenceIndex(arr, target);
    if(firstOccurenceIndex != -1) {
      int lastOccurenceIndex = getLastOccurenceIndex(arr, target);

      return lastOccurenceIndex - firstOccurenceIndex + 1;
    }

    return 0;
  }

  private static int getFirstOccurenceIndex(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    int mid;

    int firstOccurenceIndex = -1;

    while (low <= high) {
      mid = (low + high) / 2;

      // Whenever we get arr[mid] = target keep updating the firstOccurenceIndex
      if(arr[mid] == target) {
        firstOccurenceIndex = mid;
        high = mid - 1; // Go to left to get first occurrence index
      } else if(target > arr[mid]) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return firstOccurenceIndex;
  }

  private static int getLastOccurenceIndex(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    int mid;

    int lastOccurenceIndex = -1;

    while (low <= high) {
      mid = (low + high) / 2;

      // Whenever we get arr[mid] = target keep updating the lastOccurenceIndex
      if(arr[mid] == target) {
        lastOccurenceIndex = mid;
        low = mid + 1; // Go to right to get last occurrence index
      } else if(target > arr[mid]) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return lastOccurenceIndex;
  }
}
