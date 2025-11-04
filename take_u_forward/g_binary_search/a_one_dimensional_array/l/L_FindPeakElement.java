package take_u_forward.g_binary_search.a_one_dimensional_array.l;

public class L_FindPeakElement {

  public static void main(String[] args) {
    /*
     *
     * 162. Find Peak Element
     * https://leetcode.com/problems/find-peak-element/description/
     *
     * For detailed explanation check TUF
     * */

    int[] arr = {1, 2, 1, 3, 5, 6, 4};

    System.out.println("Peak index: " + bruteForceApproach(arr));
    System.out.println("Peak index: " + optimalApproach(arr));

  }

  public static int bruteForceApproach(int[] arr) {
    if(arr.length == 1) {
      return 0;
    }

    if(arr[0] > arr[1]) {
      return 0;
    } else if (arr[arr.length - 1] > arr[arr.length - 2]) {
      return arr.length - 1;
    }

    for (int i = 1; i < arr.length - 1; i++) {
      if(arr[i] > arr[i + 1] && arr[i] > arr[i - 1]) {
        return i;
      }
    }

    return -1; // This line will never reach
  }

  public static int optimalApproach(int[] arr) {
    if(arr.length == 1) {
      return 0;
    }

    if(arr[0] > arr[1]) {
      return 0;
    } else if (arr[arr.length - 1] > arr[arr.length - 2]) {
      return arr.length - 1;
    }

    int low = 1;
    int high = arr.length - 1;
    int mid;

    while (low <= high) {
      mid = (low + high) / 2;

      if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
        return mid;
      } else if(arr[mid + 1] > arr[mid]) { // Move right side if right element is greater
        low = mid + 1;
      } else {
        // Move left if left element is greater.
        // Also, if arr[mid] is less than it's left and right element then also move to either one of the side.
        // Here we choose to move left as there can be multiple peak element.
        high = mid - 1;
      }
    }

    return -1; // This line will never reach
  }
}
