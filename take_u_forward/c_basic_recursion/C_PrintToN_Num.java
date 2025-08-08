package take_u_forward.c_basic_recursion;

public class C_PrintToN_Num {

  public static void main(String[] args) {
    System.out.println("Printing numbers from 1 to N using recursion:");
    printToNRecursion(5, 1);

    System.out.println("\nPrinting numbers from 1 to N using backtracking:");
    printToNBackTracking(5);
  }

  public static void printToNRecursion(int n, int count) {
    /*
     * Here, the number is printed first, and then the function calls itself with
     *
     * f(1, 5)
     * f(2, 4)
     * f(3, 3)
     * f(4, 2)
     * f(5, 1)
     * consider above as a stack
     *
     * Here, nothing will be executed when function is pop from the stack.
     * As there is no pending operation after the function call.
     * And the count is getting printed before pushing the function call into the stack.
     * Hence, we are able to print count in 1,2,3,4,5 order.
     * */
    if(n == 0) {
      return;
    }

    System.out.println("" + count);
    printToNRecursion(n - 1, count + 1);
  }

  public static void printToNBackTracking(int n) {
    /*
     * Here, the function calls itself first, and then the number is printed.
     *
     * f(1)
     * f(2)
     * f(3)
     * f(4)
     * f(5)
     * consider above as a stack
     * */
    if(n == 0) {
      return;
    }

    printToNBackTracking(n - 1);
    System.out.println("" + n);
  }
}
