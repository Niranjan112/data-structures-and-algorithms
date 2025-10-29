package take_u_forward.g_binary_search.a_one_dimensional_array.b;

public class B_LowerBound {

  public static void main(String[] args) {
    /*
     *
     * Implement Lower Bound
     * Problem Link: https://takeuforward.org/arrays/implement-lower-bound-bs-2/
     *
     * For detailed explanation check TUF
     * */

    int[] arr = {3,5,8,15,19};

    System.out.println("[BruteForceApproach] Lower Bound Index: " + bruteForceApproach(arr, 9)); // TC: O(n) and SC: O(1)
    System.out.println("[OptimalApproach] Lower Bound Index: " + optimalApproach(arr, 9)); // TC: O(log n) and SC: O(1)

  }

  public static int bruteForceApproach(int[] arr, int x) {
    for (int i = 0; i < arr.length; i++) {
      if(arr[i] >= x) {
        return i;
      }
    }

    return arr.length; // If x is greater than last element of array then simply return arr.length as it is out of array
  }

  public static int optimalApproach(int[] arr, int x) {
    int low = 0;
    int high = arr.length - 1;

    // If x is greater than last element of array then simply return arr.length as it is out of array, and we found no element like that.
    int ansIndex = arr.length;

    while (low <= high) {
      int mid = (low + high) / 2;

      if(arr[mid] >= x) { // If arr[mid] is greater than or equal to x then move to left part of array to get lowest greater element than x
        high = mid - 1;
        ansIndex = mid;
      }
      // If arr[mid] is less than x then move to right part of array to get lowest greater element than x.
      else { // arr[mid] < x
        low = mid + 1;
      }
    }

    return ansIndex;
  }
}
