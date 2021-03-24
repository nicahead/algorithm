package 剑指offer;

/*
剑指 Offer 63. 股票的最大利润
假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 */
public class JZ63 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            // 更新股价最低值
            minPrice = Math.min(minPrice, prices[i]);
            // 更新最大利润
            res = Math.max(res, prices[i] - minPrice);
        }
        return res;
    }
}
