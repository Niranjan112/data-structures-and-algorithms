package take_u_forward.g_binary_search.b_answer.e;

import java.util.Arrays;

public class FindSmallestDivisorForGivenThreshold {

  public static void main(String[] args) {
    int[] arr = {1, 2, 5, 9};
    int threshold = 6;

    System.out.println("Smallest divisor for threshold: " + bruteForce(arr, threshold));
    System.out.println("Smallest divisor for threshold: " + optimalApproach(arr, threshold));
  }

  public static int bruteForce(int[] arr, int threshold) {
    int maxNumInArr = Arrays.stream(arr).max().getAsInt(); // Get the max num in arr to know end range num to find ans

    // try with number 1 to max num in arr found
    for (int i = 1; i <= maxNumInArr; i++) {

      int sum = getSumOfDivisionOnAllNumber(arr, i); // Get the sum of num divided by i;

      // If we got sum less than threshold then we found the smallest divisor
      if(sum <= threshold) {
        return i;
      }
    }

    return -1;
  }

  private static int getSumOfDivisionOnAllNumber(int[] arr, int rangeNum) {
    int sum = 0;

    for (int num : arr) {
      sum += (int) Math.ceil( (double) num/rangeNum );
    }

    return sum;
  }

  public static int optimalApproach(int[] arr, int threshold) {
    int low = 1;
    int high = Arrays.stream(arr).max().getAsInt();

    int result = -1;

    while (low <= high) {
      int mid = (low + high) / 2;

      int sum = getSumOfDivisionOnAllNumber(arr, mid);

      if(sum <= threshold) { // If we found sum less than threshold we will still try to get more small number by moving to left side.
        result = mid;
        high = mid - 1;
      } else { // If sum is greater than threshold than try with bigger number on right side
        low = mid + 1;
      }
    }

    return result;
  }
}
