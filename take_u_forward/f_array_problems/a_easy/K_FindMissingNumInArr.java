package take_u_forward.f_array_problems.a_easy;

public class K_FindMissingNumInArr {

  public static void main(String[] args) {
    /*
     * 268. Missing Number
     * Leet Code Problem link: https://leetcode.com/problems/missing-number/description/
     *
     * */

    int[] arr = {9,6,4,2,3,5,7,0,1};

    System.out.println("Missing Number: " + bruteForceApproach(arr)); // O(n2) time complexity and O(1) space complexity
    System.out.println("Missing Number: " + betterApproach(arr)); // O(n + n) = O(2n) time complexity and O(n) space complexity
    System.out.println("Missing Number: " + optimalApproach(arr)); // O(n) time complexity and O(1) space complexity
  }

  public static int bruteForceApproach(int[] arr) {
    int missingNum = 0;

    boolean found = false; // Using as status if a number is found or not in an array.
    for (int i = 0; i <= arr.length; i++) { // Outer loop will iterate from 0 to array length N (all possible number in an array)

      for (int num : arr) { // Inner loop will check if current number i is present or not in array
        if (num == i) { // If found then set found status to true and break.
          found = true;
          break;
        }
      }

      // Check whether current number is found or not in array. If found, then this is not a missing number.
      // If not found, then this is the number which is missing and break the outer loop as well.
      if(!found) {
        missingNum = i;
        break;
      }

      found = false; // Reset the status as false to repeat same work for next iteration.
    }

    return missingNum;
  }

  public static int betterApproach(int[] arr) {
    // boolean array to maintain attendance which number is present or not based on index.
    boolean[] numberAttendance = new boolean[arr.length + 1];

    // Iterate through all numbers in array and update attendance by index in numberAttendance array.
    for (int num: arr) {
      numberAttendance[num] = true;
    }

    // Iterate in numberAttendance array and check which index value is false.
    // This is the number which is missing in array.
    int missingNum = 0;
    for (int i = 0; i < numberAttendance.length; i++) {
      if(!numberAttendance[i]) {
        missingNum = i;
        break;
      }
    }

    return missingNum;
  }

  public static int optimalApproach(int[] arr) {
    int n = arr.length;

    /*
    * Since we know that only one number is missing from 0 to N in array.
    * Let's take the total sum of all numbers from 1 to N with the help array length.
    * */
    int sum1ToN = n * (n + 1) / 2;

    // Now let's calculate sum of all the numbers present actually in array.
    int sumOfNumsInArr = 0;
    for (int num: arr) {
      sumOfNumsInArr += num;
    }

    // Once we do sum1ToN (Sum of 1 to N numbers) - sumOfNumsInArr (Sum of all number in array).
    // Then we will get the missing number.
    int missingNum = sum1ToN - sumOfNumsInArr;

    return missingNum;
  }
}
