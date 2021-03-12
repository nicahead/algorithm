package 动态规划;

import java.util.Arrays;

//646. 最长数对链
public class T646 {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int maxL = 1;
        // 根据第一个元素排序，为什么要排序？
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxL = Math.max(maxL, dp[i]);
        }
        return maxL;
    }
}
