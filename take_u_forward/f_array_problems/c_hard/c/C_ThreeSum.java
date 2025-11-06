package take_u_forward.f_array_problems.c_hard.c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class C_ThreeSum {

  public static void main(String[] args) {
    /*
     *
     * 15. 3Sum
     * Problem Link: https://leetcode.com/problems/3sum/description/
     *
     * For detailed explanation check TUF
     * */

    int[] arr = {-1, 0, 1, 2, -1, -4};

    bruteForceApproach(arr); // TC: O(N^3 * log(no. of unique triplets)) & SC: O(2 * no. of the unique triplets)
    betterApproach(arr); // TC: O(N2 * log(no. of unique triplets)) & SC: O(2 * no. of the unique triplets) + O(N)
    optimalApproach(arr); // TC: O(NlogN) + O(N2) and SC: O(n)
  }

  public static void bruteForceApproach(int[] arr) {
    // Note: For visual explanation check 3sum_brute_force_exp.jpg

    Set<List<Integer>> uniqueTriplets = new HashSet<>(); // Set will take care of maintaining unique list

    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        for (int k = j + 1; k < arr.length; k++) {

          if(arr[i] + arr[j] + arr[k] == 0) {
            List<Integer> triplet = Arrays.asList(arr[i], arr[j], arr[k]);
            triplet.sort(null); // List will be sorted in ascending order

            uniqueTriplets.add(triplet);
          }
        }
      }
    }

    List<List<Integer>> result = new ArrayList<>(uniqueTriplets);
    System.out.println("All unique 3 sums: " + result);
  }

  public static void betterApproach(int[] arr) {
    // Note: For visual explanation check 3sum_better_exp.jpg

    Set<List<Integer>> uniqueTriplets = new HashSet<>(); // Set will take care of maintaining unique list
    Set<Integer> setFor3rdNum = new HashSet<>(); // Will store possible third num here.

    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {

        int thirdNum = -(arr[i] + arr[j]); // Extract third num we are looking for from arr[k] = -(arr[i] + arr[j])

        if(setFor3rdNum.contains(thirdNum)) { // If third num is present in hashset then we found triplet.
          List<Integer> triplet = Arrays.asList(arr[i], arr[j], thirdNum);
          triplet.sort(null); // Sort the triplet in ascending order

          uniqueTriplets.add(triplet);
        } else {
          setFor3rdNum.add(arr[j]);
        }
      }

      setFor3rdNum.clear();
    }

    List<List<Integer>> result = new ArrayList<>(uniqueTriplets);
    System.out.println("All unique 3 sums: " + result);
  }

  public static void optimalApproach(int[] arr) {
    // Note: For visual explanation check 3sum_optimal_exp.jpg

    List<List<Integer>> result = new ArrayList<>();

    Arrays.sort(arr); // Sort the array first

    for (int i = 0; i < arr.length; i++) {

      if(i > 0 && arr[i] == arr[i - 1]) { // If in previous iteration num at i is already processed and same number occur again then skip it.
        continue;
      }

      int j = i + 1;
      int k = arr.length - 1;
      while (j < k) {
        int sum = arr[i] + arr[j] + arr[k];
        if(sum < 0) { // If sum is less than 0 then increment left pointer which is j.
          j++;
        } else if (sum > 0) { // If sum is greater than 0 then decrement right pointer which is k.
          k--;
        } else { // If sum == 0
          List<Integer> triplet = Arrays.asList(arr[i], arr[j], arr[k]);
          result.add(triplet);
          j++;
          k--;

          /*
          * After we get sum = 0 for 3 numbers.
          * then check if previous number before j is same if yes then keep skipping those same numbers by incrementing j until we found a different number at j.
          * same check if next number after k is same if yes then keep skipping those same numbers by decrementing k until we found a different number at k.
          * */
          while (j < k && arr[j - 1] == arr[j]) {
            j++;
          }
          while (j < k && arr[k] == arr[k + 1]) {
            k--;
          }
        }
      }
    }

    System.out.println("All unique 3 sums: " + result);
  }
}
