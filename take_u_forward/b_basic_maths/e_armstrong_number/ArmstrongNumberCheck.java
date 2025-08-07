package take_u_forward.b_basic_maths.e_armstrong_number;

public class ArmstrongNumberCheck {

  public static void main(String[] args) {
    /*
    * An Amrstrong number is a number that is equal to the sum of its own digits each raised to the power of the number of digits.
    * For example, 153 is an Armstrong number because:
    * 1^3 + 5^3 + 3^3 = 1 + 125 + 27 = 153
    * */

    int number = 153;
    int originalNumber = number; // Store the original number for comparison later
    int count = (int) Math.log10(number) + 1; // Count the number of digits in the number
    int sum =  0;

    int lastDigit;
    while (number > 0) {
      lastDigit = number % 10;
      sum += (int) Math.pow(lastDigit, count);

      number /= 10; // Remove the last digit from the number
    }

    if (sum == originalNumber) {
      System.out.println("The number is an Armstrong number.");
    } else {
      System.out.println("The number is not an Armstrong number.");
    }
  }

}
