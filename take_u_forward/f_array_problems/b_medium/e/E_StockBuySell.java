package take_u_forward.f_array_problems.b_medium.e;

public class E_StockBuySell {

  public static void main(String[] args) {
    /*
    * 121. Best Time to Buy and Sell Stock
    * Problem Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
    *
    * For explanation check TUF
    * */

    int[] arr = {7,1,5,3,6,4};

    bruteForceApproach(arr); // O(N ^ 2) time complexity and O(1) space complexity.
    optimalApproach(arr); // O(N) time complexity and O(1) space complexity.
  }

  public static void bruteForceApproach(int[] arr) {
    int maxProfit = Integer.MIN_VALUE;

    /*
    * Select every index and then check forward in other index if we get any maxProfit.
    * */
    int profit;
    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length; j++) {

        if(arr[j] >= arr[i]) {

          profit = arr[j] - arr[i];

          if(profit > maxProfit) {
            maxProfit = profit;
          }
        }
      }
    }

    System.out.println("Max Profit: " + maxProfit);
  }

  public static void optimalApproach(int[] arr) {
    int maxProfit = Integer.MIN_VALUE;
    int minPrice = Integer.MAX_VALUE;

    int profit;

    for (int i = 0; i < arr.length; i++) {
      // Every iteration check for current number if it less than current minPrice update it as min price.
      minPrice = Math.min(minPrice, arr[i]);

      profit = arr[i] - minPrice; // Calculate profit with current number and updated min price.
      maxProfit = Math.max(maxProfit, profit); // If profit is bigger than maxProfit then update maxProfit.
    }

    System.out.println("Max Profit: " + maxProfit);
  }
}
