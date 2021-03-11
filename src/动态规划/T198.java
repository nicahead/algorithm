package 动态规划;

//198. 打家劫舍
public class T198 {
    public int rob(int[] nums) {
        int N = nums.length;
        // dp[i]表示前 i 间房屋能偷窃到的最高总金额
        int[] dp = new int[N];
        // 初始情况
        dp[0] = nums[0];
        if (N > 1) dp[1] = Math.max(nums[0], nums[1]);
        // 对于i>2的情况
        // 偷窃第 k 间房屋，那么就不能偷窃第 k-1 间房屋，偷窃总金额为前 k-2 间房屋的最高总金额与第 k 间房屋的金额之和。
        // 不偷窃第 k 间房屋，偷窃总金额为前 k-1 间房屋的最高总金额。
        for (int i = 2; i < N; i++) {
            // 默认值，若有更好的方案则更新
            dp[i] = dp[i - 1];
            for (int j = 0; j < i - 1; j++) {
                dp[i] = Math.max(dp[j] + nums[i], dp[i]);
            }
        }
        return dp[N - 1];
    }
}
