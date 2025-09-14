package take_u_forward.f_array_problems.a_easy;

import java.util.Arrays;

public class F_RotateArray {

  public static void main(String[] args) {

    leftRotateByOneBruteForceApproach(new int[]{1, 2, 3, 4, 5, 6, 7}); // O(n) time complexity and O(n) space complexity
    leftRotateByOneOptimalApproach(new int[]{1, 2, 3, 4, 5, 6, 7}); // O(n) time complexity and O(1) space complexity

    rotateArrayRightByKBruteForce(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    rotateArrayLeftByKBruteForce(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);

    rotateArrayRightByKOptimal(new int[]{1, 2, 3, 4, 5, 6, 7}, 3); // O(n) time complexity and O(1) space complexity
    rotateArrayLeftByKOptimal(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
  }

  public static void leftRotateByOneBruteForceApproach(int[] arr) {
    int[] temp = new int[arr.length]; // Create temp array to store rotated array values.

    // Store first element of array as last element in temp.
    // Because when you rotate array by 1 on left side the first element will always come at last.
    temp[arr.length - 1]  = arr[0];

    // Now start from index 1 in arr and put element in temp array starting from 0th index.
    for (int i = 1; i < arr.length; i++) {
      temp[i - 1] = arr[i];
    }

    System.out.println("Array after left rotation by one: " + Arrays.toString(temp));
  }

  public static void leftRotateByOneOptimalApproach(int[] arr) {
    int firstElement = arr[0]; // Put first element of an array in a variable

    /*
    * Start iterating from 0 to second last element in array.
    * Insert next element (i + 1) into current element (i)
    * */
    for(int i = 0; i < arr.length - 1; i++) {
      arr[i] = arr[i + 1];
    }

    arr[arr.length - 1] = firstElement; // Put first element into last element.
    System.out.println("Array after left rotation by one: " + Arrays.toString(arr));
  }

  public static void rotateArrayRightByKBruteForce(int[] arr, int k) {
    int[] temp = new int[arr.length];

    k = k % arr.length;

    int i = 0; // Start index of temp array
    int j = arr.length - k; // Getting the start index for right part of original array to copy into temp array
    // Start from j index till last index in arr and copy all values into temp array from 0th index.
    while(j < arr.length) {
      temp[i] = arr[j];

      i++;
      j++;
    }

    j = 0; // Reset j to 0 to copy left part of array into right part of temp array
    int leftPartArrayEndIndex = arr.length - k; // Getting end index of left part original array
    // Start from j index till calculated leftPartArrayEndIndex and copy values into temp array
    while(j < leftPartArrayEndIndex) {
      temp[i] = arr[j];

      i++;
      j++;
    }

    System.out.println("[BruteForce] Right Rotated array: " + Arrays.toString(temp));
  }

  public static void rotateArrayLeftByKBruteForce(int[] arr, int k) {
    int[] temp = new int[arr.length];

    k = k % arr.length;

    int i = 0; // Start index of original array
    int j = arr.length - k; // Getting the start index for left part of temp array.
    // Start from ith index till arr.length - k in arr and copy all values into temp array from jth index.
    while(j < arr.length) {
      temp[j] = arr[i];

      i++;
      j++;
    }

    j = 0; // Reset j to 0 to copy right part of original array into left part of temp array
    int rightPartArrayStartIndex = arr.length - k - 1; // Getting start index of right part original array
    // Start from rightPartArrayStartIndex till array last index and copy values into temp array
    while(rightPartArrayStartIndex < arr.length) {
      temp[j] = arr[rightPartArrayStartIndex];

      j++;
      rightPartArrayStartIndex++;
    }

    System.out.println("[BruteForce] Left Rotated array: " + Arrays.toString(temp));
  }

  public static void rotateArrayRightByKOptimal(int[] arr, int k) {
    /*
    * Explanation:
    * Example 1:
    * arr = 1,2,3,4,5,6,7
    * k = 3
    * We know that when we rotate array to right by 3 times. The last 3 element will come to start part of array.
    * So simple trick is,
    * First, reverse the array so that the numbers at last will come to start part of the array as below
    * 7,6,5,4,3,2,1
    * Second, consider first 0 to k-1 element (3-1 = 2) and reverse it. So now array will become as below
    * 5,6,7,4,3,2,1
    * Third, now we have to reverse the other remaining part of the array. So reverse from k(3) to last index.
    * 5,6,7,1,2,3,4
    * Hence, we will get our final rotated array
    *
    * Example 2:
    * arr = 1,2,3
    * k = 5
    * Let's rotate the array five times let see what comes.
    * 3,1,2 -> 1
    * 2,3,1 -> 2
    * 1,2,3 -> 3 (We know that when array is rotated same as length of array size then it come back to original array again)
    * 3,1,2 -> 4 (From here same rotation pattern will repeat as per 1st rotation)
    * 2,3,1 -> 5
    *
    * So if k(5) is more than array length size, and then we have to just rotate it by 2 times as per above explanation.
    * So we can always take k % arr length size ( 5 % 3 = 2 (2 is the rotation time) ).
    * */


    k = k % arr.length;

    reverseArray(arr, 0, arr.length - 1); // First reverse whole array 0 to last index
    reverseArray(arr, 0, k - 1); // Reverse first part of array 0 to k - 1
    reverseArray(arr, k, arr.length - 1); // Reverse other part of array k to last index

    System.out.println("Right rotation: " +Arrays.toString(arr));
  }

  public static void rotateArrayLeftByKOptimal(int[] arr, int k) {
    /*
    * Check rotateArrayRightByKOptimal first.
    *
    * So when we want to rotate array to right,
    * We will first, rotate the whole array.
    * Second, rotate 0 to k - 1 ( first left part of array 0 to k - 1)
    * Third, rotate remaining right part from k to last index.
    *
    * When we want to rotate array to left,
    * First, rotate the whole array.
    * Second, rotate from array length - k index to last index (right part of array)
    * Third, rotate array length - k - 1 index (left part of array)
    *
    * For example,
    * 1,2,3,4,5,6,7
    * k = 3
    * Reverse whole array = 7,6,5,4,3,2,1
    *
    * Since k is 3, we need to first reverse last 3 element
    * So we get the start index by doing arr length - k ( 7 - 3 = 4)
    * So we will fist reverse from 4th index to last index (the right part first here 3,2,1)
    *
    * Then we will reverse remaining left part (0 to arr.length - k - 1)
    * So, k is 3
    * then left part last index calculation will be 7 - 3 - 1 = 3
    * So reverse from 0th index to 3rd index (7,6,5,4)
    * */


    k = k % arr.length;

    reverseArray(arr, 0, arr.length - 1); // First reverse whole array 0 to last index
    reverseArray(arr, arr.length - k, arr.length - 1); // Reverse other second part array length - k to last index
    reverseArray(arr, 0, arr.length - k - 1); // Reverse first part of array 0 to array length - k - 1

    System.out.println("Left rotation: " + Arrays.toString(arr));
  }

  public static void reverseArray(int[] arr, int startIndex, int endIndex) {
    int temp;
    while (startIndex < endIndex) {
      temp = arr[startIndex];
      arr[startIndex] = arr[endIndex];
      arr[endIndex] = temp;

      startIndex++;
      endIndex--;
    }
  }
}
