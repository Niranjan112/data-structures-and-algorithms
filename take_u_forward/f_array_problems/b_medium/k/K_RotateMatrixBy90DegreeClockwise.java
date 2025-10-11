package take_u_forward.f_array_problems.b_medium.k;

import java.util.Arrays;

public class K_RotateMatrixBy90DegreeClockwise {

  public static void main(String[] args) {

    bruteForceApproach(new int[][] { {1,2,3}, {4,5,6}, {7,8,9} });
    optimalApproach(new int[][] { {5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16} });
  }

  public static void bruteForceApproach(int[][] matrix) {
    int[][] rotatedMatrix = new int[matrix.length][matrix[0].length]; // To store values of rotated matrix by 90 degree.

    int rotateMatrixColIndex = 0; // Incremental col index for putting value in rotated matrix.

    /*
    * Starting from last row and putting as first, second,... colum in rotatedMatrix.
    * */
    for (int row = matrix.length - 1; row >= 0; row--) {

      for(int col = 0; col < matrix[row].length; col++) {
        int rotateMatrixRowIndex = col; // Use column index of matrix as a row index in rotated matrix.
        rotatedMatrix[rotateMatrixRowIndex][rotateMatrixColIndex] = matrix[row][col];
      }

      rotateMatrixColIndex++;
    }

    System.out.println("\nRotated Matrix:");
    for (int[] row: rotatedMatrix) {
      System.out.println(Arrays.toString(row));
    }
  }

  public static void optimalApproach(int[][] matrix) {

    /*
    * Transpose the matrix
    * */
    for (int row = 0; row < matrix.length - 1; row++) {
      for (int col = row + 1; col < matrix[row].length; col++) {

        if(row != col) {
          int temp = matrix[row][col];
          matrix[row][col] = matrix[col][row];
          matrix[col][row] = temp;
        }

      }
    }

    System.out.println("\nTranspose Matrix:");
    for (int[] row: matrix) {
      System.out.println(Arrays.toString(row));
    }

    /*
    * After transposing the matrix.
    * Now just reverse each row of matrix to get the 90 degree rotated matrix.
    * */
    for (int[] row: matrix) {
      int i = 0;
      int j = row.length - 1;

      while(i < j) {
        int temp = row[i];
        row[i] = row[j];
        row[j] = temp;

        i++;
        j--;
      }
    }

    System.out.println("\nRotated Matrix:");
    for (int[] row: matrix) {
      System.out.println(Arrays.toString(row));
    }
  }
}
