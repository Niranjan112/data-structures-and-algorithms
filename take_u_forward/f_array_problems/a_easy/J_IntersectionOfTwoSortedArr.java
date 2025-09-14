package take_u_forward.f_array_problems.a_easy;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class J_IntersectionOfTwoSortedArr {

  public static void main(String[] args) {
    int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int[] arr2 = {2, 3, 4, 4, 5, 11, 12};

    bruteForceApproach(arr1, arr2); // O(m + n) time complexity and O(m+n) space complexity.
    optimalApproach(arr1, arr2); // O(m + n) time complexity and O(m+n) space complexity (Space complexity only applicable if considering intersect arraylist )
  }

  public static void bruteForceApproach(int[] arr1, int[] arr2) {
    Map<Integer, Integer> numbersCountMap = new LinkedHashMap<>();
    List<Integer> intersects = new ArrayList<>();

    // Store count of numbers from both array
    for(int num: arr1) {
      numbersCountMap.put(
          num,
          numbersCountMap.getOrDefault(num, 0) + 1
      );
    }

    for(int num: arr2) {
      numbersCountMap.put(
          num,
          numbersCountMap.getOrDefault(num, 0) + 1
      );
    }

    // If count is more than 1 then add the number to intersect arraylist.
    for(int key : numbersCountMap.keySet()) {
      if(numbersCountMap.get(key) > 1) {
        intersects.add(key);
      }
    }

    System.out.println("Map: " + numbersCountMap);
    System.out.println("Intersects: " + intersects);
  }

  public static void optimalApproach(int[] arr1, int[] arr2) {
    List<Integer> intersects = new ArrayList<>();

    /*
    * Start with 0 in arr1 and arr2
    * If arr1[i] < arr2[j] then,
    * just simply increment i by 1 because we know that since array is sorted so in future we can get a number that can be equal to arr2[j].
    * If arr1[i] == arr2[j] then,
    * add the number at arr1[i] and increment i by 1.
    *
    * else if arr2[j] < arr1[i] then,
    * just increment j by 1 because we know that since array is sorted so in future we can get a number that can be equal to arr1[i].
    * */
    int i = 0;
    int j = 0;
    while(i < arr1.length && j < arr2.length) {

      if(arr1[i] <= arr2[j]) {

        if((intersects.isEmpty() || intersects.getLast() != arr1[i]) && arr1[i] == arr2[j]) {
          intersects.add(arr1[i]);
        }

        i++;
      } else {
        j++;
      }
    }

    System.out.println("Intersects: " + intersects);
  }
}
