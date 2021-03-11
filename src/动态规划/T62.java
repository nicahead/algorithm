package 动态规划;

//62. 不同路径
//计数型动态规划
public class T62 {
    public int uniquePaths(int m, int n) {
        // 1.使用数组记录
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 2.初始条件 dp[0][0] = 1
                // 3.边界条件，第一行（只能向右）或第一列（只能向下）
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    // 4.转移方程 f[i][j] = f[i-1][j] + f[i][j-1]
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
