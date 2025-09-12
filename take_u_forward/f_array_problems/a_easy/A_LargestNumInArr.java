package take_u_forward.f_array_problems.a_easy;

import java.util.Arrays;

public class A_LargestNumInArr {

  public static void main(String[] args) {
    int[] arr = {1, 5, 3, 9, 2, 8};

    bruteForceApproach1(arr); // O(n) time complexity and O(1) space complexity
    bruteForceApproach2(arr); // O(n log n) time complexity and O(1) space complexity

    System.out.println("Largest number in the array using recursion is: "
        + recursiveApproach(arr, arr.length - 1, Integer.MIN_VALUE)); // O(n) time complexity and O(n) space complexity
  }

  public static void bruteForceApproach1(int[] arr) {
    int largestNum = Integer.MIN_VALUE; // Storing smallest possible integer value

    for(int num: arr) {

      if(num > largestNum) {
        largestNum = num;
      }
    }

    System.out.println("Largest number in the array is: " + largestNum);
  }

  public static void bruteForceApproach2(int[] arr) {

    Arrays.sort(arr);

    System.out.println("Largest number in the array is: " + arr[arr.length - 1]);
  }

  public static int recursiveApproach(int[] arr, int n, int largestNum) {
    if(n < 0) {
      return largestNum;
    }

    if(arr[n] > largestNum) {
      largestNum = arr[n];
    }

    return recursiveApproach(arr, n - 1, largestNum);
  }
}
