package code;
import java.util.Scanner;
public class ReverseInSameArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int[] arr = new int[size];
        int j = 0;
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }

        for (int i = arr.length - 1; i >= arr.length/2; i--) {
            int t = arr[j];
            arr[j] = arr[i];
            arr[i] = t;
            j++;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
        s.close();
    }
}