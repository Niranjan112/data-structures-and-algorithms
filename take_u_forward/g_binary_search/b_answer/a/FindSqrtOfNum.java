package take_u_forward.g_binary_search.b_answer.a;

public class FindSqrtOfNum {

  public static void main(String[] args) {
    int num = 25;

    bruteForceApproach(num); // TC: O(n) and SC: O(1)
    optimalApproach(num); // TC: O(log n) and SC: O(1)
  }

  public static void bruteForceApproach(int num) {
    int answer = 1;

    // Iterate from 1 to num and do 1 * 1, 2 * 2,... so on and check whether result is equal to num and just a number before num.
    for (int i = 1; i < num; i++) {
      if(i * i <= num) {
        answer = i;
      } else {
        break; // Once we got i * i greater than num the break the loop.
      }
    }

    System.out.println("Sqrt of num: " + answer);
  }

  public static void optimalApproach(int num) {
    int answer = 1;

    int low = 1;
    int high = num;

    while(low <= high) {

      int mid = (low + high) / 2;

      // If mid * mid is less than num then that could be answer and also move low after mid to search for next possible answer.
      if(mid * mid <= num) {
        answer = mid;
        low = mid + 1;
      } else { // Else if mid * mid is greater than num then move high before mid
        high = mid - 1;
      }
    }

    System.out.println("Sqrt of num: " + answer);
  }
}
