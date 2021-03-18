package 剑指offer;

//剑指 Offer 15. 二进制中1的个数
public class JZ15 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // 根据 与运算 定义，设二进制数字 n ，则有：
        // 若 n & 1 = 0 ，则 n 二进制 最右一位 为 0 ；
        // 若 n & 1 = 1 ，则 n 二进制 最右一位 为 1 。
        // <<表示左移，不分正负数，低位补0
        // >>表示右移，如果该数为正，则高位补0，若为负数，则高位补1
        // >>>表示无符号右移，也叫逻辑右移，即若该数为正，则高位补0，而若该数为负数，则右移后高位同样补0
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) count++;
            n = n >>> 1;
        }
        return count;
    }
}
