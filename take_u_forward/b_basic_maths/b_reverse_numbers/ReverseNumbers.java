package take_u_forward.b_basic_maths.b_reverse_numbers;

public class ReverseNumbers {

  public static void main(String[] args) {

    System.out.println("Reversed Number: " + reverseNumber(-123345));
    System.out.println("Reversed Number with Overflow Check: " + reverseNumberWithIntegerOverflowCheck(1534236469));
  }

  public static int reverseNumber(int n) {
    int reversedNumber = 0;
    int lastDigit = 0;

    // Handle negative numbers by remembering the sign
    int sign = n < 0 ? -1 : 1;
    n = Math.abs(n); // Work with the absolute value for reversal

    /*
     * Example:
     * 12345 % 10 -> 5
     * 5 * 10 -> 50
     * 50 + 4 -> 54
     * 54 * 10 -> 540
     * 540 + 3 -> 543
     * 543 * 10 -> 5430
     * 5430 + 2 -> 5432
     * 5432 * 10 -> 54320
     * 54320 + 1 -> 54321
     * 54321 is the reversed number
     * */
    while(n > 0) {
      lastDigit = n % 10; // Get the last digit of the number
      reversedNumber *= 10; // Get 0 appended at the end of reversedNumber by multiplying by 10
      reversedNumber += lastDigit; // Add the last digit to the reversedNumber and as in above step 0 appended at the end

      n /= 10; // Remove the last digit from n
    }

    return reversedNumber * sign; // Return the reversed number with the original sign
  }

  public static int reverseNumberWithIntegerOverflowCheck(int n) {
    int lastDigit = 0;
    int reversedNumber = 0;

    // Handle negative numbers by remembering the sign
    int sign = n < 0 ? -1 : 1;
    n = Math.abs(n); // Work with the absolute value for reversal

    while (n > 0) {
      lastDigit = n % 10;


      // Check for overflow before multiplying and adding
      // Check integer-overflow-explanation.txt in same folder for more details
      if (reversedNumber > Integer.MAX_VALUE / 10 ||
          (reversedNumber == Integer.MAX_VALUE / 10 && lastDigit > 7)) {
        return 0; // Return 0 if overflow would occur
      }

      reversedNumber *= 10;
      reversedNumber += lastDigit;
      n /= 10;
    }

    // Apply the sign back to the reversed number
    return reversedNumber * sign;
  }
}
