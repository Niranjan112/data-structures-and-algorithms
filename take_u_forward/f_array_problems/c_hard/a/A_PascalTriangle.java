package take_u_forward.f_array_problems.c_hard.a;

import java.util.ArrayList;
import java.util.List;
import take_u_forward.c_basic_recursion.F_Factorial;

public class A_PascalTriangle {

  public static void main(String[] args) {
    /*
     *
     * 118. Pascal's Triangle
     * Problem Link: https://leetcode.com/problems/pascals-triangle/description/
     *
     * For detailed explanation check TUF
     * */

    approach1(5, 3); // TC: O( r * c * (r-c))) and SC: O(1)
    System.out.println("Element: " + approach1Optimized(5, 3)); // TC: O(col) and SC: O(1)

    approach2(6);
    approach2Optimized(6);

    approach3(6);
    approach3ForLeetCodeProblem(6);
  }

  public static void approach1(int row, int col) {
    // Solution when asked to return a number present at row and col in Pascal Triangle.

    // Note: For visual explanation check approach_1_exp.jpg

    row = row - 1;
    col = col - 1;
    long numerator = F_Factorial.factorialFunctionalWay(row);
    long denominator1 = F_Factorial.factorialFunctionalWay(col);
    long denominator2 = F_Factorial.factorialFunctionalWay(row - col);

    long ans = numerator / ( (denominator1) * (denominator2) );

    System.out.println("Element: " + ans);
  }

  public static long approach1Optimized(int row, int col) {
    // Solution when asked to return a number present at row and col in Pascal Triangle.

    // Note: For visual explanation check approach1_optimized_exp.jpg

    row = row - 1;
    col = col - 1;

    long ans = 1;

    for (int i = 0; i < col; i++) {
      ans = ans * (row - i);
      ans = ans / (i + 1);
    }

    return ans;
  }

  public static void approach2(int row) {
    // Solution when asked to print row of Pascal Triangle

    /*
    * We can use approach1Optimized() where we can get element of all row and column of Pascal Triangle.
    * So for a row we iterate over all column get value at row and column from approach1Optimized()
    * Note: length of row will be equal to row number.
    * So we can run loop from 1 to row number
    * */
    for (int i = 1; i <= row; i++) {
      System.out.print(approach1Optimized(row, i) + " ");
    }
  }

  public static void approach2Optimized(int row) {
    // Solution when asked to print row of Pascal Triangle

    // Note: For visual explanation check approach_2_optimized.jpg

    long ans = 1;
    System.out.println();
    System.out.print(ans + " "); // We know that Pascal Triangle row always start with number 1.

    // Starting from col index 1 as col index 0 we already printed above.
    for (int i = 1; i < row; i++) {
      ans = ans * (row - i);
      ans = ans / i;

      System.out.print(ans + " ");
    }
  }

  public static void approach3(int row) {
    // Solution when asked to print Pascal Triangle till n row.

    for (int i = 0; i < row; i++) {
      approach2Optimized(i + 1); // This function is already printed row when given row number following 1 based indexing.
    }
  }

  public static void approach3ForLeetCodeProblem(int totalRows) {
    // Solution when asked to generate Pascal Triangle till n row in list.

    List<List<Long>> pascalTriangle = new ArrayList<>();

    // Iterate for all row following 1 based indexing
    for (int rowNumber = 1; rowNumber <= totalRows; rowNumber++) {
      long ans = 1;

      List<Long> pascalTriangleRow = new ArrayList<>();
      pascalTriangleRow.add(ans);

      // Iterate all column following 0 based index but start from 1 as we already added for index 0 above.
      // As first number will always be 1 and colIndex 0
      for (int colIndex = 1; colIndex < rowNumber; colIndex++) {
        ans = ans * (rowNumber - colIndex);
        ans = ans / colIndex;

        pascalTriangleRow.add(ans);
      }

      pascalTriangle.add(pascalTriangleRow);
    }

    System.out.println();
    System.out.print(pascalTriangle);
  }
}
