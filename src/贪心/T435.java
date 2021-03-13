package 贪心;

import java.util.Arrays;

//435. 无重叠区间
public class T435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        // 先按第一位排序，再按第二位排序
        // Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int res = 0;
        int left = intervals[intervals.length - 1][0];
        for (int i = intervals.length - 1; i > 0; i--) {
            if (left < intervals[i - 1][1]) {
                // 需要移除一个
                res++;
                // 为了防止在下一个区间和现有区间有重叠，我们应该让现有区间越短越好，所以应该移除头部比较小的，保留头部比较大的
                left = Math.max(intervals[i - 1][0], left);
            } else {
                // 更新left
                left = intervals[i - 1][0];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        Arrays.sort(nums, (a, b) -> a[0] - b[0]);
        Arrays.sort(nums, (a, b) -> a[1] - b[1]);
    }
}
