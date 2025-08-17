package take_u_forward.d_basic_hashing;

import java.util.HashMap;

public class C_FindNumCoutAndMinMaxCount {

  public static void main(String[] args) {
    /*
    * Given an array of size N. Find the highest and lowest frequency element.
    * Example:
    * Input: array[] = {10,5,10,15,10,5};
    * Output: 10 15
    * Explanation: The frequency of 10 is 3, i.e. the highest and the frequency of 15 is 1 i.e. the lowest.
    * */

    int[] arr1 = {10,5,10,15,10,5};
    int[] arr2 = {2,2,3,4,4,2};

    System.out.println("Using brute force approach");
    bruteForceApproach(arr1); // O(n^2) time complexity and O(n) space complexity
    System.out.println();
    bruteForceApproach(arr2);

    System.out.println("\nUsing optimal force approach using HashMap");
    optimalApproach(arr1); // O(n) time complexity and O(n) space complexity
    System.out.println();
    optimalApproach(arr2);
    // Same optimal approach can be achieved using hash array.
  }

  public static void bruteForceApproach(int[] arr) {
    boolean[] visited = new boolean[arr.length];
    int maxCount = Integer.MIN_VALUE;
    int minCount = Integer.MAX_VALUE;
    int maxFreqNumber = -1;
    int minFreqNumber = -1;

    for (int i = 0; i < arr.length; i++) {

      if(visited[i]) {
        continue;
      }

      int count = 0;
      for (int j = 0; j < arr.length; j++) {
        if(arr[i] == arr[j]) {
          // Mark arr index j as visited. So j will be the future index of i if the number is repeated.
          visited[j] = true;
          count++;
        }
      }

      if(count > maxCount) {
        maxCount = count;
        maxFreqNumber = arr[i];
      }

      if(count < minCount) {
        minCount = count;
        minFreqNumber = arr[i];
      }
    }

    System.out.println("Max Frequency Number: " + maxFreqNumber + " with count: " + maxCount);
    System.out.println("Min Frequency Number: " + minFreqNumber + " with count: " + minCount);
  }

  public static void optimalApproach(int[] arr) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int maxCount = Integer.MIN_VALUE;
    int minCount = Integer.MAX_VALUE;
    int maxFreqNumber = -1;
    int minFreqNumber = -1;

    for (int num: arr) {

      if(map.containsKey(num)) {
        int count = map.get(num);
        map.put(num, ++count);

      } else {
        map.put(num, 1);
      }

    }

    for (int num: map.keySet()) {
      int count = map.get(num);

      if(count > maxCount) {
        maxCount = count;
        maxFreqNumber = num;
      }

      if(count < minCount) {
        minCount = count;
        minFreqNumber = num;
      }
    }

    System.out.println("Max Frequency Number: " + maxFreqNumber + " with count: " + maxCount);
    System.out.println("Min Frequency Number: " + minFreqNumber + " with count: " + minCount);
  }

}
