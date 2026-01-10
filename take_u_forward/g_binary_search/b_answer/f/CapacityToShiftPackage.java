package take_u_forward.g_binary_search.b_answer.f;

import java.util.Arrays;

public class CapacityToShiftPackage {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int days = 5;

    System.out.println("Minimum ship capacity: " + bruteForce(arr, days)); // TC: O(start -> end * n) and SC: O(1)
    System.out.println("Minimum ship capacity: " + optimalApproach(arr, days)); // TC: O(log start->end * n) and SC: O(1)

  }

  public static int bruteForce(int[] arr, int days) {
    int start = Arrays.stream(arr).max().getAsInt(); // Get max from array as starting capacity number
    int end = Arrays.stream(arr).sum(); // Get sum of package weight as ending capacity number

    for (int capacity = start; capacity <= end; capacity++) {

      int daysRequiredAsPerCapacity = getDaysRequiredAsPerCapacity(arr, capacity); // Get the required of days as per capacity
      if(daysRequiredAsPerCapacity <= days) { // Required number of days is less than expected day then we got ans
        return capacity;
      }

    }

    return -1;
  }

  private static int getDaysRequiredAsPerCapacity(int[] arr, int shipCapacity) {
    int sumOfPackageWeight = 0; // Track the total weight of package can be sent each day
    int totalDaysRequired = 1; // Counter for total days required as per given ship capacity

    for (int currentPackageWeight: arr) {

      if(sumOfPackageWeight + currentPackageWeight > shipCapacity) { // If sum of package weight till now + current package weight exceeded then increase total day count
        totalDaysRequired++;
        sumOfPackageWeight = currentPackageWeight; // Reset to current package weight to track for next days
      } else { // Else just keep summing the package weight until it exceeds ship capacity
        sumOfPackageWeight += currentPackageWeight;
      }

    }

    return totalDaysRequired;
  }

  public static int optimalApproach(int[] arr, int days) {
    int low = Arrays.stream(arr).max().getAsInt();
    int high = Arrays.stream(arr).sum();

    int result = -1;
    while (low <= high) {
      int mid = (low + high) / 2;

      int daysRequiredAsPerCapacity = getDaysRequiredAsPerCapacity(arr, mid);
      if(daysRequiredAsPerCapacity <= days) {
        high = mid - 1;
        result = mid;
      } else {
        low = mid + 1;
      }
    }

    return result;
  }
}
