package sorting;

import heap.HeapByArray;
import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        
        int arr[] = {10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8};

        HeapByArray hba = new HeapByArray(arr.length);

        for (int i = 0; i < arr.length; i++) {
            hba.insert(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = hba.extractTopOfHeap();
        }

        System.out.println(Arrays.toString(arr));
    }
}