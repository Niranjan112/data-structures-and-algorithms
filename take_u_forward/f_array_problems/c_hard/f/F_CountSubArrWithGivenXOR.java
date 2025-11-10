package take_u_forward.f_array_problems.c_hard.f;

import java.util.HashMap;
import java.util.Map;

public class F_CountSubArrWithGivenXOR {

  public static void main(String[] args) {
    /*
     *
     * Count the number of subarrays with given xor K
     * Problem Link: https://takeuforward.org/data-structure/count-the-number-of-subarrays-with-given-xor-k/
     * GOG Problem Link: https://www.geeksforgeeks.org/problems/count-subarray-with-given-xor/1
     *
     * For detailed explanation check TUF
     * */
    int[] arr = {4, 2, 2, 6, 4};

    bruteForceApproach(arr, 6); // TC: O(n^2) and SC: O(1)
    optimalApproach(arr, 6); // TC: O(n * log n) and SC: O(n)
  }

  public static void bruteForceApproach(int[] arr, int k) {
    int xorSubArrCount = 0;

    for (int i = 0; i < arr.length; i++) {
      int xor = 0;
      for (int j = i; j < arr.length; j++) {
        xor ^= arr[j];
        if(xor == k) {
          xorSubArrCount++;
        }
      }
    }

    System.out.println("Count XOR sub array: " + xorSubArrCount);
  }

  public static void optimalApproach(int[] arr, int k) {
    int xor = 0;
    int xorSubArrCount = 0;

    Map<Integer, Integer> map = new HashMap<>();
    map.put(xor, 1);

    for (int i = 0; i < arr.length; i++) {
      xor ^= arr[i];

      // Formula to find x, x = xor ^ k
      int x = xor ^ k;

      // If x occurred previously in map then add its count to xorSubArrCount
      if(map.containsKey(x)) {
        int currentCount = map.get(x);
        xorSubArrCount += currentCount;
      }

      // keep storing count of xor at every iteration
      // Key -> xor till now, Value -> Count of xor occurred.
      if(map.containsKey(xor)) {
        int currentCount = map.get(xor);
        map.put(xor, ++currentCount);
      } else {
        map.put(xor, 1);
      }
    }

    System.out.println("Count XOR sub array: " + xorSubArrCount);
  }
}
