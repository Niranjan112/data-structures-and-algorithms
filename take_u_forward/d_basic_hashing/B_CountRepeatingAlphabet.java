package take_u_forward.d_basic_hashing;

import java.util.Arrays;
import java.util.HashMap;

public class B_CountRepeatingAlphabet {

  public static void main(String[] args) {
    // Counting repeating letters (Uppercase and lowercase) in a string.
    String str = "Niranjan";

    System.out.println("Using linear approach");
    linearApproach(str); // O(n^2) time complexity and O(n) space complexity

    System.out.println("\nUsing hashing approach");
    hashingApproach(str); // O(n) time complexity and O(n) space complexity

    System.out.println("\nUsing map approach");
    mapApproach(str); // O(n) time complexity and O(n) space complexity
  }

  public static void linearApproach(String str) {
    // Capital code starts from 65 and small z code ends at 122
    // So, creating an array of 122-65 = 57 + 1 = 58 elements
    boolean[] visited = new boolean[58];

    char[] chars = str.toCharArray();

    for(char ch1: chars) {
      int index = ch1 - 'A'; // Calculate index based on ASCII value

      if(visited[index]) {
        continue; // Skip if already counted
      }

      int count = 0;
      for(char ch2: chars) {
        if(ch1 == ch2) {
          count++;
        }
      }

      visited[index] = true; // Mark as visited

      System.out.println(ch1 + " occurs " + count + " times");
    }
  }

  public static void hashingApproach(String str) {
    int[] hash = new int[58];

    char[] chars = str.toCharArray();

    for (char ch: chars) {
      hash[ch - 'A']++;
    }

    for (char ch: chars) {

      int index  = ch - 'A';
      if(hash[index] > 0) {
        System.out.println(ch + " occurs " + hash[index] + " times");
        hash[index] = 0; // Setting to 0 to avoid duplicate printing
      }

    }
  }

  public static void mapApproach(String str) {
    HashMap<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);

      if(map.containsKey(ch)) {
        int count = map.get(ch);
        map.put(ch, ++count);
      } else {
        map.put(ch, 1);
      }

    }

    for (char ch: map.keySet()) {
      System.out.println(ch + " occurs " + map.get(ch) + " times");
    }
  }
}
