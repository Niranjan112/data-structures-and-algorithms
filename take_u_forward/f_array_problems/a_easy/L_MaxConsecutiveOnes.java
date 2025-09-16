package take_u_forward.f_array_problems.a_easy;

public class L_MaxConsecutiveOnes {

  public static void main(String[] args) {
    /*
    * 485. Max Consecutive Ones
    * Leet Code Problem link: https://leetcode.com/problems/max-consecutive-ones/description/
    *
    * Explanation link: https://takeuforward.org/data-structure/count-maximum-consecutive-ones-in-the-array/
    * */

    int[] nums = {1,1,0,1,1,1};
    
    approach(nums); // O(n) time complexity and O(1) space complexity
  }

  public static void approach(int[] arr) {

    int maxConsecutiveCount = 0; // Will store max consecutive of 1s occurred everytime
    int currentConsecutiveCount = 0; // Will store count of current consecutive while traversing in array

    /*
    * If arr[i] is 1 then increment currentConsecutiveCount by 1.
    * Everytime we found 1 in arr[i] keep incrementing currentConsecutiveCount by 1.
    *
    * If we found 0 at arr[i] then check last currentConsecutiveCount var and compare with maxConsecutiveCount var.
    * Whichever var has max value just consider it.
    * Also set currentConsecutiveCount to 0 to count for upcoming consecutive of 1s in array.
    * */
    for (int num: arr) {
      if(num == 1) {
        currentConsecutiveCount++;
      } else {
        maxConsecutiveCount = Math.max(currentConsecutiveCount, maxConsecutiveCount);
        currentConsecutiveCount = 0;
      }
    }

    // This comparison we are doing again because there can be a case where array last num is 1.
    // And we have to compare with last currentConsecutiveCount as well with maxConsecutiveCount.
    maxConsecutiveCount = Math.max(currentConsecutiveCount, maxConsecutiveCount);

    System.out.println("Max number of consecutive 1s is " + maxConsecutiveCount);
  }

}
