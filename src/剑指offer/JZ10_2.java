package 剑指offer;

//剑指 Offer 10- II. 青蛙跳台阶问题
public class JZ10_2 {
    public int numWays(int n) {
        if (n == 0) return 1;
        int[] dp = new int[n];
        dp[0] = 1;
        if (n > 1) dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] = dp[i] % 1000000007;
        }
        return dp[n - 1];
    }
}
