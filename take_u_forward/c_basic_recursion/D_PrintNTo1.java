package take_u_forward.c_basic_recursion;

public class D_PrintNTo1 {

  public static void main(String[] args) {
    int n = 5;

    System.out.println("Printing numbers from N to 1 using recursion:");
    printNTo1(n);

    System.out.println("\nPrinting numbers from N to 1 using backtracking:");
    printNTo1BackTracking(n, 1);
  }

  public static void printNTo1(int n) {
    /*
    * Here, the number is printed first, and then the function calls itself with
    *
    * f(1)
    * f(2)
    * f(3)
    * f(4)
    * f(5)
    * consider above as a stack
    *
    * Here, nothing will be executed when function is pop from the stack.
    * As there is no pending operation after the function call.
    * And the n is getting printed before pushing the function call into the stack.
    * Hence, we are able to print count in 5,4,3,2,1 order.
    * */
    if(n == 0) {
      return;
    }

    System.out.println("" + n);
    printNTo1(n - 1);
  }

  public static void printNTo1BackTracking(int n, int count) {
    /*
     * Here, the function calls itself first, and then the number is printed.
     *
     * f(1, 5)
     * f(2, 4)
     * f(3, 3)
     * f(4, 2)
     * f(5, 1)
     * consider above as a stack
     * */
    if(n == 0) {
      return;
    }

    printNTo1BackTracking(n - 1, count + 1);
    System.out.println("" + count);
  }
}
