package take_u_forward.f_array_problems.b_medium.h;

import java.util.ArrayList;
import java.util.List;

public class H_LeadersInArray {

  public static void main(String[] args) {
    /*
     *
     * Leaders in an Array
     * Problem Link: https://takeuforward.org/data-structure/leaders-in-an-array/
     *
     * For detailed explanation check TUF
     * */

    int[] arr = {10, 22, 12, 3, 0, 6};

    bruteForceApproach(arr); // O(n^2) time complexity and O(1) space complexity.
    optimalApproach(arr); // O(n) time complexity and O(1) space complexity.
  }

  public static void bruteForceApproach(int[] arr) {
    List<Integer> leaders = new ArrayList<>();

    /*
    * Select every number each time in outer loop and check in inner loop whether all element right after that is smaller.
    * If found that even a single number is greater than number is not a leader. Make isLeader to false and break inner loop.
    * Else all number right to it is smaller than isLeader will be true only and add that number in leaders list.
    * */
    boolean isLeader;
    for (int i = 0; i < arr.length; i++) {

      isLeader = true;
      for (int j = i+1; j < arr.length; j++) {

        if(arr[i] < arr[j]) {
          isLeader = false;
          break;
        }
      }

      if(isLeader) {
        leaders.add(arr[i]);
      }
    }

    System.out.println("Leaders: " + leaders);
  }

  public static void optimalApproach(int[] arr) {
    // For visual explanation, check H_leaders_in_array_optimal.jpg in same package.
    List<Integer> leaders = new ArrayList<>();

    int maxNumTillNow = Integer.MIN_VALUE; // Variable to store greater number that we get in each iteration.

    /*
    * Start from last element and check every time whether that element is greater than number present in maxNumTillNow.
    * If yes, then add that number to leaders list and update that greater number in maxNumTillNow.
    * */
    for (int i = arr.length - 1; i >= 0; i--) {

      if(arr[i] > maxNumTillNow) {
        leaders.add(arr[i]);
        maxNumTillNow = arr[i];
      }
    }

    System.out.println("Leaders: " + leaders);
  }
}
