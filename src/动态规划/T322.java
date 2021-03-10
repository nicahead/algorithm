package 动态规划;

//322. 零钱兑换
public class T322 {
    public int coinChange(int[] coins, int amount) {
        // 0...amount
        int[] f = new int[amount + 1];
        // 初始条件
        f[0] = 0;
        for (int i = 1; i <= amount; i++) {
            // 初始设为无穷大
            f[i] = Integer.MAX_VALUE;
            // 所有可能的硬币
            for (int j = 0; j < coins.length; j++) {
                // f下标不能为负数 && Integer.MAX_VALUE + 1会溢出
                if (i - coins[j] >= 0 && f[i - coins[j]] != Integer.MAX_VALUE) {
                    // 转移方程 f[i] = min{f[i-coins[0]]+1,...,f[i-coins[n-1]]+1}
                    f[i] = Math.min(f[i - coins[j]] + 1, f[i]);
                }
            }
        }
        if (f[amount] == Integer.MAX_VALUE) {
            f[amount] = -1;
        }
        return f[amount];
    }
}
