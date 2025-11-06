package take_u_forward.f_array_problems.c_hard.b;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B_MajorityElement2 {

  public static void main(String[] args) {
    /*
     *
     * 229. Majority Element II
     * Problem Link: https://leetcode.com/problems/majority-element-ii/description/
     *
     * For detailed explanation check TUF
     * */
    int[] arr = {1, 1, 1, 3, 3, 2, 2, 2};

    bruteForceApproach(arr); // TC: O(n^2) and SC: O(1)
    betterApproach(arr); // TC: O(N*logN) and SC: O(n)
    optimalApproach(arr); // TC: O(n + n) and SC: O(1)
  }

  public static void bruteForceApproach(int[] arr) {
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < arr.length; i++) {

      /*
      * Only check for more than n/3 times if list is empty or first number which is pushed to list is not appearing again.
      * Remember at max there will be always only 2 numbers in array of any size more than n/3 times.
      * */
      if(result.isEmpty() || result.get(0) != arr[i]) {
        int count = 0;
        for (int j = 0; j < arr.length; j++) {
          if(arr[i] == arr[j]) {
            count++;
          }
        }

        if(count > (arr.length / 3)) {
          result.add(arr[i]);
        }
      }

      // If we got two numbers then our job is done we can break the loop.
      if(result.size() == 2) {
        break;
      }
    }

    System.out.println("Number occurred more than n/3 times: " + result);
  }

  public static void betterApproach(int[] arr) {
    List<Integer> result = new ArrayList<>();

    Map<Integer, Integer> numberOccurrenceCount = new HashMap<>();

    for (int num: arr) {
      int count = numberOccurrenceCount.getOrDefault(num, 0);
      numberOccurrenceCount.put(num, count + 1);

      /*
      * Here as we are counting and comparing in the same loop at same time.
      * It is important to compare count == (arr.length / 3) + 1
      *
      * Because let's say if input arr is [2,2]
      * n/3 will be 0.
      * In first iteration, 2 will come and count will be 1 it will be added to result.
      * In second iteration, another 2 will come and count will be 2 and this time it will be added again to result if our condition was count > arr.length / 3
      * That's why matching exactly (arr.length / 3) + 1 == count will save here.
      * */
      if(numberOccurrenceCount.get(num) == (arr.length / 3) + 1) {
        result.add(num);
      }

      if(result.size() == 2) {
        break;
      }
    }

    System.out.println("Number occurred more than n/3 times: " + result);
  }

  public static void optimalApproach(int[] arr) {
    // Note: For visual explanation check majority_element_2_optimal_exp.jpg

    int count1 = 0, count2 = 0;
    int electedNum1 = Integer.MIN_VALUE, electedNum2 = Integer.MIN_VALUE; // Setting to min value as there can 0 number in array.

    for (int i = 0; i < arr.length; i++) {

      if(count1 == 0 && electedNum2 != arr[i]) { // Only elect new number when count1 = 0 and current number is not already elected by electedNum2
        count1 = 1;
        electedNum1 = arr[i];
      } else if(count2 == 0 && electedNum1 != arr[i]) { // Only elect new number when count2 = 0 and current number is not already elected by electedNum1
        count2 = 1;
        electedNum2 = arr[i];
      } else if (arr[i] == electedNum1) {
        count1++;
      } else if (arr[i] == electedNum2) {
        count2++;
      } else {
        count1--;
        count2--;
      }
    }

    // Verify your elected num1 and num2 and then add it to list
    count1 = 0;
    count2 = 0;

    for (int i = 0; i < arr.length; i++) {
      if(arr[i] == electedNum1) {
        count1++;
      }
      if(arr[i] == electedNum2) {
        count2++;
      }
    }

    List<Integer> result = new ArrayList<>();
    if(count1 >= (arr.length / 3) + 1) {
      result.add(electedNum1);
    }
    if(count2 >= (arr.length / 3) + 1) {
      result.add(electedNum2);
    }

    System.out.println("Number occurred more than n/3 times: " + result);
  }
}
