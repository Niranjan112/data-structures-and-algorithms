package take_u_forward.g_binary_search.c_two_dimensional_array.b;

public class SearchInSorted2DMatrix {

  public static void main(String[] args) {
    int[][] matrix = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12} };
    int numToSearch = 8;

    System.out.println("Is number present ? " + bruteForce(matrix, numToSearch)); // TC: O(n * m) and SC: O(1)
    System.out.println("Is number present ? " + betterApproach(matrix, numToSearch)); // TC: O(n + log m) and SC: O(1)
    System.out.println("Is number present ? " + optimalApproach(matrix, numToSearch)); // TC: O(log(n + m)) and SC: O(1)
  }

  public static boolean bruteForce(int[][] matrix, int numToSearch) {

    for (int row = 0; row < matrix.length; row++) {
      for (int column = 0; column < matrix[row].length; column++) {

        if(matrix[row][column] == numToSearch) {
          return true;
        }
      }
    }

    return false;
  }

  public static boolean binarySearch(int[] arr, int numToSearch) {
    int low = 0;
    int high = arr.length - 1;

    while (low <= high) {
      int mid = (low + high) / 2;

      if(arr[mid] == numToSearch) {
        return true;
      } else if(arr[mid] > numToSearch) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return false;
  }

  public static boolean betterApproach(int[][] matrix, int numToSearch) {
    int rowIndexWhereNumIsPresent = -1; // To store the row index where number to search can be possibly found.

    // As matrix is sorted we will first find the row where number can be possibly exists.
    for (int row = 0; row < matrix.length; row++) {
      int rowLength = matrix[row].length;

      // If number to search is in between the first and end index of a row then mark that row index.
      if(numToSearch >= matrix[row][0] && numToSearch <= matrix[row][rowLength - 1]) {
        rowIndexWhereNumIsPresent = row;
      }
    }

    // If we found a row where number can be possibly exists then perform a binary search.
    if(rowIndexWhereNumIsPresent != -1) {
      return binarySearch(matrix[rowIndexWhereNumIsPresent], numToSearch);
    }

    // If we don't found a row index where number can be possibly exists then return false
    return false;
  }

  public static boolean optimalApproach(int[][] matrix, int numToSearch) {
    int rowLen = matrix.length;
    int colLen = matrix[0].length;

    int low = 0;
    int high = (rowLen * colLen) - 1;

    while (low <= high) {
      int mid = (low + high) / 2;

      int row = mid / colLen; // Calculate the actual row index of 2D array from our imagination 1D array mid index
      int col = mid % colLen; // Calculate the actual col index of 2D array from our imagination 1D array mid index

      if(matrix[row][col] == numToSearch) {
        return true;
      } else if(matrix[row][col] > numToSearch) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return false;
  }
}
