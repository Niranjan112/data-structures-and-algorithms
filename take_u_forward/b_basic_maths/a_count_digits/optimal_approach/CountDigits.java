package take_u_forward.b_basic_maths.a_count_digits.optimal_approach;

public class CountDigits {

  public static void main(String[] args) {
    int n = 5657778;

    /*
    * log10 result in what power number could be used to reach n
    * For example, log10(1000) = 3, which means 10^3 = 1000
    * log10 could give number as point number.
    * So ignore the point number and add 1 to get the count of digits.
    * Converting log10 result to int will ignore the point number.
    * */
    int count = (int) Math.log10(n) + 1;

    System.out.println("Number of Digits: " + count);
  }

}
