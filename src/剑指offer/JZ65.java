package 剑指offer;

/**
 * 剑指 Offer 65. 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * https://www.jianshu.com/p/157cc4c12181
 */
public class JZ65 {
    public int add(int a, int b) {
        /* 不进位加法可以使用异或表示 a ^ b
            0+0=0
            0+1=1
            1+0=1
            1+1=0
           进位可用与运算表示 a&b
            0+0 不进位
            0+1 不进位
            1+0 不进位
            1+1 进位
           那么a+b = (a^b)+(a&b<<1)
           对于两位数来说，比如11+01=100
           11^01=10
           11&01<<1=10
           10+10还需要执行一遍(a^b)+(a&b<<1)
           10^10=00
           10&10<<1=100
         */
        int sum = a ^ b;
        // 注意要加括号
        int carry = (a & b) << 1;
        // 进位为0时跳出
        while (carry != 0) {
            int tempSum = sum;
            int tempCarry = carry;
            sum = tempSum ^ tempCarry;
            carry = (tempSum & tempCarry) << 1;
        }
        return sum;
    }
}
