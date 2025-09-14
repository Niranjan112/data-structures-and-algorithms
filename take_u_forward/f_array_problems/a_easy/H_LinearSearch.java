package take_u_forward.f_array_problems.a_easy;

public class H_LinearSearch {

  public static void main(String[] args) {
    int[] arr = {4,5,56,6,10,8,1};

    searchNum(arr, 10); // O(n) time complexity and O(1) space complexity
  }


  public static void searchNum(int[] arr, int numToSearch) {

    for (int i = 0; i < arr.length; i++) {
      if(arr[i] == numToSearch) {
        System.out.println(numToSearch + " is present at index " + i);
        break;
      }
    }
  }
}
