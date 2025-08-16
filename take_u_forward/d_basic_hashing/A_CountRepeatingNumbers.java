package take_u_forward.d_basic_hashing;

import java.util.HashMap;

public class A_CountRepeatingNumbers {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 3, 8, 9, 10, 1, 2, 3, 4, 3};

    System.out.println("Using Linear Approach:");
    linearApproach(arr); // O(n^2) time complexity and O(n) space complexity

    System.out.println("\nUsing Hashing Approach:");
    hashingApproach(arr); // O(n) time complexity and O(n) space complexity

    System.out.println("\nUsing Map Approach:");
    mapApproach(arr); // O(n) time complexity and O(n) space complexity
  }

  public static void linearApproach(int[] arr) {
    boolean[] visited = new boolean[11];

    for (int i = 0; i < arr.length; i++) {

      if(visited[arr[i]]) {
        continue; // Skip if already counted
      } else {
        visited[arr[i]] = true; // Mark as visited
      }

      int count = 0;
      for (int j = 0; j < arr.length; j++) {

        if(arr[i] == arr[j]) {
          count++;
        }

      }

      System.out.println(arr[i] + " occurs " + count + " times");
    }
  }

  public static void hashingApproach(int[] arr) {
    int[] hash = new int[11]; // Assuming numbers are in the range 0-10

    for (int num: arr) {
      hash[num]++;
    }

    for (int i = 1; i < hash.length; i++) {
      if(hash[i] > 0) {
        System.out.println(i + " occurs " + hash[i] + " times");
      }
    }
  }

  public static void mapApproach(int[] arr) {
    /*
    * Integer array has size limitation,
    * so we can use HashMap to store the count of each number if the number is very large.
    * */
    HashMap<Integer, Integer> map = new HashMap<>();

    for(int num: arr) {

      if(map.get(num) == null) {
        map.put(num, 1);
      } else {
        int count = map.get(num);
        map.put(num, ++count); // Using pre increment so that it increment the value first and set it in map.
        // If you use post increment, it will set current count value in map and then it will increment.
      }

    }

    for(Integer num: map.keySet()) {
      System.out.println(num + " occurs " + map.get(num) + " times");
    }
  }
}
