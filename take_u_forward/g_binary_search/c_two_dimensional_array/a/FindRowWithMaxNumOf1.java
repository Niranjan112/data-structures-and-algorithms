package take_u_forward.g_binary_search.c_two_dimensional_array.a;

public class FindRowWithMaxNumOf1 {

  public static void main(String[] args) {
    int[][] matrix = { {0, 0, 1, 1, 1}, {0, 0, 0, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {0, 1, 1, 1, 1} };

    bruteForce(matrix); // TC: O(n * m) and SC: O(1)
    optimalApproach(matrix); // O(n * log m )  and SC: O(1)
  }

  public static void bruteForce(int[][] matrix) {
    int maxIndex = -1; // var to store row index with max num of 1
    int maxCountOf1 = 0; // var to track max num of 1 for every row

    for (int row = 0; row < matrix.length; row++) {
      int countOf1 = 0;

      for (int column = 0; column < matrix[row].length; column++) {

        if(matrix[row][column] == 1) {
          countOf1++;
        }
      }

      // If countOf1 for current row is bigger than update maxIndex and max count as well
      if(countOf1 > maxCountOf1) {
        maxIndex = row;
        maxCountOf1 = countOf1;
      }
    }

    System.out.println("Row index with max count of 1: " + maxIndex);
  }

  public static int lowerBoundUsingBinarySearch(int[] arr, int x) {
    int low = 0;
    int high = arr.length - 1;

    // If x is greater than last element of array then simply return arr.length as it is out of array, and we found no element like that.
    int ansIndex = arr.length;

    while (low <= high) {
      int mid = (low + high) / 2;

      if(arr[mid] >= x) { // If arr[mid] is greater than or equal to x then move to left part of array to get lowest greater element than x
        ansIndex = mid; // This index can be an answer so just update ansIndex.
        high = mid - 1;
      }
      // If arr[mid] is less than x then move to right part of array to get lowest greater element than x.
      else { // arr[mid] < x
        low = mid + 1;
      }
    }

    return ansIndex;
  }

  public static void optimalApproach(int[][] matrix) {
    int maxIndex = -1; // var to store row index with max num of 1
    int maxCountOf1 = 0; // var to track max num of 1 for every row

    for (int row = 0; row < matrix.length; row++) {

      // As row are sorted below function will return first occurrence of 1 index from row.
      // Then we can get the count by subtracting it from row length.
      int countOf1 = matrix[row].length - lowerBoundUsingBinarySearch(matrix[row], 1);

      // If countOf1 for current row is bigger than update maxIndex and max count as well
      if(countOf1 > maxCountOf1) {
        maxIndex = row;
        maxCountOf1 = countOf1;
      }
    }

    System.out.println("Row index with max count of 1: " + maxIndex);
  }
}
