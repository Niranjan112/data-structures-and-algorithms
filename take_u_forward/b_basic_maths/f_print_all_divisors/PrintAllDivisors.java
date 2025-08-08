package take_u_forward.b_basic_maths.f_print_all_divisors;

import java.util.ArrayList;
import java.util.List;

public class PrintAllDivisors {

  public static void main(String[] args) {
    int n = 36;
    System.out.println("Divisors of " + n + ": " + bruteForce(n));
    System.out.println("Divisors of " + n + " (Optimal): " + optimalApproach(n));
  }

  public static List<Integer> bruteForce(int n) {

    ArrayList<Integer> divisors = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      if(n % i == 0) {
        divisors.add(i);
      }
    }

    return divisors;
  }

  public static List<Integer> optimalApproach(int n) {
    /*
    * For explanation, refer to the image in the same package img.png
    * */

    int sqrtN = (int) Math.sqrt(n);

    ArrayList<Integer> divisors = new ArrayList<>();
    for (int i = 1; i <= sqrtN; i++) {
      if(n % i == 0) {
        divisors.add(i);

        if(i != sqrtN) {
          divisors.add(n / i);
        }
      }
    }

    return divisors;
  }
}
