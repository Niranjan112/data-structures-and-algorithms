package take_u_forward.g_binary_search.b_answer.g;

public class KthMissingPositiveNumber {

  public static void main(String[] args) {
    int[] arr = {2, 3, 4, 7, 11};
    int k = 5;

    bruteForce(arr, k);
    optimalApproach(arr, k);
  }

  public static void bruteForce(int[] arr, int k) {
    for (int num: arr) {
      if(num <= k) {
        k++;
      } else {
        break;
      }
    }

    System.out.println("Missing Number: " + k);
  }

  public static void optimalApproach(int[] arr, int k) {
    int low = 0;
    int high = arr.length - 1;

    while (low <= high) {
      int mid = (low + high) / 2;

      int countOfMissingNumBefore = arr[mid] - (mid + 1); // Check for the count of missing num before for current arr num

      if(countOfMissingNumBefore < k) { // If count is less than k go to right side
        low = mid + 1;
      } else { // If count is greater than go to left.
        high = mid - 1;
      }
    }

    System.out.println("Missing Number: " + (high + 1 + k)); // For this formula check image explanation
  }

}
