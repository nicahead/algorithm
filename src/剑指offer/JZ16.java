package 剑指offer;

//剑指 Offer 16. 数值的整数次方
//非递归快速幂 https://zhuanlan.zhihu.com/p/95902286
public class JZ16 {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        // Java 代码中 int32 变量 n ∈ [−2147483648,2147483647]
        // 因此当 n = -2147483648 时执行 n = -n 会因越界而赋值出错。解决方法是先将 n 存入 long 变量 b ，后面用 b 操作即可。
        long b = n;
        double res = 1;
        // 若n为负数，先转化
        if (b < 0) {
            b = -b;
            x = 1 / x;
        }
        while (b != 0) {
            // 如果n的二进制形式最后一位是1
            if ((b & 1) == 1) {
                res = res * x;
            }
            // n二进制右移一位(删除最后一位)，则底数x需要平方
            b = b >> 1;
            x = x * x;
        }
        return res;
    }
}
