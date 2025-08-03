package take_u_forward.b_basic_maths.c_palindrome;

public class PalindromeNumberCheckOptimal {

  public static void main(String[] args) {
    // Leet Code Problem: https://leetcode.com/problems/palindrome-number/description/

    /*
    * Example 1:
    * Input: x = 121
    * Output: true
    * Explanation: 121 reads as 121 from left to right and from right to left.
    *
    * Exmaple 2:
    * Input: x = -121
    * Output: false
    * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
    *
    * Example 3:
    * Input: x = 10
    * Output: false
    * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
    * */

    System.out.println("Is Palindrome: " + isPalindrome(121)); // true
    System.out.println("Is Palindrome: " + isPalindrome(-121)); // false
    System.out.println("Is Palindrome: " + isPalindrome(10)); // false
    System.out.println("Is Palindrome: " + isPalindrome(12321)); // true
    System.out.println("Is Palindrome: " + isPalindrome(123321)); // true

  }

  public static boolean isPalindrome(int x) {
    // If x is negative or ends with 0 (but isn't 0), it can't be a palindrome
    if (x < 0 || (x % 10 == 0 && x != 0)) {
      return false;
    }

    int lastDigit = 0;
    int reversedHalf = 0;
    /*
    * Example input: 12321 (odd length palindrome)
    * Iteration 1:
    *   lastDigit = 1
    *   reversedHalf = 1
    *   x = 1232
    * Iteration 2:
    *   lastDigit = 2
    *   reversedHalf = 12
    *   x = 123
    * Iteration 3:
    *   lastDigit = 3
    *   reversedHalf = 123
    *   x = 12
    * Now, x (12) is less than reversedHalf (123), so loop will stop here.
    * As it is an odd length palindrome, reversedHalf / 10 will ignore the middle digit (3 in this case).
    * So actual comparison will be [x (12)] == [reversedHalf(123) / 10 -> 12].
    *
    * Example input: 123321 (even length palindrome)
    * Iteration 1:
    *   lastDigit = 1
    *   reversedHalf = 1
    *   x = 12332
    * Iteration 2:
    *   lastDigit = 2
    *   reversedHalf = 12
    *   x = 1233
    * Iteration 3:
    *   lastDigit = 3
    *   reversedHalf = 123
    *   x = 123
    * Now, x (123) become same as reversedHalf (123), so loop will stop here.
    * We can directly compare as in even length we are not require to ignore middle.
    * As it is an even length palindrome, it can be compared as [x (123)] == [reversedHalf (123)].
    * */
    while (x > reversedHalf) {
      lastDigit = x % 10; // Get the last digit of the number
      reversedHalf = reversedHalf * 10 + lastDigit;
      x /= 10;
    }

    // x is equal to reversedHalf (for even length) or reversedHalf without the middle digit (for odd length numbers)
    return x == reversedHalf || x == reversedHalf / 10;
  }
}
