package 剑指offer;

/**
 * 剑指 Offer 49. 丑数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 */
public class JZ49 {

    public int nthUglyNumber(int n) {
        // 下个应该通过乘2来获得新丑数的数据是第a个， 同理b, c
        int a = 0, b = 0, c = 0;
        // dp[n]表示第n个丑数
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            // 第a个丑数通过乘2得到下个丑数newA
            int newA = dp[a] * 2;
            int newB = dp[b] * 3;
            int newC = dp[c] * 5;
            // 下个丑数是得到的三个新丑数中最小的那个
            dp[i] = Math.min(Math.min(newA, newB), newC);
            // 第a个数已经通过乘2得到了一个新的丑数，那下个需要通过乘2得到一个新的丑数的数应该是第(a+1)个数
            if (dp[i] == newA) a++;
            if (dp[i] == newB) b++;
            if (dp[i] == newC) c++;
        }
        return dp[n - 1];
    }
}
