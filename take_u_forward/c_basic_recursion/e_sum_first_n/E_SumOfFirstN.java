package take_u_forward.c_basic_recursion.e_sum_first_n;

public class E_SumOfFirstN {

  public static void main(String[] args) {
    int n = 5;
    System.out.println("Sum of first " + n + " natural numbers is: " + sumOfFirstNParameterizedWay(n, 0));
    System.out.println("Sum of first " + n + " natural numbers is: " + sumOfFirstNFunctionalWay(n));

  }

  public static int sumOfFirstNParameterizedWay(int n, int sum) {
    /*
    * Initially, function will be pushed to stack in below way:
    * f(0, 15)
    * f(1, 1 + 14)
    * f(2, 2 + 12)
    * f(3, 3 + 9)
    * f(4, 4 + 5)
    * f(5, 5)
    *
    * Once n becomes 0, that sum value will be 15 (1 + 14) and return sum (15).
    * Now 15 will be returned to previous function call and so on.
    * And at the end, 15 will be returned to main function.
    * For visualization, you can refer to the image in the repository.
    * */
    if(n == 0) {
      return sum;
    }

    return sumOfFirstNParameterizedWay(n - 1, sum + n);
  }

  public static int sumOfFirstNFunctionalWay(int n) {
    /*
     * Initially, function will be pushed to stack in below way:
     * 0 + f(0) = 0 + 0
     * 1 + f(1) = 1 + 0
     * 2 + f(2) = 2 + 1
     * 3 + f(3) = 3 + 3
     * 4 + f(4) = 4 + 6
     * 5 + f(5) = 5 + 10
     *
     * Once n becomes 0, then 0 will be return to previous function.
     * Now, the calculation will happen at each step and value will be returned to previous function call.
     * And at the end, 15 will be returned to main function.
     * For visualization, you can refer to the image in the repository.
     * */
    if(n == 0) {
      return 0;
    }

    return n + sumOfFirstNFunctionalWay(n - 1);
  }
}
