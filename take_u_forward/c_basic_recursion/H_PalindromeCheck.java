package take_u_forward.c_basic_recursion;

public class H_PalindromeCheck {

  public static void main(String[] args) {
    String[] strings = {"madam", "racecar", "hello", "level", "world", "121"};

    for (String string : strings) {
      System.out.println(
          "Is \"" + string + "\" a palindrome? " + isPalindrome(string, 0, string.length() - 1)
      );
    }

    // Time complexity: O(n/2)
  }

  public static boolean isPalindrome(String str, int startIndex, int endIndex) {
    /*
    * This function is checking palindrome only in case of lowercase letters/digit/symbols.
    * If you want to check for uppercase letters as well, then you can convert the string to lowercase
    * and then check.
    *
    * Only convert to lowercase when the characters are not digits/symbol.
    * */
    if(startIndex > endIndex) {
      return true;
    } else if (str.charAt(startIndex) != str.charAt(endIndex)) {
      return false;
    }

    return isPalindrome(str, startIndex + 1, endIndex - 1);
  }
}
