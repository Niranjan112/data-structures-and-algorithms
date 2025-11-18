package take_u_forward.e_sorting_technique.b_sorting2.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 1, 3};

        mergeSortAlgo(arr, 0, arr.length - 1); // TC: O(n * log n) and SC: O(n)

        System.out.println("Final Sorted Array: " + Arrays.toString(arr));
    }

    public static void mergeSortAlgo(int[] arr, int start, int end) {
        if(start >= end) { // Most of the cases start == end will happen but still for safe using >=
            return;
        }

        int mid = (start + end) / 2;

        mergeSortAlgo(arr, start, mid);
        mergeSortAlgo(arr, mid + 1, end);
        mergeArr(arr, start, mid, end);
    }

    private static void mergeArr(int[] arr, int start, int mid, int end) {
        int left = start; // Use left var as first index pointer of left arr
        int right = mid + 1; // Use right var as first index pointer of right arr

        List<Integer> tempSortedArray = new ArrayList<>(); // Will store complete sorted value of two arr.

        while (left <= mid && right <= end) { // Loop until left or right get out of it's array
            if(arr[left] > arr[right]) {
                tempSortedArray.add(arr[right]);
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
    }
}
