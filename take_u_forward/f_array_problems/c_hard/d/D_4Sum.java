package take_u_forward.f_array_problems.c_hard.d;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class D_4Sum {

  public static void main(String[] args) {
    int[] arr = {1, 0, -1, 0, -2, 2};

    bruteForceApproach(arr, 0);
    betterApproach(arr, 0);
    optimalApproach(arr, 0);
  }

  public static void bruteForceApproach(int[] arr, int target) {
    // Same solution as 3 Sum as just one more is added

    Set<List<Integer>> uniqueQuad = new HashSet<>(); // Set will take care of maintaining unique list

    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        for (int k = j + 1; k < arr.length; k++) {
          for (int l = k+1; l < arr.length; l++) {
            if(arr[i] + arr[j] + arr[k] + arr[l] == target) {
              List<Integer> quad = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
              quad.sort(null); // List will be sorted in ascending order

              uniqueQuad.add(quad);
            }
          }
        }
      }
    }

    List<List<Integer>> result = new ArrayList<>(uniqueQuad);
    System.out.println("All unique 4 sums: " + result);
  }

  public static void betterApproach(int[] arr, int target) {
    // Same solution as 3 Sum as just one more loop is added for third number and taken care of integer overflow while summing up

    Set<List<Integer>> uniqueQuad = new HashSet<>(); // Set will take care of maintaining unique list
    Set<Long> setFor4thNum = new HashSet<>(); // Will store possible third num here.

    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        for (int k = j + 1; k < arr.length; k++) {
          long sum = arr[i] + arr[j]; // arr[i] + arr[j] + arr[k] are integer but their result first become into integer overflow then it will store in long sum
          sum += arr[k]; // So to avoid we're adding third number separately to sum
          long fourthNum = target - sum; // Extract fourth num we are looking for from arr[l] = target - (arr[i] + arr[j] + arr[k])

          if(setFor4thNum.contains(fourthNum)) { // If fourth num is present in hashset then we found quad.
            List<Integer> quad = Arrays.asList(arr[i], arr[j], arr[k], (int) fourthNum);
            quad.sort(null); // Sort the quad in ascending order

            uniqueQuad.add(quad);
          }
          setFor4thNum.add((long) arr[k]);
        }

        setFor4thNum.clear();
      }
    }

    List<List<Integer>> result = new ArrayList<>(uniqueQuad);
    System.out.println("All unique 4 sums: " + result);
  }

  public static void optimalApproach(int[] arr, int target) {
    // Same solution as 3 Sum just added one more loop to hold first two variable at i and j and taken care of integer overflow while summing up.

    List<List<Integer>> result = new ArrayList<>();

    Arrays.sort(arr); // Sort the array first

    for (int i = 0; i < arr.length; i++) {

      if(i > 0 && arr[i] == arr[i - 1]) { // If in previous iteration num at i is already processed and same number occur again then skip it.
        continue;
      }

      for (int j = i + 1; j < arr.length; j++) {

        if(j > i + 1 && arr[j] == arr[j - 1]) { // If in previous iteration num at j is already processed and same number occur again then skip it.
          continue;
        }

        int k = j + 1;
        int l = arr.length - 1;
        while (k < l) {
          long sum = arr[i];
          sum += arr[j];
          sum += arr[k];
          sum += arr[l];

          if(sum == target) {
            List<Integer> quad = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
            result.add(quad);
            k++;
            l--;

            /*
             * After we get sum = target for 4 numbers.
             * then check if previous number before k is same if yes then keep skipping those same numbers by incrementing k until we found a different number at k.
             * same check if next number after l is same if yes then keep skipping those same numbers by decrementing l until we found a different number at l.
             * */
            while (k < l && arr[k - 1] == arr[k]) {
              k++;
            }
            while (k < l && arr[l] == arr[l + 1]) {
              l--;
            }
          } else if(sum < target) {
            k++;
          } else { // sum > target
            l--;
          }
        }
      }
    }

    System.out.println("All unique 4 sums: " + result);
  }
}
