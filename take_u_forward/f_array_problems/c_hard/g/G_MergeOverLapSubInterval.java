package take_u_forward.f_array_problems.c_hard.g;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class G_MergeOverLapSubInterval {

  public static void main(String[] args) {
    /*
     *
     * 56. Merge Intervals
     * Problem Link: https://leetcode.com/problems/merge-intervals/description/
     *
     * For detailed explanation check TUF
     * */
    int[][] intervals = { {1, 3}, {2, 6}, {8 ,9}, {9, 11}, {8, 10}, {2, 4}, {15, 18}, {16, 17}};

    bruteForceApproach(intervals); // TC: O(n log n + 2n) and SC: O(n)
    optimalApproach(intervals); // TC: O(n log n + n) and SC: O(n)
  }

  public static void bruteForceApproach(int[][] intervals) {
    // Note: For visual explanation check merge_sub_interval_bruteforce.jpg
    List<List<Integer>> result = new ArrayList<>();

    Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

    for (int i = 0; i < intervals.length; i++) {
      int start = intervals[i][0];
      int end = intervals[i][1];

      if(!result.isEmpty() && end <= result.getLast().get(1)) {
        continue;
      }

      for (int j = i + 1; j < intervals.length; j++) {
        if(intervals[j][0] <= end) {
          end = Math.max(end, intervals[j][1]);
        } else {
          break;
        }
      }

      result.add(Arrays.asList(start, end));
    }

    // Converting List<List<Integer>> into int[][]
    int[][] array = result.stream()
        .map(inner -> inner.stream().mapToInt(Integer::intValue).toArray())
        .toArray(int[][]::new);

    System.out.println(array);
  }

  public static void optimalApproach(int[][] intervals) {
    // Note: For visual explanation check merge_sub_interval_optimal.jpg
    List<List<Integer>> result = new ArrayList<>();

    Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

    for (int i = 0; i < intervals.length; i++) {
      int start = intervals[i][0];
      int end = intervals[i][1];

      if(!result.isEmpty() && start <= result.getLast().get(1)) {
        end = Math.max(end, result.getLast().get(1));
        result.getLast().set(1, end);
      } else {
        result.add(Arrays.asList(start, end));
      }
    }

    // Converting List<List<Integer>> into int[][]
    int[][] array = result.stream()
        .map(inner -> inner.stream().mapToInt(Integer::intValue).toArray())
        .toArray(int[][]::new);

    System.out.println(array);
  }
}
