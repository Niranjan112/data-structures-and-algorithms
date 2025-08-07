package take_u_forward.b_basic_maths.d_gcd_or_hcf;

public class GCD {

  public static void main(String[] args) {
    System.out.println("Greatest Common Divisor (GCD): " + bruteForceGCD(12, 32));
    System.out.println("Greatest Common Divisor (GCD): " + betterApproachGCD(12, 32));
    System.out.println("Greatest Common Divisor (GCD): " + optimalApproachGCD(12, 32));
    System.out.println("Greatest Common Divisor (GCD) Recursive: " + optimalApproachGCDRecursive(12, 32));
  }

  public static int bruteForceGCD(int a, int b) {
    int lowestNumber = Math.min(a, b);
    int gcd = 1;

    /*
    * Iterate from 1 to the lowest number
    * and check if both numbers are divisible by the current number.
    * If they are, update the gcd variable.
    * This will ensure that we find the greatest common divisor.
    * */
    for (int i = 1; i <= lowestNumber; i++) {
      if (a % i == 0 && b % i == 0) {
        gcd = i;
      }
    }

    return gcd;
  }

  public static int betterApproachGCD(int a, int b) {
    int minNumber = Math.min(a,b);

    /*
    * Iterate from the minimum number down to 2
    * and check if both numbers are divisible by the current number.
    * The first number that divides both a and b will be the GCD.
    * This is more efficient than checking all numbers up to the minimum.
    *
    * If we found no common divisor greater than 1,
    * we return 1 as the GCD.
    * */
    for(int i = minNumber; i > 1; i--) {
      if(a % i == 0 && b % i == 0) {
        return i;
      }
    }

    return 1; // If no common divisor found, return 1
  }

  public static int optimalApproachGCD(int a, int b) {
    // Using Euclidean algorithm for optimal GCD calculation
    /*
    * So the Euclidean algorithm works by placing the larger number in x
    * and the smaller number in y.
    * Then we repeatedly replace y as the remainder of x divided by y
    * until y becomes 0.
    * At that point, x will be the GCD of the two numbers.
    * This is a very efficient way to find the GCD.
    *
    * For example:
    * GCD(12, 32)
    * x = 32, y = 12
    * 32 % 12 = 8 (y becomes 8)
    * 12 % 8 = 4 (y becomes 4)
    * 8 % 4 = 0 (y becomes 0)
    * Now y is 0, so the GCD is 4 (x).
    * */

    int x = Math.max(a, b); // Ensure x is the larger number
    int y = Math.min(a, b); // Ensure y is the smaller number
    int temp; // Temporary variable to hold the value of y

    while(y != 0) {
      temp = y;
      y = x % y; // Update y as the remainder of x divided by y
      x= temp; // Update b to the previous value of a
    }

    return x; // When y becomes 0, x is the GCD
  }

  public static int optimalApproachGCDRecursive(int a, int b) {

    if(b == 0) {
      return a;
    }

    return optimalApproachGCDRecursive(b, a % b); // Recursive call with b and the remainder of a divided by b
  }
}
