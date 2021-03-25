package 剑指offer;

import java.util.ArrayList;
import java.util.List;

/*
剑指 Offer 57 - II. 和为s的连续正数序列
输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 */
public class JZ57_2 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int i = 1, j = 2;
        int sum = 3;
        while (i < j) {
            if (target == sum) {
                int[] newAns = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    newAns[k - i] = k;
                }
                res.add(newAns);
            }
            if (target > sum) {
                j++;
                // 移动后加上新的值
                sum += j;
            } else if (target <= sum) {
                // 减去之前的i，注意相等的时候也要减去，这个时候以这个数字开头的解已经找到，所以左边缘右移找新的解
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
