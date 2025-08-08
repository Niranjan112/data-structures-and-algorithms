package take_u_forward.c_basic_recursion;

public class B_PrintNameNTimes {

  public static void main(String[] args) {
    printNameNTimes("Niranjan", 5);
  }

  public static void printNameNTimes(String name, int n) {
    if(n == 0) {
      return;
    }

    System.out.println(name);
    printNameNTimes(name, n - 1);
  }
}
