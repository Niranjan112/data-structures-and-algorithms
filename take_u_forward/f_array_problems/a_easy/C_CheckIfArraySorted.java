package take_u_forward.f_array_problems.a_easy;

public class C_CheckIfArraySorted {

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6};

    System.out.println("Is the array sorted? " + checkIfSorted(arr)); // O(n) time complexity and O(1) space complexity
  }

  public static boolean checkIfSorted(int[] arr) {
    if(arr.length < 2) {
      return true;
    }

    for (int i = 0; i < arr.length - 1; i++) {
      if(arr[i] > arr[i+1]) {
        return false;
      }
    }

    return true;
  }
}
