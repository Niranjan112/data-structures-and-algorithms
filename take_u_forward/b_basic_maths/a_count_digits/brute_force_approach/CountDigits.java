package take_u_forward.b_basic_maths.a_count_digits.brute_force_approach;

public class CountDigits {

  public static void main(String[] args) {
    int n = 89011;
    int count = 0;

    while(n > 0) {
      n = n / 10;
      count++;
    }

    System.out.println("Number of Digits: " + count);

  }

}
