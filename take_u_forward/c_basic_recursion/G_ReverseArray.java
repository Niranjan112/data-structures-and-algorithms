package take_u_forward.c_basic_recursion;

import java.util.Arrays;

public class G_ReverseArray {

  public static void main(String[] args) {
    int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int[] arr2 = {1, 2, 3, 4, 5};
    int[] arr3 = {1,2};

    System.out.println(
        "Reversed array is: " + Arrays.toString(
            reverseArray(arr1, 0, arr1.length - 1)
        )
    );

    System.out.println(
        "Reversed array is: " + Arrays.toString(
            reverseArray(arr2, 0, arr2.length - 1)
        )
    );

    System.out.println(
        "Reversed array is: " + Arrays.toString(
            reverseArray(arr3, 0, arr3.length - 1)
        )
    );

    // Time complexity: O(n/2)
  }

  public static int[] reverseArray(int[] arr, int startIndex, int endIndex)  {
    /*
    * In case of odd size array, middle element will not be swapped.
    * and start index and end index will get same at one point.
    * For example, if array is of size 5, then start index will be 0 and end index will be 4.
    * So, at one point, start index will become 2 and end index will become 2.
    * So, we can stop the recursion at that point.
    *
    * In case of even size array, start index and end index will never be same.
    * and start index will become greater than end index at one point.
    * For example, if array is of size 10, then start index will be 0 and end index will be 9.
    * So, at one point, start index will become 5 and end index will become 4.
    * So, we can stop the recursion at that point.
    * */
    if(startIndex > endIndex) {
      return arr;
    }

    int temp = arr[startIndex];
    arr[startIndex] = arr[endIndex];
    arr[endIndex] = temp;

    return reverseArray(arr, startIndex + 1, endIndex - 1);
  }
}
