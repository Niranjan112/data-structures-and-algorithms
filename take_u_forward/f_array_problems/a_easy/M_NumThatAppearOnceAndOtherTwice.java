package take_u_forward.f_array_problems.a_easy;

import java.util.HashMap;
import java.util.Map;

public class M_NumThatAppearOnceAndOtherTwice {

  public static void main(String[] args) {
    /*
    * 136. Single Number
    * Leet Code link: https://leetcode.com/problems/single-number/description/
    *
    * Explanation Link: https://takeuforward.org/arrays/find-the-number-that-appears-once-and-the-other-numbers-twice/
    * */

    int[] arr = {4,1,2,1,2};

    // O(n^2) time complexity and O(1) space complexity
    System.out.println("[Bruteforce Approach] Number that appears once: " + bruteForceApproach(arr));

    // O(n+n+n) time complexity and O(n) space complexity
    System.out.println("[Better Approach 1] Number that appears once: " + betterApproach1(arr));

    // O(N*logM) + O(M) time complexity and O(M) space complexity
    System.out.println("[Better Approach 1] Number that appears once: " + betterApproach2(arr));

    // O(N) time complexity and O(1) space complexity
    System.out.println("[Better Approach 1] Number that appears once: " + optimalApproach(arr));
  }

  public static int bruteForceApproach(int[] arr) {
    int numThatAppearOnce = -1;
    int count = 0; // Tracking number count

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        if(arr[i] == arr[j]) {
          count++;
        }
      }

      if(count == 1) {
        numThatAppearOnce = arr[i];
      }

      count = 0; // Reseting the count to 0 for checking count of other number.
    }

    return numThatAppearOnce;
  }

  public static int betterApproach1(int[] arr) {
    int maxNumInArr = Integer.MIN_VALUE;

    // Get maximum number in array to create hash array of that max number
    for (int num: arr) {
      maxNumInArr = Math.max(maxNumInArr, num);
    }

    int[] hash = new int[maxNumInArr + 1];

    for (int num: arr) {
      hash[num]++;
    }

    int numThatAppearOnce = 0;
    for (int i = 0; i < hash.length; i++) {
      if(hash[i] == 1) {
        numThatAppearOnce = i;
      }
    }

    return numThatAppearOnce;
  }

  public static int betterApproach2(int[] arr) {
    Map<Integer, Integer> numbersCount = new HashMap<>();

    for (int num: arr) {
      int count = numbersCount.getOrDefault(num, 0);
      numbersCount.put(num, ++count);
    }

    int numThatAppearOnce = 0;
    for (int key: numbersCount.keySet()) {
      if(numbersCount.get(key) == 1) {
        numThatAppearOnce = key;
      }
    }

    return numThatAppearOnce;
  }

  public static int optimalApproach(int[] arr) {
    int xor = 0;

    for (int num: arr) {
      xor = xor ^ num;
    }

    return xor;
  }
}
