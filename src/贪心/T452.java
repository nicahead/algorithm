package 贪心;

import java.util.Arrays;
import java.util.Comparator;

//452. 用最少数量的箭引爆气球
public class T452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        // [[-2147483646,-2147483645],[2147483646,2147483647]]
        // 这条用例会溢出，所以不能直接减
        // Arrays.sort(points, (a, b) -> a[1] - b[1]);
        // 为什么按右端升序排序（https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/solution/tu-jie-tan-tao-wei-shi-yao-yao-an-qu-jian-de-you-d/）
        Arrays.sort(points, (a, b) -> a[1] > b[1] ? 1 : -1);
        int res = 1;
        int right = points[0][1];
        for (int i = 0; i < points.length - 1; i++) {
            // 没交集，新的一段
            if (points[i + 1][0] > right) {
                right = points[i + 1][1];
                res++;
            }
            // 其他就是和前面一直有交集的情况
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2}, {4, 5}, {1, 5}};
        T452 t452 = new T452();
        System.out.println(t452.findMinArrowShots(nums));
    }
}
