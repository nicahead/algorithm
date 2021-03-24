package 剑指offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
剑指 Offer 60. n个骰子的点数
把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 */
public class JZ60 {
    // 单纯使用递归搜索解空间的时间复杂度为 6^n 会造成超时错误，因为存在重复子结构。
//    public double[] dicesProbability(int n) {
//        double[] res = new double[6 * n - n + 1];
//        // 当前骰子点数之和
//        int sum = 0;
//        // 记录所有骰子点数和
//        Map<Integer, Integer> solutions = new HashMap<>();
//        backTrace(n, sum, solutions);
//        // 根据所有情况计算概率
//        for (int i = n; i <= 6 * n; i++) {
//            res[i - n] = solutions.get(i) / Math.pow(6, n);
//        }
//        return res;
//    }
//
//    private void backTrace(int n, int sum, Map<Integer, Integer> solutions) {
//        // 更新该点数和出现的次数
//        if (n == 0) {
//            int count = 0;
//            if (solutions.containsKey(sum)) {
//                count = solutions.get(sum);
//            }
//            solutions.put(sum, ++count);
//            return;
//        }
//        // 回溯
//        for (int i = 1; i <= 6; i++) {
//            sum += i;
//            backTrace(n - 1, sum, solutions);
//            sum -= i;
//        }
//        return;
//    }

    public double[] dicesProbability(int n) {
        // dp[i][j]表示i+1个骰子掷出的点数和为j的个数（方案数）
        int[][] dp = new int[n][6 * n];
        double[] res = new double[6 * n - n + 1];
        // 边界值
        for (int i = 0; i < 6; i++) {
            dp[0][i] = 1;
        }
        // 逐层遍历
        for (int i = 1; i < n; i++) {
            // 前一阶段的点数转移到下一阶段，最小是(i)+1,最大是(i*6)+6,但是数组下标从0开始，所以j从i到(i*6)+6-1
            for (int j = i; j < (i + 1) * 6; j++) {
                // j = (j-1)+1 或 (j-2)+2 或 (j-3)+3 ...
                // dp[i][j] = dp[i-1][j-1]+dp[i-1][j-2]+...+dp[i-1][j-6]
                for (int k = 1; k <= 6; k++) {
                    // 前一个j如果太小，则会少几种可能
                    // j - k = 0代表的是j比k大1的情况，比如1到2，对应到数组则会减1
                    if (j - k >= 0) {
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }
        }
        // 计算概率
        double all = Math.pow(6, n);
        for (int i = 0; i < res.length; i++) {
            res[i] = dp[n - 1][n - 1 + i] / all;
        }
        return res;
    }

    public static void main(String[] args) {
        JZ60 jz60 = new JZ60();
        jz60.dicesProbability(2);
    }
}
