package take_u_forward.b_basic_maths.g_prime_number;

public class PrimeNumberCheck {

  public static void main(String[] args) {
    int n1 = 29;
    int n2 = 15;

    System.out.println("Is " + n1 + " a prime number? " + bruteForceApproach(n1));
    System.out.println("Is " + n2 + " a prime number? " + optimalApproach(n2));
  }

  public static boolean bruteForceApproach(int n) {
    if (n < 2) {
      return false; // 0, 1, and negatives are not prime
    }

    for (int i = 2; i < n; i++) {
      if(n % i == 0) {
        return false;
      }
    }

    return true;
  }

  public static boolean optimalApproach(int n) {
    if (n < 2) {
      return false; // 0, 1, and negatives are not prime
    }

    int sqrtN = (int) Math.sqrt(n);

    for (int i = 2; i <= sqrtN; i++) {
      if(n % i == 0) {
        return false;
      }
    }

    return true;
  }
}
