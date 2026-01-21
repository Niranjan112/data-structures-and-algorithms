package take_u_forward.h_string_problem.a_basic_easy.d;

import java.util.Arrays;

public class D_LongestCommonPrefix {

  public static void main(String[] args) {
    // TC: O(n * log n + m) and SC: O(m)
    solution(new String[] {"flower","flow","flight"});
    solution(new String[] {"dog","racecar","car"});
  }

  public static void solution(String[] strArr) {
    Arrays.sort(strArr); // Sorting string array lexicographically

    StringBuilder result = new StringBuilder();

    // As String array is sorted in lexicographically order now we can just compare the first and last string in arr.
    // And We will get our longest common prefix
    String firstStringInArr = strArr[0];
    String lastStringInArr = strArr[ strArr.length - 1 ];

    // Get the min last length from first and last string in arr to iterate.
    int end = Math.min(firstStringInArr.length(), lastStringInArr.length());

    // If chars are coming equals keep appending it to result.
    // Once it got not equal immediately stop and return the collected prefix.
    int i = 0;
    while (i < end) {
      if(firstStringInArr.charAt(i) == lastStringInArr.charAt(i)) {
        result.append(firstStringInArr.charAt(i));
        i++;
      } else {
        break;
      }
    }

    System.out.println("Longest Common Prefix: " + result.toString());
  }
}
