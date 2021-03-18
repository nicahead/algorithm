package 剑指offer;

//剑指 Offer 14- I. 剪绳子
public class JZ14 {
    public int cuttingRope(int n) {
        // dp[i]表示长度为i的绳子剪成m段后的最大乘积
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            // 先把绳子剪掉第一段（长度为j）
            // 剩下(i - j)长度可以剪也可以不剪。如果不剪的话长度乘积即为j * (i - j)；如果剪的话长度乘积即为j * dp[i - j]。取两者最大值
            for (int j = 2; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}
