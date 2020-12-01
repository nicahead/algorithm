//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。 
//
// 示例 1: 
//
// 输入: 123
//输出: 321
// 
//
// 示例 2: 
//
// 输入: -123
//输出: -321
// 
//
// 示例 3: 
//
// 输入: 120
//输出: 21
// 
//
// 注意: 
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31, 2^31 − 1]。
// 请根据这个假设，如果反转后整数溢出那么就返回 0。
// Related Topics 数学 
// 👍 2379 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        int res = 0;
        // max = 2147483647
        // min = -2147483648
        double max = Math.pow(2, 31) - 1, min = -Math.pow(2, 31);
        while (x != 0) {
            int temp = x % 10;
            // 如果前9位已经大于max的前九位|| 前9位等于max的前九位，最后一位大于max的最后一位
            // 则没必要继续计算，直接判断溢出
            if (res > max / 10 || (res == max / 10 && temp > 7))
                return 0;
            // 如果前9位已经小于min的前九位|| 前9位等于min的前九位，最后一位大于max的最后一位
            if (res < min / 10 || (res == min / 10 && temp > 8))
                return 0;
            x = x / 10;
            res = res * 10 + temp;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
