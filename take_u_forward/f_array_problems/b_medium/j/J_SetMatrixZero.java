package take_u_forward.f_array_problems.b_medium.j;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class J_SetMatrixZero {

  public static void main(String[] args) {

    /*
     *
     * 73. Set Matrix Zeroes
     * Problem Link: https://leetcode.com/problems/set-matrix-zeroes/description/
     *
     * For detailed explanation check TUF
     * */

    bruteForceApproach(new int[][] { {1,1,1}, {1,0,1}, {1,1,1} }); // TC: O((N * M) * (N + M)) + O(N * M) & SC: O(1)
    betterApproach(new int[][] { {1,1,1}, {1,0,1}, {1,1,1} }); // TC: O(2 * (N * M)) & SC: O(N + M)
    optimalApproach(new int[][] { {1,1,1}, {1,0,1}, {1,1,1} }); // TC: O(2*(N*M)) & SC: O(1)
  }

  public static void bruteForceApproach(int[][] matrix) {
    // This solution will only work assuming there will never be -1 in matrix initially.

    /*
    * Iterate over all row and col and wherever you find 0.
    * Mark the other number of that row and col as -1.
    * */
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {
        if(matrix[row][col] == 0) {
          markRow(matrix, row); // Mark only numbers in this row as -1 which are not 0
          markCol(matrix, col); // Mark only numbers in this column as -1 which are not 0
        }
      }
    }

    /*
    * Now here replace all -1 to 0.
    * */
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {
        if(matrix[row][col] == -1) {
          matrix[row][col] = 0;
        }
      }
    }

    System.out.println("\nUpdated Matrix:");
    for (int[] row: matrix) {
      System.out.println(Arrays.toString(row));
    }
  }

  private static void markRow(int[][] matrix, int row) {
    for (int col = 0; col < matrix[row].length; col++) {
      if(matrix[row][col] != 0) {
        matrix[row][col] = -1;
      }
    }
  }

  private static void markCol(int[][] matrix, int col) {
    for (int row = 0; row < matrix.length; row++) {
      if(matrix[row][col] != 0) {
        matrix[row][col] = -1;
      }
    }
  }

  public static void betterApproach(int[][] matrix) {
    // Using set to store row and column index which has 0
    Set<Integer> rows = new HashSet<>();
    Set<Integer> columns = new HashSet<>();

    /*
    * Iterate over all row and col index and
    * store row and col index which have 0
    * */
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {
        if(matrix[row][col] == 0) {
          rows.add(row);
          columns.add(col);
        }
      }
    }

    /*
    * Extract all rows index from set and set all column to 0
    * */
    for (int rowIndex: rows) {
      for (int i = 0; i < matrix[rowIndex].length; i++) {
        matrix[rowIndex][i] = 0;
      }
    }

    /*
     * Extract all column index from set and set all row to 0
     * */
    for (int columnIndex: columns) {
      for (int i = 0; i < matrix.length; i++) {
        matrix[i][columnIndex] = 0;
      }
    }

    System.out.println("\nUpdated Matrix:");
    for (int[] row: matrix) {
      System.out.println(Arrays.toString(row));
    }
  }

  public static void optimalApproach(int[][] matrix) {
    // Note: For visual explanation, check J_set_matrix_to_zero_optimal.jpg in same package

    int col0 = 1;

    /*
    * Here instead of using separate space like set to track row and column containing zero.
    * We will use 0th column and 0th row only to keep the tracking.
    *
    * Iterate over each row/column.
    * If you find 0 at matrix[row][column] then update 0th row with current column and 0th column with current row.
    * Make sure when current column index is 0 then update var col0 to 0 as we don't want to change in matrix[0][0].
    * We are using a separate variable col0 for tracking if we found 0 at 0th col.
    * */
    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {
        if(matrix[row][col] == 0) {

          matrix[row][0] = 0;

          if(col != 0) {
            matrix[0][col] = 0;
          } else {
            col0 = 0;
          }
        }
      }
    }

    /*
    * Now here start from 1st row and 1st column and update all to zero.
    * According to the tracking stored in 0th row and 0th column.
    * */
    for (int row = 1; row < matrix.length; row++) {
      for (int col = 1; col < matrix[row].length; col++) {
        if(matrix[row][0] == 0 || matrix[0][col] == 0) {
          matrix[row][col] = 0;
        }
      }
    }

    // If matrix[0][0] was already 0 then mark 0th row to 0.
    if(matrix[0][0] == 0) {
      for (int col = 0; col < matrix[0].length; col++) {
        matrix[0][col] = 0;
      }
    }

    // Also just check if col0 becomes 0 if yes then mark all 0th col to 0.
    if(col0 == 0) {
      for (int row = 0; row < matrix.length; row++) {
        matrix[row][0] = 0;
      }
    }

    System.out.println("\nUpdated Matrix:");
    for (int[] row: matrix) {
      System.out.println(Arrays.toString(row));
    }
  }
}
