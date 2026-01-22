package take_u_forward.h_string_problem.a_basic_easy.f;

public class F_IsRotatedString {

  public static void main(String[] args) {
    String str = "abcde";
    String goal = "abced";

    // TC:  O(N^2) since generating N rotations and each comparison takes O(N) time. and SC: O(N) for the space needed to store each rotated string.
    System.out.println("Is String rotated: " + bruteForce(str, goal));

    // TC: O(N), because checking for a substring in s + s is linear in time. and SC: O(N) for the space needed to store the concatenated string s + s.
    System.out.println("Is String rotated: " + optimal(str, goal));
  }

  public static boolean bruteForce(String str, String goal) {

    for (int i = 0; i < str.length(); i++) {
      // Make a rotated string from str starting from ith index to end index + then concat from 0 to ith index.
      String rotatedString = str.substring(i, str.length()) + str.substring(0, i);

      if(rotatedString.equals(goal)) {
        return true;
      }
    }

    return false;
  }

  public static boolean optimal(String str, String goal) {
    // Can fail for input like str = "aa" and goal = "a"
    // In this case it is not a rotated string as their length should be equals
    if(str.length() != goal.length()) {
      return false;
    }

    String duplicateDouble = str + str;

    return duplicateDouble.contains(goal);
  }

}
