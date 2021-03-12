package 动态规划;

//300. 最长递增子序列
public class T300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // "以每一个位置为结尾的"最长递增子序列的长度
        int[] dp = new int[n];
        dp[0] = 1;
        // 整个数组的最长上升子序列即所有 dp[i] 中的最大值
        int maxL = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // 更新最大值
            maxL = Math.max(dp[i], maxL);
        }
        return maxL;
    }
}
