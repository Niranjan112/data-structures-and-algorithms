package take_u_forward.g_binary_search.b_answer.m;

public class KthElementOfTwoSortedArr {

  public static void main(String[] args) {
    int[] arr1 = {2, 3, 6, 7, 9};
    int[] arr2 = {1, 4, 8, 10};

    int position = 5;

    betterApproach(arr1, arr2, position);
    System.out.println("Element at position " + position + " is " + optimalApproach(arr1, arr2, position));
  }

  public static void betterApproach(int[] arr1, int[] arr2, int position) {
    int i = 0;
    int j = 0;

    int k = 0;
    int lastNum = -1;

    while (k < position) {

      if (i < arr1.length && j < arr2.length) { // Always check that i and j should be below their array length
        if (arr1[i] < arr2[j]) {
          lastNum = arr1[i++];
        } else {
          lastNum = arr2[j++];
        }
      }
      else if (i < arr1.length) { // If we iterated all element from arr2 and still some number are required from arr1 then keep taking it until we reach the required position
        lastNum = arr1[i++];
      }
      else { // If we iterated all element from arr1 and still some number are required from arr2 then keep taking it until we reach the required position.
        lastNum = arr2[j++];
      }

      k++;
    }

    System.out.println("Element at position " + position + " is " + lastNum);
  }

  public static int optimalApproach(int[] arr1, int[] arr2, int position) {
    int arr1Len = arr1.length;
    int arr2Len = arr2.length;

    // If arr2 is smaller in length than arr1 then just putting arr2 to arr1. As we have to do binary search on smaller array.
    // In simple words, just trying to find out smaller array and using it for binary search.
    if(arr1Len > arr2Len) {
      return optimalApproach(arr2, arr1, position);
    }

    // The left halve length of a merged arr length. We need at most element till position given on left halve to get given position element.
    int leftHalveLenOfArr = position;

    int low = Math.max(0, position - arr2Len); // If the position is bigger than the length of arr2 then we need remaining element from arr1 to perform search;
    int high = Math.min(position, arr1Len); // Whatever is minimum either position or arr1 len we keep it as high

    while (low <= high) {
      int mid1 = (low + high) / 2; // Mid index for arr1
      int mid2 = leftHalveLenOfArr - mid1; // Mid index for arr2

      // l1 and l2 should always be less than r2 and r1 respectively. So will consider min value for l1 and l2 if mid1 - 1 or mid2 - 1 goes below 0 index.
      int l1 = Integer.MIN_VALUE; int l2 = Integer.MIN_VALUE;
      // r1 and r2 should be more than l2 and l1 respectively. So will consider max value for r1 and r2 if mid1 or mid2 goes out of arr index.
      int r1 = Integer.MAX_VALUE; int r2 = Integer.MAX_VALUE;

      if(mid1 < arr1Len) r1 = arr1[mid1]; // If mid1 is in under arr1Len index then assign arr1 mid1 value to r1;
      if(mid2 < arr2Len) r2 = arr2[mid2]; // If mid2 is in under arr2Len index then assign arr2 mid2 value to r2;

      if(mid1 - 1 >= 0) l1 = arr1[mid1 - 1]; // If mid1 - 1 is not getting below 0 then assign arr1 mid1 - 1 value to l1
      if(mid2 - 1 >= 0) l2 = arr2[mid2 - 1]; // If mid2 - 1 is not getting below 0 then assign arr2 mid2 - 1 value to l2

      if(l1 <= r2 && l2 <= r1) { // If left have max values are less than right halve min value then we got our perfect partition

        return Math.max(l1, l2);

      } else if(l1 > r2) { // Go to left side in arr1
        high = mid1 - 1;
      } else { // If l2 > r1 then go to right side in arr1
        low = mid1 + 1;
      }
    }

    return 0; // This will never reach
  }
}
