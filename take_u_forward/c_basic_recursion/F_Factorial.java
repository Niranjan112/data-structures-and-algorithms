package take_u_forward.c_basic_recursion;

public class F_Factorial {

  public static void main(String[] args) {
    /*
    * Example of factorial calculation,
    * If n = 5
    * 1 * 2 * 3 * 4 * 5 = 120
    *
    * Visual explanation of main logic is same as sum of first n numbers in e section.
    * */

    int n = 5;
    System.out.println("Factorial of " + n + " is: " + factorialFunctionalWay(n));
    System.out.println("Factorial of " + n + " is: " + factorialParameterizedWay(n, 1));
  }

  public static int factorialFunctionalWay(int n) {
    if(n == 0) {
      return 1;
    }

    return n * factorialFunctionalWay(n - 1);
  }

  public static int factorialParameterizedWay(int n, int result) {
    if(n == 0) {
      return result;
    }

    return factorialParameterizedWay(n - 1, result * n);
  }

}
