package take_u_forward.f_array_problems.c_hard.i;

import java.util.Arrays;

public class I_MergeTwoSortedArrTUF {

  public static void main(String[] args) {
    /*
     *
     * Merge Two Sorted Array
     * Problem Link: https://takeuforward.org/data-structure/merge-two-sorted-arrays-without-extra-space/
     *
     * For detailed explanation check TUF
     * */

    bruteForceApproach(new int[] {-5, -2, 4, 5}, new int[] {-3, 1, 8}); // TC: O(n + m) & SC: O(n + m)
    optimalApproach1(new int[] {-5, -2, 4, 5}, new int[] {-3, 1, 8}); // TC: O(min(n + m) + n log n + m log m) and SC: O(1)
    optimalApproach2(new int[] {-5, -2, 4, 5}, new int[] {-3, 1, 8});
  }

  public static void bruteForceApproach(int[] arr1, int[] arr2) {
    // Note: For visual explanation check merge_two_sorted_arr_TUF_brute.jpg

    int i = 0; // arr1 pointer
    int j = 0; // arr2 pointer
    int k = 0; // result pointer

    // Create result array to store all values of arr1 and arr2 in sorted order.
    int[] result = new int[arr1.length + arr2.length];

    while(i < arr1.length && j < arr2.length) { // Keep looping until one of the array pointer is exceeded
      if(arr1[i] > arr2[j]) { // If element in arr1 at i is greater than arr2 element at j then put arr2 element at j to result at k
        result[k] = arr2[j];
        j++;
      } else { // If element in arr1 at i is less than arr2 element at j then put arr1 element at i to result at k
        result[k] = arr1[i];
        i++;
      }
      k++; // increment k after getting value from one of the array.
    }

    while (i < arr1.length) { // If any element left in arr1 then put all to result sequentially
      result[k] = arr1[i];
      i++;
      k++;
    }
    while (j < arr2.length) { // If any element left in arr2 then put all to result sequentially
      result[k] = arr2[j];
      j++;
      k++;
    }

    // From result arr put all element back to arr1 and arr2 in sorted order.
    for (int l = 0; l < arr1.length + arr2.length; l++) {
      if(l < arr1.length) { // Put all element in arr1
        arr1[l] = result[l];
      } else { // Put all element in arr2
        arr2[l - arr1.length] = result[l];
      }
    }

    System.out.println("Final sorted merge arr: " + Arrays.toString(result));
    System.out.println("Arr1: " + Arrays.toString(arr1));
    System.out.println("Arr2: " + Arrays.toString(arr2));
  }

  public static void optimalApproach1(int[] arr1, int[] arr2) {
    // Note: For visual explanation check merge_two_sorted_arr_tuf_optimal_1.jpg

    int i = arr1.length - 1; // Start from last index of arr1
    int j = 0; // Start from first index of arr2

    while (i >= 0 && j < arr2.length) {
      if(arr1[i] > arr2[j]) { // If element at arr1 is greater than arr2 element then swap and move both pointer.
        int temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;

        i--;
        j++;
      } else { // Once we reach condition where element at arr1 is less than arr2 element at j then stop the loop
        break;
      }
    }

    // Now once we have all less numbers in arr1 and greater numbers in arr2. Sort both the array to get final result.
    Arrays.sort(arr1);
    Arrays.sort(arr2);

    System.out.println("Arr1: " + Arrays.toString(arr1));
    System.out.println("Arr2: " + Arrays.toString(arr2));
  }

  public static void optimalApproach2(int[] arr1, int[] arr2) {
    // Note: For visual explanation check merge_two_sorted_arr_tuf_optimal_2.jpg

    int totalLen = arr1.length + arr2.length;
    int gap = Math.ceilDiv(totalLen, 2); // ceil value of totalLen / 2

    while (gap > 0) {
      int left = 0; // Always start left from 0
      int right = left + gap; // Start right from left + new calculated gap value

      while (right < totalLen) {
        if(left < arr1.length && right >= arr1.length) { // left is at arr1 and right is at arr2
          swapIfGreater(arr1, arr2, left, right - arr1.length);
        } else if (left >= arr1.length) { // left is at arr2 and right is at arr2
          swapIfGreater(arr2, arr2, left - arr1.length, right - arr1.length);
        } else { // left is at arr1 and right is at arr1
          swapIfGreater(arr1, arr1, left, right);
        }

        left++;
        right++;
      }

      if(gap == 1) { // Once gap reaches to 1 we can break as both array got sorted now.
        break;
      }

      gap = Math.ceilDiv(gap, 2); // Recalculate the gap value for next iteration
    }

    System.out.println("Arr1: " + Arrays.toString(arr1));
    System.out.println("Arr2: " + Arrays.toString(arr2));
  }

  private static void swapIfGreater(int[] arr1, int[] arr2, int left, int right) {
    if(arr1[left] > arr2[right]) {
      int temp = arr1[left];
      arr1[left] = arr2[right];
      arr2[right] = temp;
    }
  }
}
