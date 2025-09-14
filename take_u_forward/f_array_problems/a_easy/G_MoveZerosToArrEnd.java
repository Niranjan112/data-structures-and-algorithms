package take_u_forward.f_array_problems.a_easy;

import java.util.Arrays;

public class G_MoveZerosToArrEnd {

  public static void main(String[] args) {
    /*
    * 283. Move Zeroes
    * Leet Code Problem link: https://leetcode.com/problems/move-zeroes/description/
    *
    * */

    int[] arr = {1,0,2,0,3,0,4};

    bruteForceApproach(arr); // O(n) time complexity and O(n) space complexity
    optimalApproach(arr); // O(n) time complexity and O(1) space complexity
  }

  public static void bruteForceApproach(int[] arr) {
    /*
    * If number is not 0 in arr then copy the value in temp array.
    * */

    int[] temp = new int[arr.length];

    int j = 0;
    for (int num : arr) {

      if (num != 0) {
        temp[j] = num;
        j++;
      }
    }

    System.out.println("Result: " + Arrays.toString(temp));

  }

  public static void optimalApproach(int[] arr) {
    // If array length is 1 or less than 1 then simply return.
    if(arr.length < 2) {
      return;
    }

    // Start index that will only increment if arr[i] != 0. Because if arr[i] is 0 then i should hold that index to be replaced in future by other number.
    int i = 0;
    int temp; // Temp variable used for swapping

    /*
    * Start j from 1st index as i is already at 0.
    * Swap values when arr i is 0 and arr j is some other number
    * j should always be incremented by 1 to keep checking for number which is not 0 in arr.
    * and i should only be incremented by 1 when it's current number is not 0 anymore.
    * */
    for (int j = 1; j < arr.length; j++) {

      if(arr[i] == 0 && arr[j] != 0) {
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }

      if(arr[i] != 0) {
        i++;
      }
    }

    System.out.println("Result: " + Arrays.toString(arr));
  }

}
