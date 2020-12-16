package 数学;

//7. 整数反转
public class T7 {
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
