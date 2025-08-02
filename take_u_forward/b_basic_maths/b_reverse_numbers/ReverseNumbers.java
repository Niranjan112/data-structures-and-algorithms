package take_u_forward.b_basic_maths.b_reverse_numbers;

public class ReverseNumbers {

  public static void main(String[] args) {

    int n = 12345;
    int reversedNumber = 0;
    int lastDigit = 0;

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

    System.out.println("Reversed Number: " + reversedNumber);
  }
}
