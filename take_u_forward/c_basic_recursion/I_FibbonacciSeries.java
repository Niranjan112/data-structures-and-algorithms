package take_u_forward.c_basic_recursion;

public class I_FibbonacciSeries {

  public static void main(String[] args) {
    int n = 10;

    System.out.println("Fibonacci series up to " + n + " terms:");
    fibbonacciSeries(n, 0, 1);
  }

  public static void fibbonacciSeries(int n, int secondLastSum, int lastSum) {
    if(n == -1) {
      return;
    }

    System.out.print(secondLastSum + " ");
    fibbonacciSeries(n - 1, lastSum, secondLastSum + lastSum);
  }
}
