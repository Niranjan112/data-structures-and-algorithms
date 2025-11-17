package take_u_forward.f_array_problems.c_hard.j;

public class J_FindRepeatingAndMissing {

  public static void main(String[] args) {
    /*
     *
     * Find the repeating and missing numbers
     * Problem Link: https://takeuforward.org/data-structure/find-the-repeating-and-missing-numbers/
     *
     * For detailed explanation check TUF
     * */

    int[] arr = {3,1,2,5,4,6,7,5};

    bruteForceApproach(arr); // TC: O(n^2) and SC: O(1)
    betterApproach(arr); // TC: O(n+n) and SC: O(n)
    optimalApproach(arr); // TC: O(n) and SC: O(1)
  }

  public static void bruteForceApproach(int[] arr) {

    int repeatingNumber = -1;
    int missingNumber = -1;
    for (int i = 1; i <= arr.length; i++) { // Using i as 1 to n numbers to check in arr the count of i number

      int countOfNum = 0;
      for (int j = 0; j < arr.length; j++) { // Count each i number in arr
        if(arr[j] == i) {
          countOfNum++;
        }
      }

      if(countOfNum == 2) { // If any j iteration count turn out to be 2 then it is repeating number
        repeatingNumber = i;
      }
      if(countOfNum == 0) { // If any j iteration count turn out to be 0 then it is missing number
        missingNumber = i;
      }

      if(repeatingNumber != -1 && missingNumber != -1) { // If we found repeating and missing number then no need to check further we can break the loop
        break;
      }
    }

    System.out.println("Repeating Num: " + repeatingNumber);
    System.out.println("Missing Num: " + missingNumber);
  }

  public static void betterApproach(int[] arr) {
    int[] hash = new int[arr.length + 1];

    for (int num: arr) {
      hash[num]++;
    }

    int repeatingNumber = -1;
    int missingNumber = -1;
    for (int i = 1; i < hash.length; i++) {
      if(hash[i] == 2) {
        repeatingNumber = i;
      } else if(hash[i] == 0) {
        missingNumber = i;
      }

      if(repeatingNumber != -1 && missingNumber != -1) { // If we found repeating and missing number then no need to check further we can break the loop
        break;
      }
    }

    System.out.println("Repeating Num: " + repeatingNumber);
    System.out.println("Missing Num: " + missingNumber);
  }

  public static void optimalApproach(int[] arr) {
    long n = arr.length;

    long sumOf1ToN = (n * (n + 1)) / 2; // Sum of 1 to N numbers
    long sumOf1SquareToNSquare = (n * (n + 1) * (2 * n + 1)) / 6; // Sum of 1^2 to N^2 numbers

    long sumOfN = 0; // Sum of all numbers in arr 1+2+3...N in arr
    long sumOfNSquare = 0; // Sum of all numbers with square in arr 1^2 + 2^2 + 3^2....N^2 in arr

    for (long num : arr) {
      sumOfN += num;
      sumOfNSquare += (num * num);
    }

    // x is the repeating num and y is the missing number
    long val1 = sumOfN - sumOf1ToN; // Get the difference for sum of n numbers (x - y = val1)
    long val2 = sumOfNSquare - sumOf1SquareToNSquare; // Get the difference for sum of n^2 numbers (x^2 + y^2 = val2)
    val2 = val2 / val1; // (x + y = val2 / (x - y) ) So x - y is val1 -> (x + y = val2)

    long x = (val1 + val2) / 2; // Obtain by solving equation 1 and 2
    long y = x - val1; // Once we get x we can obtain y from equation 2.

    System.out.println("Repeating Num: " + x);
    System.out.println("Missing Num: " + y);
  }
}
