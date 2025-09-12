package take_u_forward.f_array_problems.a_easy;

import java.util.Arrays;

public class B_SecondLargestAndSmallestNumInArr {

  public static void main(String[] args) {
    int[] arr = {1, 5};

    betterApproach1(arr); // O(n + n) time complexity and O(1) space complexity
    betterApproach2(arr); // O(n + n) time complexity and O(1) space complexity

    bruteForceApproach(arr); // O(n log n) time complexity and O(1) space complexity

    optimalApproachGetSecondSmallestNum(arr); // O(n) time complexity and O(1) space complexity
    optimalApproachGetSecondLargestNum(arr);// O(n) time complexity and O(1) space complexity
  }

  public static void bruteForceApproach(int[] arr) {
    /*
    * Note: If all numbers are same, then this algorithm will not work.
    * It will give the same number as second largest and second smallest.
    * */

    if (arr == null || arr.length < 2) {
      System.out.println("Array must have at least 2 distinct numbers.");
      return;
    }

    Arrays.sort(arr);

    System.out.println("Second smallest number in the array is: " + arr[1]);
    System.out.println("Second largest number in the array is: " + arr[arr.length - 2]);
  }

  public static void betterApproach1(int[] arr) {
    if (arr == null || arr.length < 2) {
      System.out.println("Array must have at least 2 distinct numbers.");
      return;
    }

    int largestNum = Integer.MIN_VALUE; // Storing smallest possible integer value
    int secondLargestNum = Integer.MIN_VALUE; // Storing smallest possible integer value
    int smallestNum = Integer.MAX_VALUE; // Storing largest possible integer value
    int secondSmallestNum = Integer.MAX_VALUE; // Storing largest possible integer value

    // Finding largest and smallest number in the array
    for(int num: arr) {
      smallestNum = Math.min(smallestNum, num);
      largestNum = Math.max(largestNum, num);
    }

    // Variables to track the minimum difference between number to find second largest and second smallest
    int diffToFindSecondLargest = Integer.MAX_VALUE;
    int diffToFindSecondSmallest = Integer.MAX_VALUE;

    for (int num: arr) {
      int diff = largestNum - num; // Getting difference between the largest number and current number

      // If the difference is less than the current minimum difference and not zero (to avoid the largest number itself)
      if(diff < diffToFindSecondLargest && diff != 0) {
        diffToFindSecondLargest = diff;
        secondLargestNum = num;
      }

      diff = num - smallestNum; // Getting difference between the smallest number and current number

      // If the difference is less than the current minimum difference and not zero (to avoid the smallest number itself)
      if(diff < diffToFindSecondSmallest && diff != 0) {
        diffToFindSecondSmallest = diff;
        secondSmallestNum = num;
      }
    }

    // If second largest and second-smallest number are not updated, it means all elements are equal
    if (secondLargestNum == Integer.MIN_VALUE && secondSmallestNum == Integer.MAX_VALUE) {
      System.out.println("No second largest or smallest number (all elements equal).");
    } else {
      System.out.println("Second smallest number in the array is: " + secondSmallestNum);
      System.out.println("Second largest number in the array is: " + secondLargestNum);
    }
  }

  public static void betterApproach2(int[] arr) {
    if (arr == null || arr.length < 2) {
      System.out.println("Array must have at least 2 distinct numbers.");
      return;
    }

    int largestNum = Integer.MIN_VALUE; // Storing smallest possible integer value
    int secondLargestNum = Integer.MIN_VALUE; // Storing smallest possible integer value
    int smallestNum = Integer.MAX_VALUE; // Storing largest possible integer value
    int secondSmallestNum = Integer.MAX_VALUE; // Storing largest possible integer value

    // Finding largest and smallest number in the array
    for(int num: arr) {
      smallestNum = Math.min(smallestNum, num);
      largestNum = Math.max(largestNum, num);
    }

    for (int num: arr) {

      // Avoid the largestNum and other secondLargestNum will be selected at the end.
      if(num < secondSmallestNum && num != smallestNum) {
        secondSmallestNum = num;
      }

      // Avoid the smallestNum and other secondSmallestNum will be selected at the end.
      if(num > secondLargestNum && num != largestNum) {
        secondLargestNum = num;
      }
    }

    // If second largest and second-smallest number are not updated, it means all elements are equal
    if (secondLargestNum == Integer.MIN_VALUE && secondSmallestNum == Integer.MAX_VALUE) {
      System.out.println("No second largest or smallest number (all elements equal).");
    } else {
      System.out.println("Second smallest number in the array is: " + secondSmallestNum);
      System.out.println("Second largest number in the array is: " + secondLargestNum);
    }
  }

  public static void optimalApproachGetSecondLargestNum(int[] arr) {
    int largestNum = Integer.MIN_VALUE; // Storing smallest possible integer value
    int secondLargestNum = Integer.MIN_VALUE; // Storing smallest possible integer value

    for (int num: arr) {
      if(num > largestNum) {
        secondLargestNum = largestNum;
        largestNum = num;
      } else if(num > secondLargestNum && num != largestNum) {
        secondLargestNum = num;
      }
    }

    System.out.println("Second largest number in the array is: " + secondLargestNum);
  }

  public static void optimalApproachGetSecondSmallestNum(int[] arr) {
    int smallestNum = Integer.MAX_VALUE; // Storing smallest possible integer value
    int secondSmallestNum = Integer.MAX_VALUE; // Storing smallest possible integer value

    for (int num: arr) {
      if(num < smallestNum) {
        secondSmallestNum = smallestNum;
        smallestNum = num;
      } else if(num < secondSmallestNum && num != smallestNum) {
        secondSmallestNum = num;
      }
    }

    System.out.println("Second smallest number in the array is: " + secondSmallestNum);
  }
}
