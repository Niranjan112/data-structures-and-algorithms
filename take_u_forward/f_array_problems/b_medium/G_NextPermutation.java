package take_u_forward.f_array_problems.b_medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class G_NextPermutation {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3};

    List<List<Integer>> allPermutations1 = new ArrayList<>();
    List<Integer> currentPermutation = new ArrayList<>();
    boolean[] freq = new boolean[arr.length];

    // O( factorial of n * n) time complexity and O(n + n) space complexity.
    generateAllPermutationWithSpace(arr, currentPermutation, freq, allPermutations1);

    System.out.println("\nAll permutations generated with space:");
    for (List<Integer> perm : allPermutations1) {
      System.out.println(perm);
    }

    List<List<Integer>> allPermutations2 = new ArrayList<>();

    generateAllPermutationWithOutSpace(0, arr, allPermutations2);
    System.out.println("\nAll permutations generated without space:");
    for (List<Integer> perm : allPermutations2) {
      System.out.println(perm);
    }

    /*
     * Before solving the Leet Code problem check how permutation can be generated.
     *
     * 31. Next Permutation
     * Problem Link: https://leetcode.com/problems/next-permutation/description/
     *
     * For detailed explanation check TUF
     * */

    // O( (factorial of n * n) + (factorial of n + m)) time complexity and O(n + n) space complexity.
    bruteForceApproach(new int[]{2,1,3}, allPermutations1);

    // Better approach in C++ can be using next_permutation inbuilt function

    int[] result = optimalApproach(new int[]{2, 1, 5, 4, 3, 0, 0});
    System.out.println("\nNext Permutation: " + Arrays.toString(result));

  }

  public static void generateAllPermutationWithSpace(
      int[] arr,
      List<Integer> currentPermutation,
      boolean[] freq,
      List<List<Integer>> allPermutations
  ) {

    // For detail explanation check image G_generateAllPermutationRecurseExplanation.jpg in the same package.

    // Base condition to add current found Permutation and return
    if (currentPermutation.size() == arr.length) {
      allPermutations.add(new ArrayList<>(currentPermutation));
      return;
    }

    // Check if each number is present in freq
    for (int i = 0; i < arr.length; i++) {

      // If not present then add the number into currentPermutation and mark it in freq which is a hashing map.
      if (!freq[i]) {
        freq[i] = true;
        currentPermutation.add(arr[i]);

        // Do Recursive call, when a new number is added into currentPermutation and mark in freq hashing map.
        generateAllPermutationWithSpace(arr, currentPermutation, freq, allPermutations);

        // Once all number are added, and it reaches the base condition, then remove that number and unmark in freq.
        currentPermutation.removeLast();
        freq[i] = false;
      }
    }
  }

  public static void generateAllPermutationWithOutSpace(int currentIndex, int[] arr, List<List<Integer>> allPermutations) {
    // For detail explanation check image G_generateAllPermutationWithOutSpaceRecurseExplanation.jpg in the same package.
    // Note: This will not generate permutation in lexicographical sort order.

    // When currentIndex reached to last element of arr then save the rearranged value in array as permutation and return.
    if(currentIndex == arr.length) {
      List<Integer> currentPermutation = new ArrayList<>();

      for (int i = 0; i < arr.length; i++) {
        currentPermutation.add(arr[i]);
      }

      allPermutations.add(new ArrayList<>(currentPermutation));

      return;
    }

    // Start with currentIndex and swap with all the values available at right side of array from currentIndex.
    for (int i = currentIndex; i < arr.length; i++) {
      swap(arr, i, currentIndex); // Swap to get the permutation

      generateAllPermutationWithOutSpace(currentIndex + 1, arr, allPermutations);

      swap(arr, i, currentIndex); // Rearrange the array back to original value at root when function is returned.
    }
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void bruteForceApproach(int[] arr, List<List<Integer>> allPermutations) {
    /*
    * Generate all possible permutation in sorted order.
    * Find for the input array in allPermutations.
    *
    * If found, then the return next index after matchIndex from allPermutation list
    * */


    int matchedIndex = -1;
    for (int i = 0; i < allPermutations.size(); i++) {

      List<Integer> currentPermutation = allPermutations.get(i);
      boolean match = true;

      for (int j = 0; j < arr.length; j++) {
        if(arr[j] != currentPermutation.get(j)) {
          match = false;
          break;
        }
      }

      if(match) {
        matchedIndex = i;
      }
    }

    // If matchIndex + 1 == allPermutations.size() then return 0th index.
    int nextPermutationIndex = (matchedIndex + 1) % allPermutations.size();

    System.out.println("\nNext Permutation: " + allPermutations.get(nextPermutationIndex));
  }

  public static int[] optimalApproach(int[] arr) {
    /*
    * For visualization, check G_NextPermutationLeetCode.jpg in the same package
    * Start from last element, keeping moving forward until numbers are in increasing order.
    * Once we found a decreasing number, that index can be considered as break point and also break the loop.
    * */
    int breakPointIndex = -1;
    for (int i = arr.length - 2; i >= 0; i--) {

      if(arr[i] < arr[i + 1]) {
        breakPointIndex = i;
        break;
      }
    }

    // If no breakPointIndex is not found then the array is already in increasing order from last and simply reverse the array to get the next permutation.
    // And exit the code.
    if(breakPointIndex == -1) {
      reverseArr(arr, 0,  arr.length - 1);
      return arr;
    }

    /*
    * If breakPointIndex is found,
    * Check for the number which is immediate greater than arr[breakPointIndex]
    *
    * As we know that, the number after the breakPointIndex are in descending order.
    * Start from last element and go till breakPointIndex.
    * When we found immediate greater number then just swap it.
    * */
    for (int i = arr.length - 1; i > breakPointIndex; i--) {

      if(arr[i] > arr[breakPointIndex]) {
        swap(arr, breakPointIndex, i);
        break;
      }
    }

    // After swapping, simply reverse the array from after breakPointIndex till end of array to get the next permutation
    reverseArr(arr, breakPointIndex + 1, arr.length - 1);

    return arr;
  }

  private static void reverseArr(int[] arr, int i, int j) {
    while(i < j) {
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;

      i++;
      j--;
    }
  }

}
