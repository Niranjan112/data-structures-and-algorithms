package take_u_forward.f_array_problems.b_medium.d;

public class D_MaxSubArraySumInArr {

  public static void main(String[] args) {
    /*
    * 53. Maximum Subarray
    * Problem link: https://leetcode.com/problems/maximum-subarray/description/
    *
    *
    * */
    int[] arr = {-2,1,-3,4,-1,2,1,-5,4};

    bruteForce(arr); // O(N ^ 2) time complexity and O(1) space complexity.
    betterApproach(arr); // O(N) time complexity and O(1) space complexity.
  }

  public static void bruteForce(int[] arr) {

    int startIndexOfMaxSubArr = -1;
    int endIndexOfMaxSubArr = -1;
    int maxSumOfSubArr = Integer.MIN_VALUE;
    int sum;

    /*
    * Iterate over all sub array.
    * Whenever in sub array you found max then update maxSum, startIndex and endIndex of subArr
    * */
    for (int i = 0; i < arr.length; i++) {

      sum = 0;
      for (int j = i; j < arr.length; j++) {

        sum += arr[j];
        if(sum > maxSumOfSubArr) {
          maxSumOfSubArr = sum;

          startIndexOfMaxSubArr = i;
          endIndexOfMaxSubArr = j;
        }
      }
    }
    System.out.println("Max Sum in Sub Array: " + maxSumOfSubArr);

    // Below is the extension to print that sub array If asked in question.
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    for (int i = startIndexOfMaxSubArr; i <= endIndexOfMaxSubArr; i++) {
      stringBuilder.append(arr[i]);
      if(i != endIndexOfMaxSubArr) {
        stringBuilder.append(", ");
      }
    }
    stringBuilder.append("]");

    System.out.println("Sub Array: " + stringBuilder);
  }

  public static void betterApproach(int[] arr) {
    // Kadane Algorithm

    int start = -1;
    int startIndexOfMaxSubArr = -1;
    int endIndexOfMaxSubArr = -1;

    int maxSumOfSubArr = Integer.MIN_VALUE;

    int sum = 0;
    for (int i = 0; i < arr.length; i++) {

      // In previous iteration, if your sum become 0 then consider current index as a start of sub array.
      if(sum == 0) {
        start = i;
      }

      // Then sum up current number
      sum += arr[i];

      // If current sum is greater than max sum, then update maxSumOfSubArr, startIndexOfMaxSubArr and endIndexOfMaxSubArr
      if(sum > maxSumOfSubArr) {
        maxSumOfSubArr = sum;

        startIndexOfMaxSubArr = start;
        endIndexOfMaxSubArr = i;
      }

      // After summing up the current number if you found out that it's still negative then reset sum = 0;
      // We have to ignore number which sum results into negative.
      if(sum < 0) {
        sum = 0;
      }
    }

    System.out.println("Max Sum in Sub Array: " + maxSumOfSubArr);


    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[");
    for (int i = startIndexOfMaxSubArr; i <= endIndexOfMaxSubArr; i++) {
      stringBuilder.append(arr[i]);
      if(i != endIndexOfMaxSubArr) {
        stringBuilder.append(", ");
      }
    }
    stringBuilder.append("]");

    System.out.println("Sub Array: " + stringBuilder);

  }

}
