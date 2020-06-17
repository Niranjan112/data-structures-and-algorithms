package sorting;
import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {10, 3, 2, 5, 8, 4, 3, 1, 2, 9, 7, 8};

        for (int i = 0; i < arr.length; i++) {
            int minimumIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[minimumIndex]) {
                    minimumIndex = j;
                }
            }

            if(minimumIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minimumIndex];
                arr[minimumIndex] = temp;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}