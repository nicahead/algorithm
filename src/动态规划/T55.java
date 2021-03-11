package 动态规划;

// 55. 跳跃游戏
// 存在型动态规划
public class T55 {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        // 初始情况
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            // 初始为false，以下每一种可能有一个满足则更改为true
            dp[i] = false;
            // source是i，target是j
            for (int j = 0; j < i; j++) {
                // i - j <= nums[j]表示从j可以跳到i
                // dp[j] == true表示source必须是可到达的
                if (i - j <= nums[j] && dp[j] == true) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }
}
