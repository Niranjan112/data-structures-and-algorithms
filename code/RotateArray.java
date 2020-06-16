package code;
import java.util.Scanner;

public class RotateArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String[] str = s.nextLine().split(" ");
        int size = Integer.parseInt(str[0]);
        int rotation = Integer.parseInt(str[1]);
        int[] arr = new int[size];
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }

        for (int i = 0; i < rotation; i++) {
            int num = arr[0];
            for (int j = 0; j < arr.length - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[arr.length - 1] = num;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
        s.close();
    }
}