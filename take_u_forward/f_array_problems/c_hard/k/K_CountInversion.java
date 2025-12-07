package take_u_forward.f_array_problems.c_hard.k;

import java.util.ArrayList;
import java.util.List;

public class K_CountInversion {
  public static void main(String[] args) {
    int[] arr = {2, 4, 1, 3, 5};

    bruteForceApproach(arr); // TC: O(n ^ 2) and SC: O(1)
    optimalApproach(arr); // TC: O(n log n) and SC: O(n)
  }

  public static void bruteForceApproach(int[] arr) {
    int countOfPairs = 0;

    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] > arr[j]) {
          countOfPairs++;
        }
      }
    }

    System.out.println("Inversion Pairs count: " + countOfPairs);
  }

  public static void optimalApproach(int[] arr) {
    int countOfPairs = mergeSortAlgo(arr, 0, arr.length - 1);

    System.out.println("Inversion Pairs count: " + countOfPairs);

  }

  public static int mergeSortAlgo(int[] arr, int start, int end) {
    int count = 0;

    if(start >= end) { // Most of the cases start == end will happen but still for safe using >=
      return count;
    }

    int mid = (start + end) / 2;

    count += mergeSortAlgo(arr, start, mid);
    count += mergeSortAlgo(arr, mid + 1, end);
    count += mergeArr(arr, start, mid, end);

    return count; // Send final count value
  }

  private static int mergeArr(int[] arr, int start, int mid, int end) {
    int left = start; // Use left var as first index pointer of left arr
    int right = mid + 1; // Use right var as first index pointer of right arr

    List<Integer> tempSortedArray = new ArrayList<>(); // Will store complete sorted value of two arr.

    int countOfPairs = 0;
    while (left <= mid && right <= end) { // Loop until left or right get out of it's array
      if(arr[left] > arr[right]) {
        tempSortedArray.add(arr[right]);
        countOfPairs += (mid - left + 1); // If number at left side is greater then rest number will be eligible for pairs as the arr is sorted. Get count of all rest number including current number.
        right++;
      } else {
        tempSortedArray.add(arr[left]);
        left++;
      }
    }

    while (left <= mid) { // If still any number pending in left arr the simply store it
      tempSortedArray.add(arr[left]);
      left++;
    }
    while (right <= end) { // If still any number pending in right arr the simply store it
      tempSortedArray.add(arr[right]);
      right++;
    }

    // Get all values from temp array and put it back to original array in sorted order
    for (int i = start; i <= end; i++) {
      arr[i] = tempSortedArray.get(i - start); // Doing i - start so element from temp array are always picked up sequentially
    }

    return countOfPairs;
  }
}
