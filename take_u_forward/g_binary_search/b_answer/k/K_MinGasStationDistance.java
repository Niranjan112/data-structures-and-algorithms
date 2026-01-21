package take_u_forward.g_binary_search.b_answer.k;

import java.util.PriorityQueue;

public class K_MinGasStationDistance {

  public static void main(String[] args) {
    int[] distances = {1 ,2 ,3 ,4 ,5};
    int noOfGasStation = 2;

    bruteForce(distances, noOfGasStation); // TC: O((k * n) + n) and SC: O(1)
    betterApproach(distances, noOfGasStation); // TC: O(n * log n + k * log n), push to PQ takes log n and SC: O(n-1) + O(n-1)
    optimalApproach(distances, noOfGasStation); // TC: O(n*log(Len)) + O(n) and SC: O(1)
  }

  public static void bruteForce(int[] distances, int noOfGasStation) {
    if(distances.length == 1) {
      System.out.println("Max space length: " + 0.0);
      return;
    }

    // Creating array for tracking number of gas station between distances array.
    int[] noOfGasStationPlaced = new int[distances.length - 1];

    for (int i = 0; i < noOfGasStation; i++) {
      double maxSpaceBetweenTwoDistances = -1;
      int indexOfMaxSpaceBetweenTwoDistances = -1;

      for (int j = 0; j < distances.length - 1; j++) {
        double differenceBetweenTwoDist = (distances[j + 1] - distances[j]);
        double spaceLength = differenceBetweenTwoDist / (noOfGasStationPlaced[j] + 1.0); // each space length after placing n gas station

        // If the new calculated space length is greater than previous then update
        if(spaceLength > maxSpaceBetweenTwoDistances) {
          maxSpaceBetweenTwoDistances = spaceLength;
          indexOfMaxSpaceBetweenTwoDistances = j;
        }
      }

      // Increase the count of gas station placed after getting max space length.
      noOfGasStationPlaced[indexOfMaxSpaceBetweenTwoDistances]++;
    }

    double maxSpaceLength = -1;
    for (int i = 0; i < distances.length - 1; i++) {
      double differenceBetweenTwoDist = (distances[i + 1] - distances[i]);
      double spaceLength = differenceBetweenTwoDist / (noOfGasStationPlaced[i] + 1.0); // each space length after placing n gas station

      maxSpaceLength = Math.max(spaceLength, maxSpaceLength);
    }

    System.out.println("Max space length: " + maxSpaceLength);
  }

  public static void betterApproach(int[] distances, int noOfGasStation) {
    if(distances.length == 1) {
      System.out.println("Max space length: " + 0.0);
      return;
    }

    // Creating array for tracking number of gas station between distances array.
    int[] noOfGasStationPlaced = new int[distances.length - 1];

    PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(
      (a, b) -> Double.compare(b.spaceLength, a.spaceLength)
    );

    // Initially store the difference between two distance arr element in PQ with its index
    for (int i = 0; i < distances.length - 1; i++) {
      double differenceBetweenTwoDist = (distances[i + 1] - distances[i]);
      priorityQueue.add(new Pair(differenceBetweenTwoDist, i));
    }

    /*
    * Take make pair from PQ.
    * Update the index count by 1 in noOfGasStation
    * Calculate new space length after assigning 1 gas station between two distance.
    * Add new space length with its index again in PQ.
    * */
    for (int i = 1; i <= noOfGasStation; i++) {
      Pair maxPairInPQ = priorityQueue.poll();
      int maxIndex = maxPairInPQ.index;
      noOfGasStationPlaced[maxPairInPQ.index]++;

      double differenceBetweenTwoDist = (distances[maxIndex + 1] - distances[maxIndex]);
      double newSpaceLength = differenceBetweenTwoDist / (noOfGasStationPlaced[maxIndex] + 1.0); // each space length after placing n gas station

      priorityQueue.add(new Pair(newSpaceLength, maxIndex));
    }

    System.out.println("Max space length: " + priorityQueue.peek().spaceLength);
  }

  // Method to calculate required number of gas stations
  public static int numberOfGasStationsRequired(double dist, int[] arr) {
    int n = arr.length;
    int count = 0;

    for (int i = 0; i < n - 1; i++) {
      int numberInBetween = (int) ((arr[i + 1] - arr[i]) / dist); // Number of gas station need between two dist
      if ((arr[i + 1] - arr[i]) == (dist * numberInBetween)) { // If diff turn out to exact equals to number of station then decrement the count
        numberInBetween--;
      }
      count += numberInBetween; //total number of additional gas stations required
    }

    return count;  //total number of additional gas stations required
  }

  public static void optimalApproach(int[] distances, int noOfGasStation) {
    double low = 0;
    double high = 0;

    // Get the max difference between two distance in arr to decide high value
    for (int i = 0; i < distances.length - 1; i++) {
      high = Math.max(high, distances[i + 1] - distances[i]);
    }

    double maxPossibleAns = 1e-6; // Given in question that answer exactly to 6 decimal places.
    while (high - low > maxPossibleAns) { // high - low = size of current search range
      double mid = (low + high) / 2.0;

      int numberOfGasStationUsed = numberOfGasStationsRequired(mid, distances);

      // If we over placed gas station than given in question, then increase the distance to place less gas station.
      // Hence, go to right side
      if(numberOfGasStationUsed > noOfGasStation) {
        low = mid; // Assigning mid not mid + 1 because it can exceed 1 and ans could be below 1
      } else { // If there are less gas station placed than given in question, then decrease the distance to place more gas station. Hence, go to left
        high = mid;
      }
    }

    System.out.println("Max space length: " + high); // Answer always be at high
  }
}

class Pair {
  double spaceLength;
  int index;

  Pair(double spaceLength, int index) {
    this.spaceLength = spaceLength;
    this.index = index;
  }
}
