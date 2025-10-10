package take_u_forward.f_array_problems.b_medium.f;

import java.util.ArrayList;
import java.util.Arrays;

public class F_RearrangeElementBySign {

  public static void main(String[] args) {
    /*
     * 2149. Rearrange Array Elements by Sign
     * Problem Link: https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
     *
     * For detailed explanation check TUF
     * */

    bruteForceApproach(new int[] {28,-41,22,-8,-37,46,35,-9,18,-6,19,-26,-37,-10,-9,15,14,31}); // O(n) + O(n/2) time complexity and O(n) space complexity.
    betterApproach(new int[] {28,-41,22,-8,-37,46,35,-9,18,-6,19,-26,-37,-10,-9,15,14,31}); // O(n) time complexity and O(n) space complexity.

    variation2(new int[] {1,2,3,-1,-2,4,-3,5,6,-4}); // O(n) + O(n) time complexity and O(n) space complexity.
  }

  public static void bruteForceApproach(int[] arr) {
    // Creating pos and neg array of same length as we know in array there will same count of pos and neg number
    int[] posArray = new int[arr.length / 2];
    int[] negArray = new int[arr.length / 2];

    int posIndex = 0;
    int negIndex = 0;

    // Iterate over the array and put pos number in posArray and neg number into negArray.
    for (int i = 0; i < arr.length; i++) {
      if(arr[i] > 0) {
        posArray[posIndex] = arr[i];
        posIndex++;
      } else {
        negArray[negIndex] = arr[i];
        negIndex++;
      }
    }

    // Extract numbers from posArray and negArray and put it into original array.
    for (int i = 0; i < arr.length / 2; i++) {
      arr[i * 2] = posArray[i]; // positive number will always come at even index (Table of 2)
      arr[(i * 2) + 1] = negArray[i]; // negative number will always come at odd index (Table of 2 + 1)
    }

    System.out.println("Rearranged Array: " + Arrays.toString(arr));

  }

  public static void betterApproach(int[] arr) {
    int evenIndex = 0; // Positive number will be there in even index
    int oddIndex = 1; // Negative number will be there in odd index
    int[] rearrangedArr = new int[arr.length]; // New array to store arranged values

    /*
    * Iterate over array,
    * If number is positive put into rearrangedArr at evenIndex then increment evenIndex by 2.
    * Else number is negative put into rearrangedArr at oddIndex then increment oddIndex by 2.
    * */
    for (int i = 0; i < arr.length; i++) {
      if(arr[i] > 0) {
        rearrangedArr[evenIndex] = arr[i];
        evenIndex += 2;
      } else {
        rearrangedArr[oddIndex] = arr[i];
        oddIndex += 2;
      }
    }

    System.out.println("Rearranged Array: " + Arrays.toString(rearrangedArr));
  }

  public static void variation2(int[] arr) {
    // Here it not guarantee that count of positive and negative number in array are same.
    ArrayList<Integer> posArray = new ArrayList<>();
    ArrayList<Integer> negArray = new ArrayList<>();

    // Iterate over the array and put pos number in posArray and neg number into negArray.
    for (int i = 0; i < arr.length; i++) {
      if(arr[i] > 0) {
        posArray.add(arr[i]);
      } else {
        negArray.add(arr[i]);
      }
    }

    // If posArray size is greater than negArray size
    if (posArray.size() > negArray.size()) {

      // As we know negArray size is small here.
      // Fill all numbers from posArray and negArray considering negArray size as end.
      for (int i = 0; i < negArray.size(); i++) {
        arr[i * 2] = posArray.get(i);
        arr[(i * 2) + 1] = negArray.get(i);
      }

      // Now fill the remaining numbers from posArray.
      // Start from negArray size as index till posArray size.
      int index = negArray.size() * 2; // Index to start filling in target array.
      for (int i = negArray.size(); i < posArray.size(); i++) {
        arr[index] = posArray.get(i);
        index++;
      }
    } else { // negArray size is greater than posArray size

      // As we know posArray size is small here.
      // Fill all numbers from posArray and negArray considering posArray size as end.
      for (int i = 0; i < posArray.size(); i++) {
        arr[i * 2] = posArray.get(i);
        arr[(i * 2) + 1] = negArray.get(i);
      }

      // Now fill the remaining numbers from negArray.
      // Start from posArray size as index till negArray size.
      int index = posArray.size() * 2;
      for (int i = posArray.size(); i < negArray.size(); i++) {
        arr[index] = negArray.get(i);
        index++;
      }
    }

    System.out.println("Variation 2 Rearranged Array: " + Arrays.toString(arr));
  }
}
