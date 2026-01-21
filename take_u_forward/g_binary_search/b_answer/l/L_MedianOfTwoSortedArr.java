package take_u_forward.g_binary_search.b_answer.l;

import java.util.Arrays;

public class L_MedianOfTwoSortedArr {

  public static void main(String[] args) {
    int[] arr1 = {1,2};
    int[] arr2 = {3,4};

    System.out.println("Median of two sorted arr: " + bruteForceApproach(arr1, arr2));
    System.out.println("Median of two sorted arr: " + betterApproach(arr1, arr2));
    System.out.println("Median of two sorted arr: " + optimalApproach(arr1, arr2));
  }

  public static double bruteForceApproach(int[] arr1, int[] arr2) {
    int[] mergedArr = new int[arr1.length + arr2.length];

    int i = 0;
    int j = 0;
    int k = 0;
    // Iterate until one of the array is traverse fully
    while (i < arr1.length && j < arr2.length) {
      if(arr1[i] < arr2[j]) { // If num in arr1 is small then put it to merged arr
        mergedArr[k] = arr1[i];
        i++;
        k++;
      } else { // If num in arr2 is small then put it to merged arr
        mergedArr[k] = arr2[j];
        k++;
        j++;
      }
    }

    // If any number is pending in arr1 then put it all to merged arr
    while (i < arr1.length) {
      mergedArr[k] = arr1[i];
      k++;
      i++;
    }

    // If any number is pending in arr2 then put it all to merged arr
    while (j < arr2.length) {
      mergedArr[k] = arr2[j];
      k++;
      j++;
    }

    int medianIndex = mergedArr.length / 2; // Get mid index of merged arr.
    if(mergedArr.length % 2 == 0) {
      // In order to get the median of even length mergedArr use mid-index, and it's immediate before index to compute
      return (double) (mergedArr[medianIndex] + mergedArr[medianIndex - 1]) / 2;
    } else {
      // In case of odd length mergedArr simply return the mid-index.
      return (double) mergedArr[medianIndex];
    }
  }

  public static double betterApproach(int[] arr1, int[] arr2) {
    int totalLengthOfMergedArr = arr1.length + arr2.length;

    boolean isEvenLength = totalLengthOfMergedArr % 2 == 0;
    int iterateCount = (totalLengthOfMergedArr / 2) + 1; // Total number of iterate will do to take num from both sorted arr
    int i = 0;
    int j = 0;
    int k = 0;

    int lastNum = -1; // Will store the last num we took from arr
    int secondLastNum = -1; // Will store the second last num we took from arr

    while (k < iterateCount) {

      if (i < arr1.length && j < arr2.length) { // Always check that i and j should be below their array length
        if (arr1[i] < arr2[j]) {
          secondLastNum = lastNum;
          lastNum = arr1[i++];
        } else {
          secondLastNum = lastNum;
          lastNum = arr2[j++];
        }
      }
      else if (i < arr1.length) { // If we iterated all element from arr2 and still some number are required from arr1 then keep taking it until iterateCount over
        secondLastNum = lastNum;
        lastNum = arr1[i++];
      }
      else { // If we iterated all element from arr1 and still some number are required from arr2 then keep taking it until iterateCount is over
        secondLastNum = lastNum;
        lastNum = arr2[j++];
      }

      k++;
    }

    if(isEvenLength) { // If total length is even considered last Num and second last num for median
      return (double) (secondLastNum + lastNum) / 2;
    } else { // If total length is odd considered last num for median
      return lastNum;
    }
  }

  public static double optimalApproach(int[] arr1, int[] arr2) {
    int arr1Len = arr1.length;
    int arr2Len = arr2.length;

    // If arr2 is smaller in length than arr1 then just putting arr2 to arr1. As we have to do binary search on smaller array.
    // In simple words, just trying to find out smaller array and using it for binary search.
    if(arr1Len > arr2Len) {
      return optimalApproach(arr2, arr1);
    }

    // The left halve length of a merged arr length. Considering for even and odd both case.
    int leftHalveLenOfArr = (arr1Len + arr2Len + 1) / 2;

    // Evaluate if merged arr len is even or odd.
    boolean isEvenLen = (arr1Len + arr2Len) % 2 == 0;

    int low = 0;
    int high = arr1Len;

    while (low <= high) {
      int mid1 = (low + high) / 2; // Mid index for arr1
      int mid2 = leftHalveLenOfArr - mid1; // Mid index for arr2

      // l1 and l2 should always be less than r2 and r1 respectively. So will consider min value for l1 and l2 if mid1 - 1 or mid2 - 1 goes below 0 index.
      int l1 = Integer.MIN_VALUE; int l2 = Integer.MIN_VALUE;
      // r1 and r2 should be more than l2 and l1 respectively. So will consider max value for r1 and r2 if mid1 or mid2 goes out of arr index.
      int r1 = Integer.MAX_VALUE; int r2 = Integer.MAX_VALUE;

      if(mid1 < arr1Len) r1 = arr1[mid1]; // If mid1 is in under arr1Len index then assign arr1 mid1 value to r1;
      if(mid2 < arr2Len) r2 = arr2[mid2]; // If mid2 is in under arr2Len index then assign arr2 mid2 value to r2;

      if(mid1 - 1 >= 0) l1 = arr1[mid1 - 1]; // If mid1 - 1 is not getting below 0 then assign arr1 mid1 - 1 value to l1
      if(mid2 - 1 >= 0) l2 = arr2[mid2 - 1]; // If mid2 - 1 is not getting below 0 then assign arr2 mid2 - 1 value to l2

      if(l1 <= r2 && l2 <= r1) { // If left have max values are less than right halve min value then we got our perfect partition

        if(isEvenLen) {
          return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
        } else {
          return Math.max(l1, l2);
        }

      } else if(l1 > r2) { // Go to left side in arr1
        high = mid1 - 1;
      } else { // If l2 > r1 then go to right side in arr1
        low = mid1 + 1;
      }
    }

    return 0.0; // This will never reach
  }
}
