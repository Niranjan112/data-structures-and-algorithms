package take_u_forward.g_binary_search.b_answer.b;

public class FindNthRootOfNum {

  public static void main(String[] args) {
    int n = 3;
    int m = 27;

    System.out.println(" " + bruteForceApproach(n , m) + " is the root of " + m); // TC: O(m * log2n) and SC: O(1)
    System.out.println(" " + optimalApproach(n , m) + " is the root of " + m); // TC: O(log m * log2n) and SC: O(1)
  }

  public static int bruteForceApproach(int n, int m) {
    for (int i = 1; i <= m; i++) {
      int powerNum = (int) Math.pow(i, n);
      if(powerNum == m) {
        return i;
      } else if(powerNum > m) {
        return -1;
      }
    }

    return 0;
  }

  public static int optimalApproach(int n, int m) {
    int low = 1;
    int high = m;

    while (low <= high) {
      int mid = (low + high) / 2;
      int powerNum = (int) Math.pow(mid, n);
      if(powerNum == m) {
        return mid;
      } else if(powerNum < m) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return 0;
  }
}
