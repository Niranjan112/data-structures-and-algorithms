package take_u_forward.g_binary_search.b_answer.c;

import java.util.Arrays;

public class KokoEatingBanana {

  public static void main(String[] args) {
    int[] arr = {3, 6, 7, 11};

    System.out.println(" " + bruteForceApproach(arr, 8) + " no of banana / per hour to complete all in 8 hours"); // TC: O(n * max(a[])) and SC: O(1)
    System.out.println(" " + optimalApproach(arr, 8) + " no of banana / per hour to complete all in 8 hours"); // TC: O(N*log(max(a[]))) and SC: O(1)
  }

  public static int bruteForceApproach(int[] piles, int h) {
    int maxPileSize = Arrays.stream(piles).max().getAsInt(); // Get max number banana present in a pile.

    for (int i = 1; i <= maxPileSize; i++) {
      long totalHours = findTotalHourToEatOnPerHourNumInput(piles, i);
      if (totalHours <= h) {
        return i;
      }
    }

    return maxPileSize;
  }

  private static long findTotalHourToEatOnPerHourNumInput(int[] piles, int numOfBananaEatenPerHour) {
    long totalHours = 0;

    for (int i = 0; i < piles.length; i++) {
      int hours = (int) Math.ceil( (double) piles[i] / numOfBananaEatenPerHour);

      totalHours += hours;
    }

    return totalHours;
  }

  public static int optimalApproach(int[] piles, int h) {
    int maxPileSize = Arrays.stream(piles).max().getAsInt(); // Get max number banana present in a pile.

    int low = 1;
    int high = maxPileSize;

    int ans = -1;

    while (low <= high) {
      int mid = (low + high) / 2;

      long totalHours = findTotalHourToEatOnPerHourNumInput(piles, mid);

      if(totalHours <= h) { // If we got ans we will still find for more less number of banana can be eaten as per question demands
        ans = mid; // Update ans whatever we got till now
        high = mid - 1; // We Will find for more less number of banana
      } else { // If number of banana is low then go to high side
        low = mid + 1;
      }
    }

    return ans;
  }

}
