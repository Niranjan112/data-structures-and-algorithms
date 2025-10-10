package take_u_forward.f_array_problems.b_medium.c;

import java.util.HashMap;
import java.util.Map;

public class C_MajorityElement {

  public static void main(String[] args) {

    /*
    * 169. Majority Element
    * Problem Link: https://leetcode.com/problems/majority-element/description/
    *
    * */
    int[] arr = {2,2,1,1,1,2,2};

    bruteForceApproach(arr); // O(N ^ 2) time complexity and O(1) space complexity.
    betterApproach(arr); // O(N * log N) time complexity and O(N) space complexity.
    optimalApproach(arr); // O(N) time complexity and O(1) space complexity.
  }

  public static void bruteForceApproach(int[] arr) {

    int count;
    for (int i = 0; i < arr.length; i++) {

      count = 0;
      for (int j = 0; j < arr.length; j++) {
        if(arr[i] == arr[j]) {
          count++;
        }
      }

      if(count > (arr.length/2)) {
        System.out.println(arr[i] + " is the majority element");
        break;
      }
    }
  }

  public static void betterApproach(int[] arr) {
    Map<Integer, Integer> numbersCount = new HashMap<>();

    // Store the count in hashmap
    for (int num: arr) {
      int count = numbersCount.getOrDefault(num, 0);
      numbersCount.put(num, ++count);
    }

    // Iterate in hashmap and check which number count is greater than n / 2.
    for (int key: numbersCount.keySet()) {

      int count = numbersCount.get(key);

      if(count > (arr.length / 2)) {
        System.out.println(key + " is the majority element");
        break;
      }
    }
  }

  public static void optimalApproach(int[] arr) {
    // Moore Voting algorithm.

    /*
    * Start with first element as electedNumber,
    * Keep iterating forward and when next element also you get what you have in electedNumber then increment count by 1.
    * If there is some other number which is not equals to electedNumber then decrement count by 1.
    * If the count get 0 then change electedNumber by putting the current number element as the electedNumber.
    *
    * After loop exits, whoever will stay in electedNumber will be a Majority of Number.
    * Because the number which is more than n / 2 will win the count as compared to others numbers.
    *
    * For example,
    * In array of length 7 [2,2,1,3,1,2,2],
    * 2 appears 4 four times, 1 appears two times and 3 appears one time.
    * So if you observe here count of 2 is greater than count of rest other number.
    * Count of 2 = 4, Count of other number = 3 ( 4 - 3 = 1 )
    *
    * So in below algorithm, when other numbers will cut out count of 2s then also something will be left.
    * And by this we get to know the majority element.
    * */

    int incrementOrDecrementCounter = 0;
    int electedNumber = 0;

    for (int num: arr) {
      if(incrementOrDecrementCounter == 0) {
        electedNumber = num;
      }

      if(num != electedNumber) {
        incrementOrDecrementCounter--;
      } else {
        incrementOrDecrementCounter++;
      }
    }

    System.out.println(electedNumber + " is the majority element");

    // Here we are checking again to just make sure whether Majority element really exist or not.
    // If it's already told in question that majority element will exist then above solution is enough below check is not required.
    int countCheckForElectedNum = 0;
    for (int num: arr) {
      if(num == electedNumber) {
        countCheckForElectedNum++;
      }
    }

    if(countCheckForElectedNum > (arr.length / 2)) {
      System.out.println(electedNumber + " is the confirmed majority element");
    }

  }

}
