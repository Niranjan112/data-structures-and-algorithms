package take_u_forward.b_basic_maths.h_sum_of_first_n;

public class SumOfFirstN {

  public static void main(String[] args) {
    int n = 6;
    System.out.println("Sum of first " + n + " natural numbers is: " + bruteForceApproach(n));
    System.out.println("Sum of first " + n + " natural numbers is: " + optimaApproach(n));
  }

  public static int bruteForceApproach(int n) {
    int sum = 0;

    for(int i = 0; i <= n; i++) {
      sum += i;
    }

    return sum;
  }

  public static int optimaApproach(int n) {
    return ( n * ( n + 1 ) ) / 2;
  }
}
