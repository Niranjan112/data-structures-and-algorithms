package take_u_forward.f_array_problems.a_easy;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class I_UnionOfTwoSortedArr {

  public static void main(String[] args) {
    int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int[] arr2 = {2, 3, 4, 4, 5, 11, 12};

    bruteForceApproach(arr1, arr2); // O( (m+n) log(m+n) ) time complexity and O(m+n) space complexity
    optimalApproach(arr1, arr2); // O(m + n) time complexity and O(m+n) space complexity
  }

  public static void bruteForceApproach(int[] arr1, int[] arr2) {
    // Push to set, and it will contain all unique numbers and avoid duplicate if their any.
    // Using LinkedHashSet to maintain the order since arrays are sorted.
    Set<Integer> unionSet = new LinkedHashSet<>();

    for(int num: arr1) {
      unionSet.add(num);
    }

    for(int num: arr2) {
      unionSet.add(num);
    }

    System.out.println("Union between two array: " + unionSet);
  }

  public static void optimalApproach(int[] arr1, int[] arr2) {
    /*
    * Check Solution number 3 for explanation:
    * https://takeuforward.org/data-structure/union-of-two-sorted-arrays/
    * */
    List<Integer> union = new ArrayList<>();

    int arr1Length = arr1.length;
    int arr2Length = arr2.length;

    int i = 0;
    int j = 0;

    while(i < arr1Length && j < arr2Length) {
      if(arr1[i] <= arr2[j]) {
        if(union.isEmpty() || union.getLast() != arr1[i]) {
          union.add(arr1[i]);
        }
        i++;
      } else {
        if(union.isEmpty() || union.getLast() != arr2[j]) {
          union.add(arr2[j]);
        }
        j++;
      }
    }

    while(i < arr1Length) {
      if(union.getLast() != arr1[i]) {
        union.add(arr1[i]);
      }
      i++;
    }

    while(j < arr2Length) {
      if(union.getLast() != arr2[j]) {
        union.add(arr2[j]);
      }
      j++;
    }

    System.out.println("Union between two array: " + union);
  }
}
