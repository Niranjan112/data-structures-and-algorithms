package sorting;

import java.util.Arrays;

public class QuickSort {
    static void quickSort(int[] array, int start, int end) {
        if(start < end) {
            int pivot = partition(array, start, end);
            quickSort(array, start, pivot - 1);
            quickSort(array, pivot + 1, end);
        }
    }

    static int partition(int[] arr, int p, int q) {
        int pivot = q;
        int i = p-1;
        for (int j = p; j <= q; j++) {
            if(arr[j] <= arr[pivot]) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int[] array = {10, 3, 2, 7, 7, 5, 8, 4, 1, 2, 9, 7, 8, 11};

        quickSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }
}