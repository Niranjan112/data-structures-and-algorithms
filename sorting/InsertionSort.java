package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {

        int arr[] = {10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8};

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i], j = i;

            while(j>0 && arr[j-1] > temp) {
                arr[j] = arr[j-1];
                j--;
            }

            arr[j] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}