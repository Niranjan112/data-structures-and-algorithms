package take_u_forward.g_binary_search.b_answer.d;

import java.util.Arrays;

public class MinDaysForMBouquets {

  public static void main(String[] args) {
    int[] bloomDays = {1, 10, 3, 10, 2};
    int numberOfBouquets = 3;
    int numberOfAdjacentFlowers = 1;

    System.out.println("Min Days to bloom: " + bruteForce(bloomDays, numberOfBouquets, numberOfAdjacentFlowers)); // TC: O( min to max * n) and SC: O(1)
    System.out.println("Min Days to bloom: " + optimalApproach(bloomDays, numberOfBouquets, numberOfAdjacentFlowers)); // TC: O( log min to max * n) and SC: O(1)
  }

  public static int bruteForce(int[] bloomDays, int numberOfBouquets, int numberOfAdjacentFlowers) {
    long totalFlowers = (long) numberOfBouquets * numberOfAdjacentFlowers;
    if(totalFlowers > bloomDays.length) { // If there is no enough flower then simply return -1;
      return -1;
    }

    int minDays = Arrays.stream(bloomDays).min().getAsInt(); // Start from min day in arr bloomdays
    int maxDays = Arrays.stream(bloomDays).max().getAsInt(); // Iterate till max day in arr bloomdays

    for (int days = minDays; days <= maxDays; days++) {

      // As soon as we found first min days when required number of bouquets can be formed then exit
      if(isPossibleToAchieveDesiredBouquets(bloomDays, days, numberOfBouquets, numberOfAdjacentFlowers)) {
        return days;
      }
    }

    return -1;
  }

  private static boolean isPossibleToAchieveDesiredBouquets(int[] bloomDays, int days, int numberOfBouquets, int numberOfAdjacentFlowers) {
    int count = 0; // Counter to track number of adjacent flowers
    int countOfBouquetsFormed = 0; // Counter to track number of bouquets formed as per given input day

    for (int bloomDay: bloomDays) {

      if(bloomDay <= days) { // If number of bloom day when flower will be bloomed is less than input days then increase adjacent flower count.
        count++;

        if(count == numberOfAdjacentFlowers) { // When count of flowers become equals to bouquets size then increase the count of bouquets formed till now.
          countOfBouquetsFormed++;
          count = 0; // Also reset the count to 0 to check for next possible adjacent flower.
        }
      } else { // Reset to 0 if adjacent flower count break in between.
        count = 0;
      }
    }

    return countOfBouquetsFormed >= numberOfBouquets; // If bouquets formed count is greater or equals to required number of bouquets then it is possible
  }

  public static int optimalApproach(int[] bloomDays, int numberOfBouquets, int numberOfAdjacentFlowers) {
    long totalFlowers = (long) numberOfBouquets * numberOfAdjacentFlowers;
    if(totalFlowers > bloomDays.length) { // If there is no enough flower then simply return -1;
      return -1;
    }

    int low = Arrays.stream(bloomDays).min().getAsInt(); // Start from min day in arr bloomdays
    int high = Arrays.stream(bloomDays).max().getAsInt(); // Iterate till max day in arr bloomdays

    int minDays = -1;

    while (low <= high) {
      int mid = (low + high) / 2;

      // If we got possible bouquets then let's proceed to search for more minimum day on left side
      if(isPossibleToAchieveDesiredBouquets(bloomDays, mid, numberOfBouquets, numberOfAdjacentFlowers)) {
        high = mid - 1;
        minDays = mid;
      } else { // If we didn't get possible bouquets then let's try with larger number on right side
        low = mid + 1;
      }
    }

    return minDays;
  }
}
