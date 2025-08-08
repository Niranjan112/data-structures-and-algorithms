package take_u_forward.c_basic_recursion;

public class A_PrintNTimes {

  public static void main(String[] args) {
    int n = 5;

    printNTimes(n);
  }

  public static void printNTimes(int n) {
    if(n == 0) {
      // Once function returns successfully, it will not execute any further code, and it will be exited from here completely.
      // And it will start popping the stack to execute pending function, and will execute the code after the function call.
      return;
    }

    // This is the forward part of the recursion.
    // This will be executed first, and then function is pushed onto the stack.
    System.out.println("Hello World - start " + n);

    // At this moment, function is pushed onto the stack with below pending execution for each call.
    printNTimes(n - 1);

    // When the function is popped from the stack, it will execute the below line.
    // This is the backtracking part of the recursion.
    System.out.println("Hello World - end " + n);
  }
}
