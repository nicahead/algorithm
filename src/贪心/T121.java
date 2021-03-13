package 贪心;

//121. 买卖股票的最佳时机
public class T121 {
    // 它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0;
        int min = prices[0]; // 记录当前股价的最小值
        int max = 0;  //记录当前利润的最大值
        // 一次遍历，贪心求解
        for (int i = 1; i < n; i++) {
            // 若遇到更低的价格，则更新
            min = Math.min(min, prices[i]);
            // 若遇到更高的利润，则更新
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
}
