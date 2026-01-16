package take_u_forward.g_binary_search.b_answer.j;

import java.util.Arrays;

public class J_SplitArray {

  public static void main(String[] args) {
    // Note: This problem is same as previous problem BookAllocation and Painter's Partition Problem.

    int[] arr = {7, 2, 5, 10, 8};
    int k = 2;

    System.out.println("Min Sum of Sub Arr: " + bruteForce(arr, k));
    System.out.println("Min Sum of Sub Arr: " + optimalApproach(arr, k));
  }

  private static int bruteForce(int[] arr, int k) {
    if(k > arr.length) {
      return -1;
    }

    int min = Arrays.stream(arr).max().getAsInt();
    int max = Arrays.stream(arr).sum();

    for (int minSumCanHave = min; minSumCanHave <= max ; minSumCanHave++) {

      int spiltArrCount = getCountOfSplit(arr, minSumCanHave);
      if(spiltArrCount <= k) {
        return minSumCanHave;
      }
    }

    return -1;
  }

  private static int getCountOfSplit(int[] arr, int minSumCanHave) {
    int splitArrCount = 1;
    int sumOfSubArr = 0;

    for (int num: arr) {

      if(sumOfSubArr + num <= minSumCanHave) {
        sumOfSubArr += num;
      } else {
        splitArrCount++;
        sumOfSubArr = num;
      }
    }

    return splitArrCount;
  }

  public static int optimalApproach(int[] arr, int k) {
    if(k > arr.length) {
      return -1;
    }

    int low = Arrays.stream(arr).max().getAsInt();
    int high = Arrays.stream(arr).sum();

    int ans = -1;

    while (low <= high) {
      int mid = (low + high) / 2;

      int splitArrCount = getCountOfSplit(arr, mid);

      if(splitArrCount <= k) {
        high = mid - 1;
        ans = mid;
      } else {
        low = mid + 1;
      }
    }

    return ans;
  }
}
