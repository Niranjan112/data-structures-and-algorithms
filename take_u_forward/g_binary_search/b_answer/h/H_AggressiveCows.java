package take_u_forward.g_binary_search.b_answer.h;

import java.util.Arrays;

public class H_AggressiveCows {

  public static void main(String[] args) {
    int[] arr = {0, 3, 4, 7, 10, 9};
    int cows = 4;

    bruteForce(arr, cows); // TC: O(max-min * n) and SC: O(1)
    optimalApproach(arr, cows);
  }

  public static void bruteForce(int[] stalls, int cows) {
    Arrays.sort(stalls);

    int min = stalls[0];
    int max = stalls[stalls.length - 1];

    int maxGapBetweenCows = -1;

    // After sorting array, arr[0] and arr[last] i.e max - min can be last possible distance between cows.
    for (int i = 1; i <= max - min; i++) {
      if(isPlacingAllCowsPossible(stalls, i, cows)) {
        maxGapBetweenCows = i;
      }
    }

    System.out.println("Maximum gap between cows can be " + maxGapBetweenCows);
  }

  private static boolean isPlacingAllCowsPossible(int[] stalls, int distance, int cows) {
    int countOfCowsPlacedTillNow = 1; // First cow will always be placed at arr[0] position so that distance can be calculated with other cows.
    int lastCowPlacedAtStall = stalls[0]; // Start with first stall placed with a cow as latest stall placed

    for (int i = 1; i < stalls.length; i++) {

      // When distance between current stall and last cow's placed stall is greater or equal to required distance then new cow can be placed at that stall
      if(stalls[i] - lastCowPlacedAtStall >= distance) {
        countOfCowsPlacedTillNow++; // Increase the count of cows placed at stall.
        lastCowPlacedAtStall = stalls[i]; // Update current placed stall as last placed stall.
      }

      // Once cows placed count equals to required cows var then return true.
      if(countOfCowsPlacedTillNow == cows) {
        return true;
      }
    }

    return false;
  }

  public static void optimalApproach(int[] stalls, int cows) {
    Arrays.sort(stalls);

    int low = 1;
    int high = stalls[stalls.length - 1];

    int maxGapBetweenCows = -1;

    while (low <= high) {
      int mid = (low + high) / 2;

      boolean isPlacingAllCowsPossible = isPlacingAllCowsPossible(stalls, mid, cows);

      if(isPlacingAllCowsPossible) {
        low = mid + 1;
        maxGapBetweenCows = mid;
      } else {
        high = mid - 1;
      }
    }

    System.out.println("Maximum gap between cows can be " + maxGapBetweenCows);
  }
}
