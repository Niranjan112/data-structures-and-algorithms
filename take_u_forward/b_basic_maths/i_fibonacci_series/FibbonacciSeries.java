package take_u_forward.b_basic_maths.i_fibonacci_series;

public class FibbonacciSeries {

  public static void main(String[] args) {
    int n = 6;

    System.out.println("Fibonacci series up to " + n + " terms:");
    printFibonacciSeries1(n);
    System.out.println();
    printFibonacciSeries2(n);
  }

  public static void printFibonacciSeries1(int n) {
    if(n == 0) {
      System.out.print(0);
      return;
    }

    int secondLastSum = 0;
    int lastSum = 1;

    System.out.print(secondLastSum + " " + lastSum + " ");
    for (int i = 0; i <= n-2; i++) {
      int currentSum = secondLastSum + lastSum;
      secondLastSum = lastSum;
      lastSum = currentSum;

      System.out.print(currentSum + " ");
    }
  }

  public static void printFibonacciSeries2(int n) {
    int secondLastSum = 0;
    int lastSum = 1;

    for (int i = 0; i <= n; i++) {
      System.out.print(secondLastSum + " ");

      int currentSum = secondLastSum + lastSum;
      secondLastSum = lastSum;
      lastSum = currentSum;
    }
  }
}
