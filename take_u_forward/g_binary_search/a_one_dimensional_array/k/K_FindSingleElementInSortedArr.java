package take_u_forward.g_binary_search.a_one_dimensional_array.k;

public class K_FindSingleElementInSortedArr {

  public static void main(String[] args) {
    /*
     *
     * 540. Single Element in a Sorted Array
     * https://leetcode.com/problems/single-element-in-a-sorted-array/description/
     *
     * For detailed explanation check TUF
     * */

    int[] arr = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};

    System.out.println("Single Element: " + linear(arr)); // TC: O(n) and SC: O(1)
    System.out.println("Single Element: " + binary(arr)); // TC: O(log n) and SC: O(1)
  }

  public static int linear(int[] arr) {
    // If arr length is 1 then that element is only the single element.
    if(arr.length == 1) {
      return arr[0];
    }

    for (int i = 0; i < arr.length; i++) {
      if(i == 0 && arr[i] != arr[i + 1]) { // If first element is not equal to next one then it is the single element.
        return arr[i];
      } else if (i == arr.length - 1 && arr[i] != arr[i - 1]) { // If last element is not equal to previous one then it is the single element.
        return arr[i];
      } else { // If any element in between is not equal to next and previous element then it is the single element.
        if(arr[i] != arr [i + 1] && arr[i] != arr[i - 1]) {
          return arr[i];
        }
      }
    }

    return -1; // This line will never be executed.
  }

  public static int binary(int[] arr) {
    // If arr length is 1 then that element is only the single element.
    if(arr.length == 1) {
      return arr[0];
    }

    if(arr[0] != arr[1]) { // If first element is not equal to next one then it is the single element.
      return arr[0];
    } else if (arr[arr.length - 1] != arr[arr.length - 2]) { // If last element is not equal to previous one then it is the single element.
      return arr[arr.length - 1];
    }

    /*
    * Set low to 1 and high to arr.length - 2
    * As we already checked for first and last element.
    * */
    int low = 1;
    int high = arr.length - 2;
    int mid;
    
    while (low <= high) {
      mid = (low + high) / 2;
      
      if(arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]) { // If arr[mid] is not equal to next and previous element then it is the single element.
        return arr[mid];
      }
      // if mid is odd, previous element should be equal.
      // Or If mid is even, then next element should be equal.
      // If any of above case is passed then, go to right as single element we will get on right part of arr
      else if ( ( mid % 2 == 1 && arr[mid] == arr[mid - 1] ) || ( mid % 2 == 0 && arr[mid] == arr[mid + 1] ) ) {
        low = mid + 1;
      } else { // Else go to left as single element we will get on left part of arr
        high = mid - 1;
      }
    }

    return -1; // This line will never be executed.
  }
}
