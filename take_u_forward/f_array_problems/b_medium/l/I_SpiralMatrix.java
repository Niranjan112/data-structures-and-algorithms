package take_u_forward.f_array_problems.b_medium.l;

import java.util.ArrayList;
import java.util.List;

public class I_SpiralMatrix {

  public static void main(String[] args) {
    /*
     *
     * 54. Spiral Matrix
     * Problem Link: https://leetcode.com/problems/spiral-matrix/description/
     *
     * For detailed explanation check TUF
     * */

    int[][] matrix = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15,16} }; // TC: O(m * n) and SC: O(n)

    printSpiral(matrix);
  }

  public static void printSpiral(int[][] matrix) {
    // Note: For visual explanation check Spiral matrix.jpg in same package

    List<Integer> spiralData = new ArrayList<>();

    int top = 0, left = 0;
    int right = matrix[0].length - 1;
    int bottom = matrix.length - 1;

    while (top <= bottom && left <= right) {

      // Moving left to right considering Top as your row
      for (int i = left; i <= right; i++) {
        spiralData.add(matrix[top][i]);
      }
      top++;

      // Move top to bottom considering Right as your column
      for (int i = top; i <= bottom; i++) {
        spiralData.add(matrix[i][right]);
      }
      right--;

      // Move left to right considering Bottom as your row
      if(top <= bottom) {
        for (int i = right; i >= left; i--) {
          spiralData.add(matrix[bottom][i]);
        }
        bottom--;
      }

      // Move bottom to top considering Left as your column
      if(left <= right) {
        for (int i = bottom; i >= top; i--) {
          spiralData.add(matrix[i][left]);
        }
        left++;
      }
    }

    System.out.println("Spiral data: " + spiralData);
  }
}
