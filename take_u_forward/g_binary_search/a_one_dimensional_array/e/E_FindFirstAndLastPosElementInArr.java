package take_u_forward.g_binary_search.a_one_dimensional_array.e;

import java.util.Arrays;

public class E_FindFirstAndLastPosElementInArr {

  public static void main(String[] args) {
    /*
     *
     * 34. Find First and Last Position of Element in Sorted Array
     * Problem Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
     *
     * For detailed explanation check TUF
     * */

    int[] arr = {5, 7, 7, 8, 8, 10};

    System.out.println("First and Last Index: " + Arrays.toString(linearSearch(arr, 8))); // TC: O(n) and SC: O(1)
    System.out.println("First and Last Index: " + Arrays.toString(binarySearch(arr, 8))); // TC: O(log n + n) and SC: O(1)
    System.out.println("Last Index: " + binarySearchToGetLastOccurence(arr, 8)); // TC: O(2 * log n) if we get first and last occurrence both and SC: O(1)

  }

  public static int[] linearSearch(int[] arr, int target) {
    int firstOccurenceIndex = -1;

    // Search at what index first occurrence is present.
    for (int i = 0; i < arr.length; i++) {
      if(arr[i] == target) {
        firstOccurenceIndex = i;
        break;
      }
    }

    // If first occurrence index is there then we will search lastOccurenceIndex starting from firstOccurenceIndex
    if(firstOccurenceIndex != -1) {
      int lastOccurenceIndex = firstOccurenceIndex;

      for (int i = firstOccurenceIndex; i < arr.length; i++) {
        // Keep updating lastOccurenceIndex whenever current number is equal to target.
        if(arr[i] == target) {
          lastOccurenceIndex = i;
        } else { // Stop if we found that there are no more numbers equal to target in arr.
          break;
        }
      }

      return new int[] {firstOccurenceIndex, lastOccurenceIndex};
    } else {
      return new int[] {-1, -1};
    }
  }

  public static int[] binarySearch(int[] arr, int target) {
    // Note: For visual explanation check first_and_last_occurence_optimal_binary_search.jpg
    int low = 0;
    int high = arr.length - 1;
    int mid = -1;

    int firstOccurenceIndex = -1;
    int lastOccurenceIndex = -1;

    // Binary search until we get arr[mid] == target
    while (low <= high) {
      mid = (low + high) / 2;

      if(arr[mid] == target) {
        break;
      } else if(target > arr[mid]) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    // If we found target at arr[mid],
    // Then go to left and also go to right of arr from obtained mid-index above to check for first occurrence and last occurrence index.
    if (mid != -1) {
      // Start from obtained mid-index and keep going left until we're getting target num else if we found different then break.
      for (int i = mid; i >= 0; i--) {
        if(arr[i] == target) {
          firstOccurenceIndex = i; // keep updating firstOccurenceIndex until we are getting target num in arr[i]
        } else {
          break;
        }
      }

      // Start from obtained mid-index and keep going right until we're getting target num else if we found different then break.
      for (int i = mid; i < arr.length; i++) {
        if(arr[i] == target) {
          lastOccurenceIndex = i; // keep updating lastOccurenceIndex until we are getting target num in arr[i]
        } else {
          break;
        }
      }

      return new int[] {firstOccurenceIndex, lastOccurenceIndex};
    } else { // If we not found any occurrence of target num then return -1, -1
      return new int[] {-1, -1};
    }
  }

  public static int binarySearchToGetLastOccurence(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    int mid;

    int lastOccurenceIndex = -1;

    while (low <= high) {
      mid = (low + high) / 2;

      // Whenever we get arr[mid] = target keep updating the lastOccurenceIndex
      if(arr[mid] == target) {
        lastOccurenceIndex = mid;
        low = mid + 1; // Change to high = mid - 1 so that pointer goes to left side if you want first occurence index.
      } else if(target > arr[mid]) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return lastOccurenceIndex;
  }

}
