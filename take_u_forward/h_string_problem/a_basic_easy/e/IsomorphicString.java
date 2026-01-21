package take_u_forward.h_string_problem.a_basic_easy.e;

import java.util.Arrays;
import java.util.HashMap;

public class IsomorphicString {

  public static void main(String[] args) {
    String str1 = "badc";
    String str2 = "baba";

    System.out.println("Is Isomorphic String: " + solution(str1, str2));
  }

  public static boolean solution(String str1, String str2) {
    int[] str1Map = new int[256]; // Stores mapping of str2 char
    int[] str2Map = new int[256]; // Stores mapping of str1 char.

    for (int i = 0; i < str1.length(); i++) {
      char ch1 = str1.charAt(i);
      char ch2 = str2.charAt(i);

      if(str1Map[ch1] != 0) { // If ch1 mapping is there in arr then check if it ch2 only if not then return false.
        if(str1Map[ch1] != ch2) {
          return false;
        }
      } else { // Else if ch1 mapping is not there then put it's mapping from str2 which is ch2
        str1Map[ch1] = ch2;
      }

      if(str2Map[ch2] != 0) { // If ch2 mapping is there in arr then check if it ch1 only if not then return false.
        if(str2Map[ch2] != ch1) {
          return false;
        }
      } else { // Else if ch2 mapping is not there then put it's mapping from str1 which is ch1
        str2Map[ch2] = ch1;
      }

    }

    return true; // If reached here then it is isomorphic string
  }

}
