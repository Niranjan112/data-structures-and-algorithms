package take_u_forward.b_basic_maths.c_palindrome;

public class PalindromeNumberCheck {

  public static void main(String[] args) {
    int n = 4554;
    int originalNumber = n; // Store the original number to compare later
    int lastDigit = 0;
    int reversedNumber = 0;

    while(n > 0) {
      lastDigit = n % 10; // Get the last digit of the number
      reversedNumber *= 10; // Get 0 appended at the end of reversedNumber by multiplying by 10
      reversedNumber += lastDigit; // Add the last digit to the reversedNumber and as in above step 0 appended at the end

      n /= 10; // Remove the last digit from n
    }

    if(originalNumber == reversedNumber) {
      System.out.println("The number is a palindrome.");
    } else {
      System.out.println("The number is not a palindrome.");
    }
  }
}
